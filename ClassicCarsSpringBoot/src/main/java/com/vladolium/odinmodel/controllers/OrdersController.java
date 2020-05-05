package com.vladolium.odinmodel.controllers;

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Orders.*;

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
@RequestMapping("/api/orders")
public class OrdersController {

	private OrdersInterface ordersInterface;

	@Autowired
	public void setOrdersInterface(OrdersInterface ordersInterface) {
		this.ordersInterface = ordersInterface;
	}

	@PostMapping("")
	public Orders saveOne(@RequestBody Orders orders) {
		return ordersInterface.saveOne(orders);
	}

//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code
}
