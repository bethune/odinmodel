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

	@DeleteMapping("/{id}")
	public void deleteOneById(@PathVariable Long id) {
		ordersInterface.deleteOneById(id);
	}
	
	@GetMapping("/{id}")
	public Orders readOneById(@PathVariable Long id) {
		return ordersInterface.readOneById(id);
	}
	
	@PutMapping("/{id}")
	public Orders updateOneById(@PathVariable Long id, @RequestBody Orders orders) {
		
		Orders current = ordersInterface.readOneById(id);
			
		current.setCustomers(orders.getCustomers());
		current.setStatus(orders.getStatus());
		current.setOrderDate(orders.getOrderDate());
		current.setComments(orders.getComments());
		current.setRequiredDate(orders.getRequiredDate());
		current.setShippedDate(orders.getShippedDate());
				
		return ordersInterface.saveOne(current);
	}

	@GetMapping("")
	public Iterable<Orders> readAll() {
		return ordersInterface.readAll();
	}
	
	@GetMapping("/page={pageNumber}/perPage={perPageNumber}")
	public Page<Orders> readAllPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return ordersInterface.readAllPagination(page);
	}


	

	
//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code
}
