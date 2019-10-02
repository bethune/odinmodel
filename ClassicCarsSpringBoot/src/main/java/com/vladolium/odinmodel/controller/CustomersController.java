
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

//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code

}
