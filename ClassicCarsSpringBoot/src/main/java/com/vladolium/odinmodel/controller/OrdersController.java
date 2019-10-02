
package com.vladolium.odinmodel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.format.annotation.*;

import java.time.*;
import java.util.*;

import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.service.OrdersService;
import com.vladolium.odinmodel.service.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/orders")
public class OrdersController {

	private OrdersService ordersService;

	@Autowired
	public void setOrdersService(OrdersService ordersService) {
		this.ordersService = ordersService;
	}

@PostMapping("")
public Orders createOne(@RequestBody Orders orders) {
	return ordersService.createUpdate(orders);
}

//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code

}
