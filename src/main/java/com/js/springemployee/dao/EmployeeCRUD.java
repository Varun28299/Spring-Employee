package com.js.springemployee.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.js.springemployee.dto.Employee;
import com.js.springemployee.repository.EmployeeRepository;

@Repository
public class EmployeeCRUD {
	
	@Autowired                    //to get the object of mentioned class(container will create the object)
	EmployeeRepository repository;

	public Employee insertEmployee(Employee e) {
		return repository.save(e);
	}
	public List<Employee> getEmployees(){
		return repository.findAll();
	}
	
	
	public Employee getEmployeeById(int id) {
		Optional<Employee> op=repository.findById(id); //this repository find method return optinal class object, so we are receiving it.
		if(op.isPresent()) {
			return op.get();
		}else {
			return null;
		}
	}
	
	public boolean deleteEmployeeById(int id) {
		Optional<Employee> op=repository.findById(id);
		
		if(op.isPresent()) {
			Employee e=op.get();
			repository.delete(e);
			return true;
		}else {
			return false;
		}
	}
	
	public Employee updateEmployee(Employee e) {
		return repository.save(e);
	}
	
	
}
