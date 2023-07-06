package com.js.springemployee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.js.springemployee.dto.Address;
import com.js.springemployee.service.AddressService;

@RestController
public class AddressController {

	@Autowired
	AddressService service;
	
	@PostMapping("/address/id")
	public Address insertAddress(@PathVariable int id,@RequestBody Address a) {
		return service.insertAddress(id, a);
	}
   
	@GetMapping("/address{1}")
	public Address getAddress(int id) {
		
		return service.getAddress(id);
	}

}
