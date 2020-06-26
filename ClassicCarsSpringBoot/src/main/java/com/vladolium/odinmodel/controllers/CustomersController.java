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
		current.setPostalCode(customers.getPostalCode());
		current.setState(customers.getState());
		current.setCity(customers.getCity());
		current.setAddressLine1(customers.getAddressLine1());
		current.setCreditLimit(customers.getCreditLimit());
		current.setPhone(customers.getPhone());
		current.setFirstName(customers.getFirstName());
		current.setAddressLine2(customers.getAddressLine2());
		current.setLastName(customers.getLastName());
		current.setCountry(customers.getCountry());
		current.setCustomerName(customers.getCustomerName());
				
		return customersInterface.saveOne(current);
	}

	@GetMapping("")
	public Iterable<Customers> readAll() {
		return customersInterface.readAll();
	}
	
	@GetMapping("/page={pageNumber}/perPage={perPageNumber}")
	public Page<Customers> readAllPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return customersInterface.readAllPagination(page);
	}

	@GetMapping("/search")
	public Iterable<Customers> search(
		Long employeesId,
		String postalCode,
		String state,
		String city,
		String addressLine1,
		Double creditLimit,
		String phone,
		String firstName,
		String addressLine2,
		String lastName,
		String country,
		String customerName
	) {
		return customersInterface.search(
			employeesId,
			postalCode,
			state,
			city,
			addressLine1,
			creditLimit,
			phone,
			firstName,
			addressLine2,
			lastName,
			country,
			customerName
		);
	}
	
	@GetMapping("/search/page={pageNumber}/perPage={perPageNumber}")
	public Page<Customers> searchPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber,
		Long employeesId,
		String postalCode,
		String state,
		String city,
		String addressLine1,
		Double creditLimit,
		String phone,
		String firstName,
		String addressLine2,
		String lastName,
		String country,
		String customerName
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
	
		return customersInterface.searchPagination(
			page,
			employeesId,
			postalCode,
			state,
			city,
			addressLine1,
			creditLimit,
			phone,
			firstName,
			addressLine2,
			lastName,
			country,
			customerName
		);
	}

	private MarksInterface marksInterface;
	
	@Autowired
	public void setMarksInterface(MarksInterface marksInterface) {
		this.marksInterface = marksInterface;
	}
	
	
	
	
	
	
	
	
	
	@GetMapping("/{customersId}/marks")
	public Iterable<Marks> readAllMarksByCustomersId(@PathVariable Long customersId) {
		return marksInterface.readAllByCustomersId(customersId);
	}
	
	@GetMapping("/{customersId}/marks/page={pageNumber}/perPage={perPageNumber}")
	public Page<Marks> readAllMarksByCustomersIdPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber,
		@PathVariable Long customersId
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return marksInterface.readAllByCustomersId(customersId, page);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/customerName={customersCustomerName}/marks")
	public Iterable<Marks> readAllMarksByCustomersCustomerName(@PathVariable String customersCustomerName) {
		return marksInterface.readAllByCustomersCustomerName(customersCustomerName);
	}
	
	@GetMapping("/customerName={customersCustomerName}/marks/page={pageNumber}/perPage={perPageNumber}")
	public Page<Marks> readAllMarksByCustomersCustomerNamePagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber,
		@PathVariable String customersCustomerName
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return marksInterface.readAllByCustomersCustomerName(customersCustomerName, page);
	}
	private PaymentsInterface paymentsInterface;
	
	@Autowired
	public void setPaymentsInterface(PaymentsInterface paymentsInterface) {
		this.paymentsInterface = paymentsInterface;
	}
	
	
	
	
	
	
	
	
	
	@GetMapping("/{customersId}/payments")
	public Iterable<Payments> readAllPaymentsByCustomersId(@PathVariable Long customersId) {
		return paymentsInterface.readAllByCustomersId(customersId);
	}
	
	@GetMapping("/{customersId}/payments/page={pageNumber}/perPage={perPageNumber}")
	public Page<Payments> readAllPaymentsByCustomersIdPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber,
		@PathVariable Long customersId
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return paymentsInterface.readAllByCustomersId(customersId, page);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/customerName={customersCustomerName}/payments")
	public Iterable<Payments> readAllPaymentsByCustomersCustomerName(@PathVariable String customersCustomerName) {
		return paymentsInterface.readAllByCustomersCustomerName(customersCustomerName);
	}
	
	@GetMapping("/customerName={customersCustomerName}/payments/page={pageNumber}/perPage={perPageNumber}")
	public Page<Payments> readAllPaymentsByCustomersCustomerNamePagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber,
		@PathVariable String customersCustomerName
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return paymentsInterface.readAllByCustomersCustomerName(customersCustomerName, page);
	}
	private ReviewsInterface reviewsInterface;
	
	@Autowired
	public void setReviewsInterface(ReviewsInterface reviewsInterface) {
		this.reviewsInterface = reviewsInterface;
	}
	
	
	
	
	
	
	
	
	
	@GetMapping("/{customersId}/reviews")
	public Iterable<Reviews> readAllReviewsByCustomersId(@PathVariable Long customersId) {
		return reviewsInterface.readAllByCustomersId(customersId);
	}
	
	@GetMapping("/{customersId}/reviews/page={pageNumber}/perPage={perPageNumber}")
	public Page<Reviews> readAllReviewsByCustomersIdPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber,
		@PathVariable Long customersId
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return reviewsInterface.readAllByCustomersId(customersId, page);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/customerName={customersCustomerName}/reviews")
	public Iterable<Reviews> readAllReviewsByCustomersCustomerName(@PathVariable String customersCustomerName) {
		return reviewsInterface.readAllByCustomersCustomerName(customersCustomerName);
	}
	
	@GetMapping("/customerName={customersCustomerName}/reviews/page={pageNumber}/perPage={perPageNumber}")
	public Page<Reviews> readAllReviewsByCustomersCustomerNamePagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber,
		@PathVariable String customersCustomerName
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return reviewsInterface.readAllByCustomersCustomerName(customersCustomerName, page);
	}
	private OrdersInterface ordersInterface;
	
	@Autowired
	public void setOrdersInterface(OrdersInterface ordersInterface) {
		this.ordersInterface = ordersInterface;
	}
	
	
	
	
	
	
	
	
	
	@GetMapping("/{customersId}/orders")
	public Iterable<Orders> readAllOrdersByCustomersId(@PathVariable Long customersId) {
		return ordersInterface.readAllByCustomersId(customersId);
	}
	
	@GetMapping("/{customersId}/orders/page={pageNumber}/perPage={perPageNumber}")
	public Page<Orders> readAllOrdersByCustomersIdPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber,
		@PathVariable Long customersId
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return ordersInterface.readAllByCustomersId(customersId, page);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/customerName={customersCustomerName}/orders")
	public Iterable<Orders> readAllOrdersByCustomersCustomerName(@PathVariable String customersCustomerName) {
		return ordersInterface.readAllByCustomersCustomerName(customersCustomerName);
	}
	
	@GetMapping("/customerName={customersCustomerName}/orders/page={pageNumber}/perPage={perPageNumber}")
	public Page<Orders> readAllOrdersByCustomersCustomerNamePagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber,
		@PathVariable String customersCustomerName
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return ordersInterface.readAllByCustomersCustomerName(customersCustomerName, page);
	}

	@GetMapping("/customerName={customerName}")
	public Customers readOneByCustomerName(@PathVariable String customerName) {
		return customersInterface.readOneByCustomerName(customerName);
	}
	
	@PutMapping("/customerName={customerName}")
	public Customers updateOneByCustomerName(@PathVariable String customerName, @RequestBody Customers customers) {
		
		Customers current = customersInterface.readOneByCustomerName(customerName);
			
		current.setEmployees(customers.getEmployees());
		current.setPostalCode(customers.getPostalCode());
		current.setState(customers.getState());
		current.setCity(customers.getCity());
		current.setAddressLine1(customers.getAddressLine1());
		current.setCreditLimit(customers.getCreditLimit());
		current.setPhone(customers.getPhone());
		current.setFirstName(customers.getFirstName());
		current.setAddressLine2(customers.getAddressLine2());
		current.setLastName(customers.getLastName());
		current.setCountry(customers.getCountry());
		current.setCustomerName(customers.getCustomerName());
				
		return customersInterface.saveOne(current);
	}

	

//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code
}
