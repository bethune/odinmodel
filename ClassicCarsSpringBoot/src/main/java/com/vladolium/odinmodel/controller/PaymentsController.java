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

	
	
	
	
	
	@GetMapping("/{id}")
	public Payments readOneById(@PathVariable Long id) {
		return paymentsService.readOneById(id);
	}
	
	
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code

}
