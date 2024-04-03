package com.test.mbb.employee;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;

@Component
public class EmployeeService 
{
	private final EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository)
	{
		this.employeeRepository=employeeRepository;
	}
	
	public List<Employee> getEmployees()
	{
		return employeeRepository.findAll();
	}

	public String addEmployee(Employee employee) 
	{
		System.out.print(employee);
		Optional<Employee> employeeOptional = employeeRepository.findEmployeeByEmail(employee.getEmail());
		if(employeeOptional.isPresent())
		{
			return new EmployeeError(101).toString();
		}
		employeeRepository.save(employee);
		return new EmployeeError(0).toString();
	}

	public String deleteStudent(Long id) 
	{
		// TODO Auto-generated method stub
		boolean exists = employeeRepository.existsById(id);
		if(!exists)
		{
			return new EmployeeError(102).toString();
		}
		
		employeeRepository.deleteById(id);
		return new EmployeeError(0).toString();
	}
	
	@Transactional
	public String updateEmployee(Long id, String name, String email) 
	{
		// TODO Auto-generated method stub	
		Optional<Employee> employeeOptional = employeeRepository.findById(id);
		if(!employeeOptional.isPresent())
		{
			return new EmployeeError(102).toString();
		}
		
		Employee employee = employeeOptional.get();
		
		if(name!=null && name.length()>0 && !Objects.equals(name,employee.getName()))
		{
			employee.setName(name);
		}
		
		if(email!=null && email.length()>0 && !Objects.equals(email,employee.getEmail()))
		{
			Optional<Employee> employeeOptional1 = employeeRepository.findEmployeeByEmail(email);
			if(employeeOptional1.isPresent())
			{
				return new EmployeeError(101).toString();
			}
			
			employee.setEmail(email);
		}
		return new EmployeeError(0).toString();
	}
	
	public Employee getEmployee(Long id)
	{
		return employeeRepository.findById(id).orElseThrow(()->new IllegalStateException(new EmployeeError(102).toString()));
	}
}
