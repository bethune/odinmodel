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

	@PutMapping("/{id}")
	public Customers updateOneById(@PathVariable Long id, @RequestBody Customers customers) {
		Customers current = customersService.readOneById(id);
		current.setReviewsList(customers.getReviewsList());
		current.setEmployees(customers.getEmployees());

		current.setFirstName(customers.getFirstName());

		current.setAddressLine2(customers.getAddressLine2());

		current.setAddressLine1(customers.getAddressLine1());

		current.setState(customers.getState());

		current.setLastName(customers.getLastName());

		current.setCountry(customers.getCountry());

		current.setPostalCode(customers.getPostalCode());

		current.setCreditLimit(customers.getCreditLimit());

		current.setPhone(customers.getPhone());

		current.setCustomerName(customers.getCustomerName());

		current.setCity(customers.getCity());

		return customersService.createUpdate(current);
	}

	@PutMapping("/customerName={customerName}")
	public Customers updateOneByCustomerName(@PathVariable String customerName, @RequestBody Customers customers) {
		Customers current = customersService.readOneByCustomerName(customerName);
		current.setReviewsList(customers.getReviewsList());
		current.setEmployees(customers.getEmployees());

		current.setFirstName(customers.getFirstName());

		current.setAddressLine2(customers.getAddressLine2());

		current.setAddressLine1(customers.getAddressLine1());

		current.setState(customers.getState());

		current.setLastName(customers.getLastName());

		current.setCountry(customers.getCountry());

		current.setPostalCode(customers.getPostalCode());

		current.setCreditLimit(customers.getCreditLimit());

		current.setPhone(customers.getPhone());

		current.setCustomerName(customers.getCustomerName());

		current.setCity(customers.getCity());

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
	public Page<Customers> readAllPagination(@PathVariable Integer pageNumber, @PathVariable Integer perPageNumber) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return customersService.readAllPagination(page);
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
	public Page<Payments> readAllPaymentsByCustomersIdPagination(@PathVariable Integer pageNumber,
			@PathVariable Integer perPageNumber, @PathVariable Long customersId) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return paymentsService.readAllByCustomersId(customersId, page);
	}

	@GetMapping("/customerName={customersCustomerName}/payments")
	public Iterable<Payments> readAllPaymentsByCustomersCustomerName(@PathVariable String customersCustomerName) {
		return paymentsService.readAllByCustomersCustomerName(customersCustomerName);
	}

	@GetMapping("/customerName={customersCustomerName}/payments/page={pageNumber}/perPage={perPageNumber}")
	public Page<Payments> readAllPaymentsByCustomersCustomerNamePagination(@PathVariable Integer pageNumber,
			@PathVariable Integer perPageNumber, @PathVariable String customersCustomerName) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return paymentsService.readAllByCustomersCustomerName(customersCustomerName, page);
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
	public Page<Orders> readAllOrdersByCustomersIdPagination(@PathVariable Integer pageNumber,
			@PathVariable Integer perPageNumber, @PathVariable Long customersId) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return ordersService.readAllByCustomersId(customersId, page);
	}

	@GetMapping("/customerName={customersCustomerName}/orders")
	public Iterable<Orders> readAllOrdersByCustomersCustomerName(@PathVariable String customersCustomerName) {
		return ordersService.readAllByCustomersCustomerName(customersCustomerName);
	}

	@GetMapping("/customerName={customersCustomerName}/orders/page={pageNumber}/perPage={perPageNumber}")
	public Page<Orders> readAllOrdersByCustomersCustomerNamePagination(@PathVariable Integer pageNumber,
			@PathVariable Integer perPageNumber, @PathVariable String customersCustomerName) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return ordersService.readAllByCustomersCustomerName(customersCustomerName, page);
	}

	@GetMapping("/search")
	public Iterable<Customers> search(@RequestParam(value = "reviewsList", required = false) List<Reviews> reviewsList,
			@RequestParam(value = "employeesId", required = false) Long employeesId,

			@RequestParam(value = "lastName", required = false) String lastName,
			@RequestParam(value = "country", required = false) String country,
			@RequestParam(value = "postalCode", required = false) String postalCode,
			@RequestParam(value = "creditLimit", required = false) Double creditLimit,
			@RequestParam(value = "phone", required = false) String phone,
			@RequestParam(value = "firstName", required = false) String firstName,
			@RequestParam(value = "customerName", required = false) String customerName,
			@RequestParam(value = "addressLine2", required = false) String addressLine2,
			@RequestParam(value = "city", required = false) String city,
			@RequestParam(value = "addressLine1", required = false) String addressLine1,
			@RequestParam(value = "state", required = false) String state

	) {
		return customersService.search(reviewsList, employeesId,

				lastName, country, postalCode, creditLimit, phone, firstName, customerName, addressLine2, city,
				addressLine1, state

		);
	}

	@GetMapping("/search/page={pageNumber}/perPage={perPageNumber}")
	public Page<Customers> searchPagination(@PathVariable Integer pageNumber, @PathVariable Integer perPageNumber,
			@RequestParam(value = "reviewsList", required = false) List<Reviews> reviewsList,
			@RequestParam(value = "employeesId", required = false) Long employeesId,

			@RequestParam(value = "lastName", required = false) String lastName,
			@RequestParam(value = "country", required = false) String country,
			@RequestParam(value = "postalCode", required = false) String postalCode,
			@RequestParam(value = "creditLimit", required = false) Double creditLimit,
			@RequestParam(value = "phone", required = false) String phone,
			@RequestParam(value = "firstName", required = false) String firstName,
			@RequestParam(value = "customerName", required = false) String customerName,
			@RequestParam(value = "addressLine2", required = false) String addressLine2,
			@RequestParam(value = "city", required = false) String city,
			@RequestParam(value = "addressLine1", required = false) String addressLine1,
			@RequestParam(value = "state", required = false) String state

	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);

		return customersService.searchPagination(page, reviewsList, employeesId,

				lastName, country, postalCode, creditLimit, phone, firstName, customerName, addressLine2, city,
				addressLine1, state

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
