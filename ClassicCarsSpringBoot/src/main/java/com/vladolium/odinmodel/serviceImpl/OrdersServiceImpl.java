package com.vladolium.odinmodel.serviceImpl;

import com.vladolium.odinmodel.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;
import java.time.*;
import java.util.*;
import com.vladolium.odinmodel.repository.OrdersRepository;
import com.vladolium.odinmodel.service.OrdersService;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Orders;
import com.vladolium.odinmodel.domain.Orders.*;
import com.querydsl.core.BooleanBuilder;

@Service
public class OrdersServiceImpl implements OrdersService {

	private OrdersRepository ordersRepository;

	@Autowired
	public void setOrdersRepository(OrdersRepository ordersRepository) {
		this.ordersRepository = ordersRepository;
	}

	// covers create & update
	@Override
	public Orders createUpdate(Orders orders) {
		return ordersRepository.save(orders);
	}
	
	
	@Override
	public Orders readOneById(Long id) {
		return ordersRepository.getOne(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public Iterable<Orders> readAll() {
		return ordersRepository.findAll();
	}
	
	@Override
	public Page<Orders> readAllPagination(Pageable page) {
		return ordersRepository.findAll(page);
	}
	@Override
	public Iterable<Orders> search(
		Long customersId,
		
		
		
		
		
		
		
		
		
		
		
		LocalDate shippedDate,
		String comments,
		String status,
		LocalDate orderDate,
		LocalDate requiredDate
		
	) {
		BooleanBuilder where = dynamicWhere(
			customersId,
			
			
			
			
			
			
			
			
			
			
			
			shippedDate,
			comments,
			status,
			orderDate,
			requiredDate
				
		);
		return ordersRepository.findAll(where);
	}
	
	@Override
	public Page<Orders> searchPagination(
		Pageable page,
		Long customersId,
		
		
		
		
		
		
		
		
		
		
		
		LocalDate shippedDate,
		String comments,
		String status,
		LocalDate orderDate,
		LocalDate requiredDate
		
	) {
		BooleanBuilder where = dynamicWhere(
			customersId,
			
			
			
			
			
			
			
			
			
			
			
			shippedDate,
			comments,
			status,
			orderDate,
			requiredDate
			
		);
		return ordersRepository.findAll(where, page);
	}
	
	public BooleanBuilder dynamicWhere(
		Long customersId,
		
		
		
		
		
		
		
		
		
		
		
		LocalDate shippedDate,
		String comments,
		String status,
		LocalDate orderDate,
		LocalDate requiredDate
		
	) {
		QOrders qOrders = QOrders.orders;
	
		BooleanBuilder where = new BooleanBuilder();
	
		if (customersId != null) {
			where.and(qOrders.customers.id.eq(customersId));
		}
		
		
		
		
		
		
		
		
		
		
		
		if (shippedDate != null) {
			where.and(qOrders.shippedDate.eq(shippedDate));
		}
		if (comments != null) {
			where.and(qOrders.comments.eq(comments));
		}
		if (status != null) {
			where.and(qOrders.status.containsIgnoreCase(status));
		}
		if (orderDate != null) {
			where.and(qOrders.orderDate.eq(orderDate));
		}
		if (requiredDate != null) {
			where.and(qOrders.requiredDate.eq(requiredDate));
		}
		
	
		return where;
	}
	
	
	
	@Override
	public void deleteOneById(Long id) {
		ordersRepository.deleteById(id);
	}
	
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code
}
