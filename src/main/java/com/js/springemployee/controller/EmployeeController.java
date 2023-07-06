package com.js.springemployee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.js.springemployee.dto.Employee;
import com.js.springemployee.dto.ResponseStructure;
import com.js.springemployee.service.EmployeeService;

@RestController                     //helps to search for rest api's
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@PostMapping("/employes")                              //rest api
	public ResponseStructure<Employee> insertEmployee(@RequestBody Employee e){//reading the object so use this annotation
	return service.insertEmployee(e);
	}
	
	@GetMapping("/employes")
	public List<Employee> getEmployees(){
		
		return service.getEmployees();
	}
	
	@GetMapping("/employes/{id}")//this are rest end points i.e., url's
	public ResponseStructure<Employee> getEmpoyeeById(@PathVariable int id)
	{
		return service.getEmployeeById(id);
	}

  @DeleteMapping("/employes")
  public String deleteEmployeeById(@RequestParam int id) {//to read the id from query string(receiving id from url we pass in post man) we are using requestparam

	  return service.deleteEmployeeById(id);
}
  
  @PutMapping("/employes")
  public Employee updateEmployee(@RequestBody Employee e) {
	  
	  return service.updateEmployee(e);
  }
}
