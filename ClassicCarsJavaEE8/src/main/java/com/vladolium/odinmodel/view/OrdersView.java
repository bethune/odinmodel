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
import com.vladolium.odinmodel.model.Orders;
import com.vladolium.odinmodel.model.Orders.*;
import com.vladolium.odinmodel.service.OrdersService;
import com.vladolium.odinmodel.service.*;
import com.vladolium.odinmodel.wrapper.*;

@Named
@ViewScoped
public class OrdersView implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private OrdersService ordersService;

	
	private Orders orders;
	
	public Orders createOne() {
		return ordersService.createUpdate(orders);
	}
	
	
	public Orders updateOneById(Long id) {
		Orders current = ordersService.readOneById(id);
		current.setCustomers(orders.getCustomers());
		
		
		current.setOrderDate(orders.getOrderDate());
		
		current.setRequiredDate(orders.getRequiredDate());
		
		current.setShippedDate(orders.getShippedDate());
		
		current.setStatus(orders.getStatus());
		
		current.setComments(orders.getComments());
					
		return ordersService.createUpdate(current);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Orders readOneById(Long id) {
		return ordersService.readOneById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Iterable<Orders> readAll() {
		return ordersService.readAll();
	}
	
	public Page<Orders> readAllPagination(
		Integer pageNumber,
		Integer perPageNumber
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return ordersService.readAllPagination(page);
	}
	
	
	public Iterable<Orders> search(
		
		
		
		
		Long customersId,
		
		
		
		
		
		
		
		LocalDate orderDate,
		LocalDate requiredDate,
		LocalDate shippedDate,
		String status,
		String comments
		
	) {
		return ordersService.search(
			
			
			
			
			customersId,
			
			
			
			
			
			
			
			orderDate,
			requiredDate,
			shippedDate,
			status,
			comments
			
		);
	}
	
	public Page<Orders> searchPagination(
		Integer pageNumber,
		Integer perPageNumber,
		
		
		
		
		Long customersId,
		
		
		
		
		
		
		
		LocalDate orderDate,
		LocalDate requiredDate,
		LocalDate shippedDate,
		String status,
		String comments
		
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
	
		return ordersService.searchPagination(
			page,
			
			
			
			
			customersId,
			
			
			
			
			
			
			
			orderDate,
			requiredDate,
			shippedDate,
			status,
			comments
			
		);
	}
	public void deleteOneById(Long id) {
		ordersService.deleteOneById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this view
//End of user code
}
