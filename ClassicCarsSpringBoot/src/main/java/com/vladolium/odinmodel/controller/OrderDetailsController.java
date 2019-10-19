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
import com.vladolium.odinmodel.wrapperRequest.*;

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
		current.setProducts(orderDetails.getProducts());
		
		current.setOrderLineNumber(orderDetails.getOrderLineNumber());
		
		current.setPriceEach(orderDetails.getPriceEach());
		
		
		current.setQuantityOrdered(orderDetails.getQuantityOrdered());
					
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
		
		
		
		
		
		
		@RequestParam(value = "productsId", required = false) Long productsId,
		
		
		@RequestParam(value = "orderLineNumber", required = false) Integer orderLineNumber,
		@RequestParam(value = "priceEach", required = false) Double priceEach,
		@RequestParam(value = "quantityOrdered", required = false) Integer quantityOrdered
		
	) {
		return orderDetailsService.search(
			
			
			
			
			
			
			productsId,
			
			
			orderLineNumber,
			priceEach,
			quantityOrdered
			
		);
	}
	
	@GetMapping("/search/page={pageNumber}/perPage={perPageNumber}")
	public Page<OrderDetails> searchPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber,
		
		
		
		
		
		
		@RequestParam(value = "productsId", required = false) Long productsId,
		
		
		@RequestParam(value = "orderLineNumber", required = false) Integer orderLineNumber,
		@RequestParam(value = "priceEach", required = false) Double priceEach,
		@RequestParam(value = "quantityOrdered", required = false) Integer quantityOrdered
		
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
	
		return orderDetailsService.searchPagination(
			page,
			
			
			
			
			
			
			productsId,
			
			
			orderLineNumber,
			priceEach,
			quantityOrdered
			
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
