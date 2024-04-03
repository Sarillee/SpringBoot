package com.test.mbb.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.mbb.Util;

@RestController
@RequestMapping(path="api/v1/employee")
public class EmployeeController 
{	
	private final EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService)
	{
		this.employeeService = employeeService;
	}
	
	@GetMapping
	public List<Employee> getEmployees()
	{
		Util.writeLog("getEmployees", "",true);
		List<Employee> list = employeeService.getEmployees();
		Util.writeLog("getEmployees",list.toString(),false);
		return list;
	}
	
	
	@PostMapping
	public String addEmployee(@RequestBody Employee employee)
	{
		Util.writeLog("addEmployee",employee.toString(),true);
		String ret =  employeeService.addEmployee(employee);
		Util.writeLog("addEmployee",ret.toString(),false);
		return ret;
	}
	
	@DeleteMapping(path="{employeeId}")
	public String deleteEmployee(@PathVariable("employeeId") Long id)
	{
		Util.writeLog("addEmployee","id="+id,true);
		String ret =  employeeService.deleteStudent(id);
		Util.writeLog("addEmployee",ret.toString(),false);
		return ret;
	}
	
	@PutMapping(path = "{employeeId}")
	public String updateEmployee(@PathVariable("employeeId") Long id,@RequestParam(required = false) String name,@RequestParam(required = false) String email)
	{
		Util.writeLog("updateEmployee","id="+ id +",name" + name + ",email" + email,true);
		String ret =  employeeService.updateEmployee(id,name,email);
		Util.writeLog("updateEmployee",ret.toString(),false);
		return ret; 
	}
}
