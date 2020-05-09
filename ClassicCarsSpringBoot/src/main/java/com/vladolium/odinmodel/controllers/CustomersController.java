package com.vladolium.odinmodel.controllers;

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Customers.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.format.annotation.*;

import java.time.*;
import java.util.*;

import com.vladolium.odinmodel.interfaces.*;
import com.vladolium.odinmodel.wrappers.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/customers")
public class CustomersController {

	private CustomersInterface customersInterface;

	@Autowired
	public void setCustomersInterface(CustomersInterface customersInterface) {
		this.customersInterface = customersInterface;
	}

	@PostMapping("")
	public Customers saveOne(@RequestBody Customers customers) {
		return customersInterface.saveOne(customers);
	}

	@DeleteMapping("/{id}")
	public void deleteOneById(@PathVariable Long id) {
		customersInterface.deleteOneById(id);
	}
	
	@GetMapping("/{id}")
	public Customers readOneById(@PathVariable Long id) {
		return customersInterface.readOneById(id);
	}
	
	@PutMapping("/{id}")
	public Customers updateOneById(@PathVariable Long id, @RequestBody Customers customers) {
		
		Customers current = customersInterface.readOneById(id);
			
		current.setEmployees(customers.getEmployees());
		
		
		current.setReviewsList(customers.getReviewsList());
		current.setCity(customers.getCity());
		current.setPhone(customers.getPhone());
		current.setAddressLine2(customers.getAddressLine2());
		current.setFirstName(customers.getFirstName());
		current.setCreditLimit(customers.getCreditLimit());
		current.setCustomerName(customers.getCustomerName());
		current.setAddressLine1(customers.getAddressLine1());
		current.setCountry(customers.getCountry());
		current.setLastName(customers.getLastName());
		current.setState(customers.getState());
		current.setPostalCode(customers.getPostalCode());
				
		return customersInterface.saveOne(current);
	}


	
//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code
}
