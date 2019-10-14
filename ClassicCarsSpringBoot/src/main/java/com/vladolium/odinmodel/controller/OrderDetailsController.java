package com.vladolium.odinmodel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.format.annotation.*;
import java.time.*;
import java.util.*;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.OrderDetails;
import com.vladolium.odinmodel.domain.OrderDetails.*;
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
	
	
	
	
	@PutMapping("/{id}")
	public OrderDetails updateOneById(@PathVariable Long id, @RequestBody OrderDetails orderDetails) {
		OrderDetails current = orderDetailsService.readOneById(id);
		current.setOrders(orderDetails.getOrders());
		current.setProducts(orderDetails.getProducts());
		
		current.setQuantityOrdered(orderDetails.getQuantityOrdered());
		
		current.setPriceEach(orderDetails.getPriceEach());
		
		current.setOrderLineNumber(orderDetails.getOrderLineNumber());
		
					
		return orderDetailsService.createUpdate(current);
	}
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/{id}")
	public OrderDetails readOneById(@PathVariable Long id) {
		return orderDetailsService.readOneById(id);
	}
	
	
	
	
	
	
	@GetMapping("")
	public Iterable<OrderDetails> readAll() {
		return orderDetailsService.readAll();
	}
	
	@GetMapping("/page={pageNumber}/perPage={perPageNumber}")
	public Page<OrderDetails> readAllPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return orderDetailsService.readAllPagination(page);
	}
	
	
	@GetMapping("/search")
	public Iterable<OrderDetails> search(
		
		@RequestParam(value = "ordersId", required = false) Long ordersId,
		
		
		
		
		
		@RequestParam(value = "productsId", required = false) Long productsId,
		
		
		
		
		
		
		
		@RequestParam(value = "quantityOrdered", required = false) Integer quantityOrdered,
		@RequestParam(value = "priceEach", required = false) Double priceEach,
		@RequestParam(value = "orderLineNumber", required = false) Integer orderLineNumber
		
	) {
		return orderDetailsService.search(
			
			ordersId,
			
			
			
			
			
			productsId,
			
			
			
			
			
			
			
			quantityOrdered,
			priceEach,
			orderLineNumber
			
		);
	}
	
	@GetMapping("/search/page={pageNumber}/perPage={perPageNumber}")
	public Page<OrderDetails> searchPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber,
		
		@RequestParam(value = "ordersId", required = false) Long ordersId,
		
		
		
		
		
		@RequestParam(value = "productsId", required = false) Long productsId,
		
		
		
		
		
		
		
		@RequestParam(value = "quantityOrdered", required = false) Integer quantityOrdered,
		@RequestParam(value = "priceEach", required = false) Double priceEach,
		@RequestParam(value = "orderLineNumber", required = false) Integer orderLineNumber
		
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
	
		return orderDetailsService.searchPagination(
			page,
			
			ordersId,
			
			
			
			
			
			productsId,
			
			
			
			
			
			
			
			quantityOrdered,
			priceEach,
			orderLineNumber
			
		);
	}
	
	
	
	
	@DeleteMapping("/{id}")
	public void deleteOneById(@PathVariable Long id) {
		orderDetailsService.deleteOneById(id);
	}
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code
}
