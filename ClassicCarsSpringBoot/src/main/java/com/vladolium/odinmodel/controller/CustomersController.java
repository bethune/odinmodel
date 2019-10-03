
package com.vladolium.odinmodel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vladolium.odinmodel.domain.Customers;
import com.vladolium.odinmodel.service.CustomersService;

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
	current.setReviewsList(customers.getReviewsList());
	current.setEmployees(customers.getEmployees());
	current.setPostalCode(customers.getPostalCode());

	current.setCity(customers.getCity());

	current.setCreditLimit(customers.getCreditLimit());

	current.setFirstName(customers.getFirstName());

	current.setAddressLine2(customers.getAddressLine2());

	current.setLastName(customers.getLastName());

	current.setPhone(customers.getPhone());

	current.setState(customers.getState());

	current.setCustomerName(customers.getCustomerName());

	current.setAddressLine1(customers.getAddressLine1());

	current.setCountry(customers.getCountry());
	return customersService.createUpdate(current);
    }

    @PutMapping("/customerName={customerName}")
    public Customers updateOneByCustomerName(@PathVariable String customerName, @RequestBody Customers customers) {
	Customers current = customersService.readOneByCustomerName(customerName);
	current.setReviewsList(customers.getReviewsList());
	current.setEmployees(customers.getEmployees());
	current.setPostalCode(customers.getPostalCode());

	current.setCity(customers.getCity());

	current.setCreditLimit(customers.getCreditLimit());

	current.setFirstName(customers.getFirstName());

	current.setAddressLine2(customers.getAddressLine2());

	current.setLastName(customers.getLastName());

	current.setPhone(customers.getPhone());

	current.setState(customers.getState());

	current.setCustomerName(customers.getCustomerName());

	current.setAddressLine1(customers.getAddressLine1());

	current.setCountry(customers.getCountry());
	return customersService.createUpdate(current);
    }

    @DeleteMapping("/{id}")
    public void deleteOneById(@PathVariable Long id) {
	customersService.deleteOneById(id);
    }

//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code

}
