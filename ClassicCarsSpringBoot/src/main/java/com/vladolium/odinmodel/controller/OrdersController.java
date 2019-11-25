package com.vladolium.odinmodel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.format.annotation.*;
import java.time.*;
import java.util.*;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Orders;
import com.vladolium.odinmodel.domain.Orders.*;
import com.vladolium.odinmodel.service.OrdersService;
import com.vladolium.odinmodel.service.*;
import com.vladolium.odinmodel.wrapper.*;

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
	
	
	
	
	
	@GetMapping("/{id}")
	public Orders readOneById(@PathVariable Long id) {
		return ordersService.readOneById(id);
	}
	
	
	
	
	
	
	
	
	
	
	@GetMapping("")
	public Iterable<Orders> readAll() {
		return ordersService.readAll();
	}
	
	@GetMapping("/page={pageNumber}/perPage={perPageNumber}")
	public Page<Orders> readAllPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return ordersService.readAllPagination(page);
	}
	
	
	
	
	
	@DeleteMapping("/{id}")
	public void deleteOneById(@PathVariable Long id) {
		ordersService.deleteOneById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code
}
