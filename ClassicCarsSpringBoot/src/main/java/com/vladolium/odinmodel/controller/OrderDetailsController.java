
package com.vladolium.odinmodel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.format.annotation.*;

import java.time.*;
import java.util.*;

import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.service.OrderDetailsService;
import com.vladolium.odinmodel.service.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/orderDetails")
public class OrderDetailsController {

	private OrderDetailsService orderDetailsService;

	@Autowired
	public void setOrderDetailsService(OrderDetailsService orderDetailsService) {
		this.orderDetailsService = orderDetailsService;
	}

@PostMapping("")
public OrderDetails createOne(@RequestBody OrderDetails orderDetails) {
	return orderDetailsService.createUpdate(orderDetails);
}

//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code

}
