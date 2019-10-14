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
	public Iterable<OrderDetails> readAllByProductsId(Long productsId) {
		return orderDetailsRepository.findByProductsIdEquals(productsId);
	}
	
	@Override
	public Page<OrderDetails> readAllByProductsId(Long productsId, Pageable page) {
		return orderDetailsRepository.findByProductsIdEquals(productsId, page);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public Iterable<OrderDetails> readAllByProductsProductCode(String productsProductCode) {
		return orderDetailsRepository.findByProductsProductCodeEquals(productsProductCode);
	}
	
	@Override
	public Page<OrderDetails> readAllByProductsProductCode(String productsProductCode, Pageable page) {
		return orderDetailsRepository.findByProductsProductCodeEquals(productsProductCode, page);
	}
	
	
	@Override
	public Iterable<OrderDetails> search(
		
		Long ordersId,
		
		
		
		
		
		Long productsId,
		
		
		
		
		
		
		
		Integer quantityOrdered,
		Double priceEach,
		Integer orderLineNumber
		
	) {
		BooleanBuilder where = dynamicWhere(
			
			ordersId,
			
			
			
			
			
			productsId,
			
			
			
			
			
			
			
			quantityOrdered,
			priceEach,
			orderLineNumber
				
		);
		return orderDetailsRepository.findAll(where);
	}
	
	@Override
	public Page<OrderDetails> searchPagination(
		Pageable page,
		
		Long ordersId,
		
		
		
		
		
		Long productsId,
		
		
		
		
		
		
		
		Integer quantityOrdered,
		Double priceEach,
		Integer orderLineNumber
		
	) {
		BooleanBuilder where = dynamicWhere(
			
			ordersId,
			
			
			
			
			
			productsId,
			
			
			
			
			
			
			
			quantityOrdered,
			priceEach,
			orderLineNumber
			
		);
		return orderDetailsRepository.findAll(where, page);
	}
	
	public BooleanBuilder dynamicWhere(
		
		Long ordersId,
		
		
		
		
		
		Long productsId,
		
		
		
		
		
		
		
		Integer quantityOrdered,
		Double priceEach,
		Integer orderLineNumber
		
	) {
		QOrderDetails qOrderDetails = QOrderDetails.orderDetails;
	
		BooleanBuilder where = new BooleanBuilder();
	
		
		if (ordersId != null) {
			where.and(qOrderDetails.orders.id.eq(ordersId));
		}
		
		
		
		
		
		if (productsId != null) {
			where.and(qOrderDetails.products.id.eq(productsId));
		}
		
		
		
		
		
		
		
		if (quantityOrdered != null) {
			where.and(qOrderDetails.quantityOrdered.eq(quantityOrdered));
		}
		if (priceEach != null) {
			where.and(qOrderDetails.priceEach.eq(priceEach));
		}
		if (orderLineNumber != null) {
			where.and(qOrderDetails.orderLineNumber.eq(orderLineNumber));
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
