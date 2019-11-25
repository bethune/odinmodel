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
import com.vladolium.odinmodel.wrapper.*;

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
	
	
	
	@GetMapping("/{id}")
	public Payments readOneById(@PathVariable Long id) {
		return paymentsService.readOneById(id);
	}
	
	
	
	
	
	
	
	
	
	
	@GetMapping("")
	public Iterable<Payments> readAll() {
		return paymentsService.readAll();
	}
	
	@GetMapping("/page={pageNumber}/perPage={perPageNumber}")
	public Page<Payments> readAllPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return paymentsService.readAllPagination(page);
	}
	
	
	
	@DeleteMapping("/{id}")
	public void deleteOneById(@PathVariable Long id) {
		paymentsService.deleteOneById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code
}
