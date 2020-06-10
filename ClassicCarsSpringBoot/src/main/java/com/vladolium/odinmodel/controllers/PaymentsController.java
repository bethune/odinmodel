package com.vladolium.odinmodel.controllers;

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Payments.*;

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
@RequestMapping("/api/payments")
public class PaymentsController {

	private PaymentsInterface paymentsInterface;

	@Autowired
	public void setPaymentsInterface(PaymentsInterface paymentsInterface) {
		this.paymentsInterface = paymentsInterface;
	}

	@PostMapping("")
	public Payments saveOne(@RequestBody Payments payments) {
		return paymentsInterface.saveOne(payments);
	}

	@DeleteMapping("/{id}")
	public void deleteOneById(@PathVariable Long id) {
		paymentsInterface.deleteOneById(id);
	}
	
	@GetMapping("/{id}")
	public Payments readOneById(@PathVariable Long id) {
		return paymentsInterface.readOneById(id);
	}
	
	@PutMapping("/{id}")
	public Payments updateOneById(@PathVariable Long id, @RequestBody Payments payments) {
		
		Payments current = paymentsInterface.readOneById(id);
			
		current.setCustomers(payments.getCustomers());
		current.setAmount(payments.getAmount());
		current.setCheckNumber(payments.getCheckNumber());
		current.setPaymentTimestamp(payments.getPaymentTimestamp());
		current.setPaymentDate(payments.getPaymentDate());
				
		return paymentsInterface.saveOne(current);
	}

	@GetMapping("")
	public Iterable<Payments> readAll() {
		return paymentsInterface.readAll();
	}
	
	@GetMapping("/page={pageNumber}/perPage={perPageNumber}")
	public Page<Payments> readAllPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return paymentsInterface.readAllPagination(page);
	}

	@GetMapping("/search")
	public Iterable<Payments> search(
		Long customersId,
		Double amount,
		String checkNumber,
		Instant paymentTimestamp,
		LocalDate paymentDate
	) {
		return paymentsInterface.search(
			customersId,
			amount,
			checkNumber,
			paymentTimestamp,
			paymentDate
		);
	}
	
	@GetMapping("/search/page={pageNumber}/perPage={perPageNumber}")
	public Page<Payments> searchPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber,
		Long customersId,
		Double amount,
		String checkNumber,
		Instant paymentTimestamp,
		LocalDate paymentDate
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
	
		return paymentsInterface.searchPagination(
			page,
			customersId,
			amount,
			checkNumber,
			paymentTimestamp,
			paymentDate
		);
	}

	

	

	

//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code
}
