package com.js.springemployee.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.js.springemployee.dto.Address;
import com.js.springemployee.repository.AddressRepository;

@Repository
public class AddressCRUD {
    
	@Autowired                    //depenendency
	AddressRepository repository;
	
	public Address insertAddress(Address a) {
		return repository.save(a);
	}
	
	public Address getAddress(int id) {
	Optional<Address> op	=repository.findById(id);
	
	if(op.isPresent()) {
		return op.get();
	}else {
		return null;
	}
	
	}
	
}
