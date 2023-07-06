package com.js.springemployee.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.js.springemployee.dto.Employee;
import com.js.springemployee.dto.ResponseStructure;
import com.js.springemployee.exception.NoIdFoundException;
import com.js.springemployee.dao.EmployeeCRUD;

@Service
public class EmployeeService {

	@Autowired
	EmployeeCRUD crud;
	
	public ResponseStructure<Employee> insertEmployee(Employee e) {
	   ResponseStructure<Employee> response=new ResponseStructure<Employee>();
		e.setDoj(LocalDate.now());           //this is to read system date
		
		Employee em=crud.insertEmployee(e);
		if(em!=null) {
			response.setData(em);
			response.setMessage("Inserted Successfully");
			response.setStatusCode(HttpStatus.CREATED.value());  //Enum value
		}
		else {
			response.setData(null);
			response.setMessage("Failed to insert");
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
		}
		return response;
	}
	
	public List<Employee> getEmployees(){
		return crud.getEmployees();
	}
	
	public ResponseStructure<Employee> getEmployeeById(int id) {
		ResponseStructure<Employee> response=new ResponseStructure<Employee>();
		Employee e=crud.getEmployeeById(id);
		if(e!=null) {
			response.setData(e);
			response.setMessage("FOund");
			response.setStatusCode(HttpStatus.FOUND.value());
		
			return response;
		}else {
			throw new NoIdFoundException("Employee Not FOund");
		}
		
		
	}
	
	public String deleteEmployeeById(int id) {
		ResponseStructure<Employee> response=new ResponseStructure<Employee>();
		
		if(crud.deleteEmployeeById(id)) {
			response.setData(null);
			response.setMessage("Deleted");
			response.setStatusCode(HttpStatus.FOUND.value());
			return "DELETED";
		}
		else {
			return "EMPLOYEE NOT FOUND";
		}
	}
	
	public Employee updateEmployee(Employee e) {
		return crud.updateEmployee(e);
	}
}
