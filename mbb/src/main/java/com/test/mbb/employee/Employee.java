package com.test.mbb.employee;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;


@Entity
@Table
public class Employee 
{
	@Id
	@SequenceGenerator(name="employee_sequence",sequenceName = "employee_sequence",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "employee_sequence")
	private long id;
	private String name;
	private String email;
	private String phoneNo;
	private String department;
	private LocalDate dob;
	@Transient
	private Integer age;
	
	public Employee(){}
	
	
	
	public Employee(long id, String name, String email, String phoneNo, String department, LocalDate dob) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
		this.department = department;
		this.dob = dob;
	}



	public Employee(String name, String email, String phoneNo, String department, LocalDate dob) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
		this.department = department;
		this.dob = dob;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhoneNo() {
		return phoneNo;
	}



	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}



	public String getDepartment() {
		return department;
	}



	public void setDepartment(String department) {
		this.department = department;
	}



	public LocalDate getDob() {
		return dob;
	}



	public void setDob(LocalDate dob) {
		this.dob = dob;
	}



	public Integer getAge() 
	{
		return Period.between(this.dob,LocalDate.now()).getYears();
	}



	public void setAge(Integer age) {
		this.age = age;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", phoneNo=" + phoneNo + ", department="
				+ department + ", dob=" + dob + ", age=" + getAge() + "]";
	}
	
	
	
	
	
}
