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
		current.setPriceEach(orderDetails.getPriceEach());
		current.setQuantityOrdered(orderDetails.getQuantityOrdered());
				
		return orderDetailsInterface.saveOne(current);
	}

	@GetMapping("")
	public Iterable<OrderDetails> readAll() {
		return orderDetailsInterface.readAll();
	}
	
	@GetMapping("/page={pageNumber}/perPage={perPageNumber}")
	public Page<OrderDetails> readAllPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return orderDetailsInterface.readAllPagination(page);
	}

	@GetMapping("/search")
	public Iterable<OrderDetails> search(
		Long productsId,
		Long ordersId,
		Integer orderLineNumber,
		Double priceEach,
		Integer quantityOrdered
	) {
		return orderDetailsInterface.search(
			productsId,
			ordersId,
			orderLineNumber,
			priceEach,
			quantityOrdered
		);
	}
	
	@GetMapping("/search/page={pageNumber}/perPage={perPageNumber}")
	public Page<OrderDetails> searchPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber,
		Long productsId,
		Long ordersId,
		Integer orderLineNumber,
		Double priceEach,
		Integer quantityOrdered
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
	
		return orderDetailsInterface.searchPagination(
			page,
			productsId,
			ordersId,
			orderLineNumber,
			priceEach,
			quantityOrdered
		);
	}

	

	

	

//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code
}
