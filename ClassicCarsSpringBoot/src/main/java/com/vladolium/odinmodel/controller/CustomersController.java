package com.vladolium.odinmodel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vladolium.odinmodel.domain.Customers;
import com.vladolium.odinmodel.domain.Reviews;
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

    @PutMapping("/{customerName}")
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

    @GetMapping("/{id}")
    public Customers readOneById(@PathVariable Long id) {
	return customersService.readOneById(id);
    }

    @GetMapping("/{customerName}")
    public Customers readOneByCustomerName(@PathVariable String customerName) {
	return customersService.readOneByCustomerName(customerName);
    }

    @GetMapping("")
    public Iterable<Customers> readAll() {
	return customersService.readAll();
    }

    @GetMapping("/{pageNumber}/{perPageNumber}")
    public Page<Customers> readAllPagination(@PathVariable Integer pageNumber, @PathVariable Integer perPageNumber) {
	Pageable page = PageRequest.of(pageNumber, perPageNumber);
	return customersService.readAllPagination(page);
    }

    @GetMapping("/search")
    public Iterable<Customers> search(@RequestParam(value = "reviewsList", required = false) List<Reviews> reviewsList,

	    @RequestParam(value = "employeesId", required = false) Long employeesId,

	    @RequestParam(value = "postalCode", required = false) String postalCode,
	    @RequestParam(value = "lastName", required = false) String lastName,
	    @RequestParam(value = "city", required = false) String city,
	    @RequestParam(value = "phone", required = false) String phone,
	    @RequestParam(value = "state", required = false) String state,
	    @RequestParam(value = "customerName", required = false) String customerName,
	    @RequestParam(value = "addressLine1", required = false) String addressLine1,
	    @RequestParam(value = "creditLimit", required = false) Double creditLimit,
	    @RequestParam(value = "firstName", required = false) String firstName,
	    @RequestParam(value = "addressLine2", required = false) String addressLine2,
	    @RequestParam(value = "country", required = false) String country

    ) {
	return customersService.search(

		reviewsList,

		employeesId,

		postalCode, lastName, city, phone, state, customerName, addressLine1, creditLimit, firstName,
		addressLine2, country

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
