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
import com.vladolium.odinmodel.wrapperRequest.*;

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
	
	
	
	
	@PutMapping("/{id}")
	public Orders updateOneById(@PathVariable Long id, @RequestBody Orders orders) {
		Orders current = ordersService.readOneById(id);
		current.setCustomers(orders.getCustomers());
		
		current.setShippedDate(orders.getShippedDate());
		
		
		current.setComments(orders.getComments());
		
		current.setOrderDate(orders.getOrderDate());
		
		current.setRequiredDate(orders.getRequiredDate());
		
		current.setStatus(orders.getStatus());
					
		return ordersService.createUpdate(current);
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
	
	
	@GetMapping("/search")
	public Iterable<Orders> search(
		@RequestParam(value = "customersId", required = false) Long customersId,
		
		
		
		
		
		
		
		
		
		
		
		@RequestParam(value = "shippedDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate shippedDate,
		@RequestParam(value = "comments", required = false) String comments,
		@RequestParam(value = "orderDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate orderDate,
		@RequestParam(value = "requiredDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate requiredDate,
		@RequestParam(value = "status", required = false) String status
		
	) {
		return ordersService.search(
			customersId,
			
			
			
			
			
			
			
			
			
			
			
			shippedDate,
			comments,
			orderDate,
			requiredDate,
			status
			
		);
	}
	
	@GetMapping("/search/page={pageNumber}/perPage={perPageNumber}")
	public Page<Orders> searchPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber,
		@RequestParam(value = "customersId", required = false) Long customersId,
		
		
		
		
		
		
		
		
		
		
		
		@RequestParam(value = "shippedDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate shippedDate,
		@RequestParam(value = "comments", required = false) String comments,
		@RequestParam(value = "orderDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate orderDate,
		@RequestParam(value = "requiredDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate requiredDate,
		@RequestParam(value = "status", required = false) String status
		
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
	
		return ordersService.searchPagination(
			page,
			customersId,
			
			
			
			
			
			
			
			
			
			
			
			shippedDate,
			comments,
			orderDate,
			requiredDate,
			status
			
		);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteOneById(@PathVariable Long id) {
		ordersService.deleteOneById(id);
	}
	
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code
}
