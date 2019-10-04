
package com.vladolium.odinmodel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.format.annotation.*;

import java.time.*;
import java.util.*;

import com.vladolium.odinmodel.domain.*;
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
	current.setCustomerName(customers.getCustomerName());

	return customersService.createUpdate(current);
}









@GetMapping("/{id}")
public Customers findOneById(@PathVariable Long id) {
	return customersService.readOneById(id);
}





















@GetMapping("/customerName={customerName}")
public Customers findOneByCustomerName(@PathVariable String customerName) {
	return customersService.readOneByCustomerName(customerName);
}






@GetMapping("")
public Iterable<Customers> readAll() {
	return customersService.readAll();
}


@GetMapping("/page={pageNumber}/per-page={perPageNumber}")
public Page<Customers> readAllPagination(
	@PathVariable Integer pageNumber,
	@PathVariable Integer perPageNumber
) {
	Pageable page = PageRequest.of(pageNumber, perPageNumber);
	return customersService.readAllPagination(page);
}















@DeleteMapping("/{id}")
public void deleteOneById(@PathVariable Long id) {
	customersService.deleteOneById(id);
}











	

//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code

}
