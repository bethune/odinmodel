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
import com.vladolium.odinmodel.wrapper.*;

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
	
	private OrdersService ordersService;
	
	@Autowired
	public void setOrdersService(OrdersService ordersService) {
		this.ordersService = ordersService;
	}
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/{customersId}/orders")
	public Iterable<Orders> readAllOrdersByCustomersId(@PathVariable Long customersId) {
		return ordersService.readAllByCustomersId(customersId);
	}
	
	@GetMapping("/{customersId}/orders/page={pageNumber}/perPage={perPageNumber}")
	public Page<Orders> readAllOrdersByCustomersIdPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber,
		@PathVariable Long customersId
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return ordersService.readAllByCustomersId(customersId, page);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/customerName={customersCustomerName}/orders")
	public Iterable<Orders> readAllOrdersByCustomersCustomerName(@PathVariable String customersCustomerName) {
		return ordersService.readAllByCustomersCustomerName(customersCustomerName);
	}
	
	@GetMapping("/customerName={customersCustomerName}/orders/page={pageNumber}/perPage={perPageNumber}")
	public Page<Orders> readAllOrdersByCustomersCustomerNamePagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber,
		@PathVariable String customersCustomerName
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return ordersService.readAllByCustomersCustomerName(customersCustomerName, page);
	}
	
	
	private PaymentsService paymentsService;
	
	@Autowired
	public void setPaymentsService(PaymentsService paymentsService) {
		this.paymentsService = paymentsService;
	}
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/{customersId}/payments")
	public Iterable<Payments> readAllPaymentsByCustomersId(@PathVariable Long customersId) {
		return paymentsService.readAllByCustomersId(customersId);
	}
	
	@GetMapping("/{customersId}/payments/page={pageNumber}/perPage={perPageNumber}")
	public Page<Payments> readAllPaymentsByCustomersIdPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber,
		@PathVariable Long customersId
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return paymentsService.readAllByCustomersId(customersId, page);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/customerName={customersCustomerName}/payments")
	public Iterable<Payments> readAllPaymentsByCustomersCustomerName(@PathVariable String customersCustomerName) {
		return paymentsService.readAllByCustomersCustomerName(customersCustomerName);
	}
	
	@GetMapping("/customerName={customersCustomerName}/payments/page={pageNumber}/perPage={perPageNumber}")
	public Page<Payments> readAllPaymentsByCustomersCustomerNamePagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber,
		@PathVariable String customersCustomerName
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return paymentsService.readAllByCustomersCustomerName(customersCustomerName, page);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@DeleteMapping("/{id}")
	public void deleteOneById(@PathVariable Long id) {
		customersService.deleteOneById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code
}
