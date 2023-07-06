package com.js.springemployee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.js.springemployee.dto.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query("select e from Employee e where e.name=:ename")    //to perform our own crud operation other than 5 basic crud operations
	public Employee findByName(@Param("ename") String ename);  //create a abstract method and using query annotation write query-->JPQL query.(here we are find employee by name and receiving there name using param annotation)
}