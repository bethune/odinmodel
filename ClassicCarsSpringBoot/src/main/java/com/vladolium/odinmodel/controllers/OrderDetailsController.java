package com.vladolium.odinmodel.controllers;

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.OrderDetails.*;

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
@RequestMapping("/api/orderDetails")
public class OrderDetailsController {

	private OrderDetailsInterface orderDetailsInterface;

	@Autowired
	public void setOrderDetailsInterface(OrderDetailsInterface orderDetailsInterface) {
		this.orderDetailsInterface = orderDetailsInterface;
	}

	@PostMapping("")
	public OrderDetails saveOne(@RequestBody OrderDetails orderDetails) {
		return orderDetailsInterface.saveOne(orderDetails);
	}

	@DeleteMapping("/{id}")
	public void deleteOneById(@PathVariable Long id) {
		orderDetailsInterface.deleteOneById(id);
	}
	
	@GetMapping("/{id}")
	public OrderDetails readOneById(@PathVariable Long id) {
		return orderDetailsInterface.readOneById(id);
	}
	
	@PutMapping("/{id}")
	public OrderDetails updateOneById(@PathVariable Long id, @RequestBody OrderDetails orderDetails) {
		
		OrderDetails current = orderDetailsInterface.readOneById(id);
			
		current.setProducts(orderDetails.getProducts());
		current.setOrders(orderDetails.getOrders());
		current.setOrderLineNumber(orderDetails.getOrderLineNumber());
		current.setQuantityOrdered(orderDetails.getQuantityOrdered());
		current.setPriceEach(orderDetails.getPriceEach());
				
		return orderDetailsInterface.saveOne(current);
	}


	
//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code
}
