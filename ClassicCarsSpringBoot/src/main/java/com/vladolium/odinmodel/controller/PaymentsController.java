package com.vladolium.odinmodel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.format.annotation.*;
import java.time.*;
import java.util.*;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Payments;
import com.vladolium.odinmodel.domain.Payments.*;
import com.vladolium.odinmodel.service.PaymentsService;
import com.vladolium.odinmodel.service.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/payments")
public class PaymentsController {

	private PaymentsService paymentsService;

	@Autowired
	public void setPaymentsService(PaymentsService paymentsService) {
		this.paymentsService = paymentsService;
	}

	@PostMapping("")
	public Payments createOne(@RequestBody Payments payments) {
		return paymentsService.createUpdate(payments);
	}
	
	@PutMapping("/{id}")
	public Payments updateOneById(@PathVariable Long id, @RequestBody Payments payments) {
		Payments current = paymentsService.readOneById(id);
		current.setCustomers(payments.getCustomers());
		
		current.setAmount(payments.getAmount());
		
		
		current.setCheckNumber(payments.getCheckNumber());
		
		current.setPaymentDate(payments.getPaymentDate());
		
		current.setPaymentTimestamp(payments.getPaymentTimestamp());
					
		return paymentsService.createUpdate(current);
	}
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/{id}")
	public Payments readOneById(@PathVariable Long id) {
		return paymentsService.readOneById(id);
	}
	
	
	
	
	
	
	
	
	
	@GetMapping("")
	public Iterable<Payments> readAll() {
		return paymentsService.readAll();
	}
	@GetMapping("/{pageNumber}/{perPageNumber}")
	public Page<Payments> readAllPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return paymentsService.readAllPagination(page);
	}
	
	
	
	
	
	
	
	
	@GetMapping("/search")
	public Iterable<Payments> search(
		
		
		@RequestParam(value = "customersId", required = false) Long customersId,
		
		
		
		
		
		
		
		
		
		
		@RequestParam(value = "amount", required = false) Double amount,
		@RequestParam(value = "checkNumber", required = false) String checkNumber,
		@RequestParam(value = "paymentDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate paymentDate,
		@RequestParam(value = "paymentTimestamp", required = false) Instant paymentTimestamp
		
	) {
		return paymentsService.search(
			
			
			customersId,
			
			
			
			
			
			
			
			
			
			
			amount,
			checkNumber,
			paymentDate,
			paymentTimestamp
			
		);
	}
	
	
	
	@DeleteMapping("/{id}")
	public void deleteOneById(@PathVariable Long id) {
		paymentsService.deleteOneById(id);
	}
	
	
	
	
		

//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code

}
