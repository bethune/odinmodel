package com.vladolium.odinmodel.serviceImpl;

import com.vladolium.odinmodel.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;
import java.time.*;
import java.util.*;
import com.vladolium.odinmodel.repository.OrderDetailsRepository;
import com.vladolium.odinmodel.service.OrderDetailsService;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.OrderDetails;
import com.vladolium.odinmodel.domain.OrderDetails.*;
import com.querydsl.core.BooleanBuilder;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

	private OrderDetailsRepository orderDetailsRepository;

	@Autowired
	public void setOrderDetailsRepository(OrderDetailsRepository orderDetailsRepository) {
		this.orderDetailsRepository = orderDetailsRepository;
	}

	// covers create & update
	@Override
	public OrderDetails createUpdate(OrderDetails orderDetails) {
		return orderDetailsRepository.save(orderDetails);
	}
	
	
	
	@Override
	public OrderDetails readOneById(Long id) {
		return orderDetailsRepository.getOne(id);
	}
	
	
	
	
	
	
	
	@Override
	public Iterable<OrderDetails> readAll() {
		return orderDetailsRepository.findAll();
	}
	
	@Override
	public Page<OrderDetails> readAllPagination(Pageable page) {
		return orderDetailsRepository.findAll(page);
	}
	@Override
	public Iterable<OrderDetails> search(
		
		Long ordersId,
		
		
		
		
		
		
		
		
		
		
		
		Long productsId,
		
		Integer orderLineNumber,
		Integer quantityOrdered,
		Double priceEach
		
	) {
		BooleanBuilder where = dynamicWhere(
			
			ordersId,
			
			
			
			
			
			
			
			
			
			
			
			productsId,
			
			orderLineNumber,
			quantityOrdered,
			priceEach
				
		);
		return orderDetailsRepository.findAll(where);
	}
	
	public BooleanBuilder dynamicWhere(
		
		Long ordersId,
		
		
		
		
		
		
		
		
		
		
		
		Long productsId,
		
		Integer orderLineNumber,
		Integer quantityOrdered,
		Double priceEach
		
	) {
		QOrderDetails qOrderDetails = QOrderDetails.orderDetails;
	
		BooleanBuilder where = new BooleanBuilder();
	
		
		if (ordersId != null) {
			where.and(qOrderDetails.orders.id.eq(ordersId));
		}
		
		
		
		
		
		
		
		
		
		
		
		if (productsId != null) {
			where.and(qOrderDetails.products.id.eq(productsId));
		}
		
		if (orderLineNumber != null) {
			where.and(qOrderDetails.orderLineNumber.eq(orderLineNumber));
		}
		if (quantityOrdered != null) {
			where.and(qOrderDetails.quantityOrdered.eq(quantityOrdered));
		}
		if (priceEach != null) {
			where.and(qOrderDetails.priceEach.eq(priceEach));
		}
		
	
		return where;
	}
	
	
	
	@Override
	public void deleteOneById(Long id) {
		orderDetailsRepository.deleteById(id);
	}
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code
}
