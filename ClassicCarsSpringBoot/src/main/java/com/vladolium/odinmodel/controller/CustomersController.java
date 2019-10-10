package com.vladolium.odinmodel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.format.annotation.*;
import java.time.*;
import java.util.*;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Customers;
import com.vladolium.odinmodel.domain.Customers.*;
import com.vladolium.odinmodel.service.CustomersService;
import com.vladolium.odinmodel.service.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/customers")
public class CustomersController {

	private CustomersService customersService;

	@Autowired
	public void setCustomersService(CustomersService customersService) {
		this.customersService = customersService;
	}

	@PostMapping("")
	public Customers createOne(@RequestBody Customers customers) {
		return customersService.createUpdate(customers);
	}
	@PutMapping("/{id}")
	public Customers updateOneById(@PathVariable Long id, @RequestBody Customers customers) {
		Customers current = customersService.readOneById(id);
		current.setEmployees(customers.getEmployees());
		current.setReviewsList(customers.getReviewsList());
		
		
		current.setPhone(customers.getPhone());
		
		current.setLastName(customers.getLastName());
		
		current.setAddressLine1(customers.getAddressLine1());
		
		current.setCreditLimit(customers.getCreditLimit());
		
		current.setCountry(customers.getCountry());
		
		current.setAddressLine2(customers.getAddressLine2());
		
		current.setCity(customers.getCity());
		
		current.setFirstName(customers.getFirstName());
		
		current.setCustomerName(customers.getCustomerName());
		
		current.setState(customers.getState());
		
		current.setPostalCode(customers.getPostalCode());
					
		return customersService.createUpdate(current);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@PutMapping("/customerName={customerName}")
	public Customers updateOneByCustomerName(@PathVariable String customerName, @RequestBody Customers customers) {
		Customers current = customersService.readOneByCustomerName(customerName);
		current.setEmployees(customers.getEmployees());
		current.setReviewsList(customers.getReviewsList());
				
		
		current.setPhone(customers.getPhone());
		
		current.setLastName(customers.getLastName());
		
		current.setAddressLine1(customers.getAddressLine1());
		
		current.setCreditLimit(customers.getCreditLimit());
		
		current.setCountry(customers.getCountry());
		
		current.setAddressLine2(customers.getAddressLine2());
		
		current.setCity(customers.getCity());
		
		current.setFirstName(customers.getFirstName());
		
		current.setCustomerName(customers.getCustomerName());
		
		current.setState(customers.getState());
		
		current.setPostalCode(customers.getPostalCode());
		
		return customersService.createUpdate(current);
	}
	
	
	
	@GetMapping("/{id}")
	public Customers readOneById(@PathVariable Long id) {
		return customersService.readOneById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/customerName={customerName}")
	public Customers readOneByCustomerName(@PathVariable String customerName) {
		return customersService.readOneByCustomerName(customerName);
	}
	
	
	
	@GetMapping("")
	public Iterable<Customers> readAll() {
		return customersService.readAll();
	}
	
	@GetMapping("/page={pageNumber}/perPage={perPageNumber}")
	public Page<Customers> readAllPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return customersService.readAllPagination(page);
	}
	
	
	
	
	
	
	@GetMapping("/search")
	public Iterable<Customers> search(
		
		
		
		
		
		
		@RequestParam(value = "employeesId", required = false) Long employeesId,
		
		@RequestParam(value = "reviewsList", required = false) List<Reviews> reviewsList,
		@RequestParam(value = "city", required = false) String city,
		@RequestParam(value = "firstName", required = false) String firstName,
		@RequestParam(value = "phone", required = false) String phone,
		@RequestParam(value = "lastName", required = false) String lastName,
		@RequestParam(value = "addressLine1", required = false) String addressLine1,
		@RequestParam(value = "customerName", required = false) String customerName,
		@RequestParam(value = "creditLimit", required = false) Double creditLimit,
		@RequestParam(value = "country", required = false) String country,
		@RequestParam(value = "addressLine2", required = false) String addressLine2,
		@RequestParam(value = "state", required = false) String state,
		@RequestParam(value = "postalCode", required = false) String postalCode
		
	) {
		return customersService.search(
			
			
			
			
			
			
			employeesId,
			
			reviewsList,
			city,
			firstName,
			phone,
			lastName,
			addressLine1,
			customerName,
			creditLimit,
			country,
			addressLine2,
			state,
			postalCode
			
		);
	}
	@DeleteMapping("/{id}")
	public void deleteOneById(@PathVariable Long id) {
		customersService.deleteOneById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code
}
