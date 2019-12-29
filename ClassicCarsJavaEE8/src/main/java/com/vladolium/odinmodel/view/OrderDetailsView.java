package com.vladolium.odinmodel.view;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.*;
//import org.springframework.format.annotation.*;
import java.time.*;
import java.util.*;
import java.io.Serializable;
import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.OrderDetails;
import com.vladolium.odinmodel.model.OrderDetails.*;
import com.vladolium.odinmodel.service.OrderDetailsService;
import com.vladolium.odinmodel.service.*;
import com.vladolium.odinmodel.wrapper.*;

@Named
@ViewScoped
public class OrderDetailsView implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private OrderDetailsService orderDetailsService;

	
	private OrderDetails orderDetails;
	
	public OrderDetails createOne() {
		return orderDetailsService.createUpdate(orderDetails);
	}
	
	
	
	
	
	public OrderDetails updateOneById(Long id) {
		OrderDetails current = orderDetailsService.readOneById(id);
		current.setProducts(orderDetails.getProducts());
		current.setOrders(orderDetails.getOrders());
		
		current.setOrderLineNumber(orderDetails.getOrderLineNumber());
		
		current.setPriceEach(orderDetails.getPriceEach());
		
		
		current.setQuantityOrdered(orderDetails.getQuantityOrdered());
					
		return orderDetailsService.createUpdate(current);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public OrderDetails readOneById(Long id) {
		return orderDetailsService.readOneById(id);
	}
	
	
	
	
	
	
	
	public Iterable<OrderDetails> readAll() {
		return orderDetailsService.readAll();
	}
	
	public Page<OrderDetails> readAllPagination(
		Integer pageNumber,
		Integer perPageNumber
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return orderDetailsService.readAllPagination(page);
	}
	
	
	public Iterable<OrderDetails> search(
		
		
		
		
		
		
		Long productsId,
		
		
		Long ordersId,
		
		
		
		
		
		Integer orderLineNumber,
		Double priceEach,
		Integer quantityOrdered
		
	) {
		return orderDetailsService.search(
			
			
			
			
			
			
			productsId,
			
			
			ordersId,
			
			
			
			
			
			orderLineNumber,
			priceEach,
			quantityOrdered
			
		);
	}
	
	public Page<OrderDetails> searchPagination(
		Integer pageNumber,
		Integer perPageNumber,
		
		
		
		
		
		
		Long productsId,
		
		
		Long ordersId,
		
		
		
		
		
		Integer orderLineNumber,
		Double priceEach,
		Integer quantityOrdered
		
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
	
		return orderDetailsService.searchPagination(
			page,
			
			
			
			
			
			
			productsId,
			
			
			ordersId,
			
			
			
			
			
			orderLineNumber,
			priceEach,
			quantityOrdered
			
		);
	}
	
	
	
	public void deleteOneById(Long id) {
		orderDetailsService.deleteOneById(id);
	}
	
	
	
	
	
	
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this view
//End of user code
}
