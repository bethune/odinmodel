package com.vladolium.odinmodel.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.inject.Inject;
import javax.annotation.PostConstruct;
import com.vladolium.odinmodel.model.*;
import java.time.*;
import java.util.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.querydsl.*;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import com.querydsl.core.BooleanBuilder;
import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.OrderDetails;
import com.vladolium.odinmodel.model.OrderDetails.*;
import com.vladolium.odinmodel.repository.*;
import com.vladolium.odinmodel.repository.OrderDetailsRepository;
import com.vladolium.odinmodel.wrapper.*;

@Stateless
public class OrderDetailsService {

 	@PersistenceContext
    private EntityManager em;

	private OrderDetailsRepository orderDetailsRepository;
	
	@PostConstruct
	private void init() {
		RepositoryFactorySupport factory = new JpaRepositoryFactory(em);
		this.orderDetailsRepository = factory.getRepository(OrderDetailsRepository.class);
	}

	// covers create, update and update with IRIC
	public OrderDetails createUpdate(OrderDetails orderDetails) {
		return orderDetailsRepository.save(orderDetails);
	}
	
	
	
	
	
	public OrderDetails readOneById(Long id) {
		return orderDetailsRepository.getOne(id);
	}
	
	
	
	
	
	
	
	public Iterable<OrderDetails> readAll() {
		return orderDetailsRepository.findAll();
	}
	
	public Page<OrderDetails> readAllPagination(Pageable page) {
		return orderDetailsRepository.findAll(page);
	}
	
	
	
	
	
	
	
	public Iterable<OrderDetails> readAllByProductsId(Long productsId) {
		return orderDetailsRepository.findByProductsIdEquals(productsId);
	}
	
	public Page<OrderDetails> readAllByProductsId(Long productsId, Pageable page) {
		return orderDetailsRepository.findByProductsIdEquals(productsId, page);
	}
	
	
	
	
	public Iterable<OrderDetails> readAllByProductsProductCode(String productsProductCode) {
		return orderDetailsRepository.findByProductsProductCodeEquals(productsProductCode);
	}
	
	public Page<OrderDetails> readAllByProductsProductCode(String productsProductCode, Pageable page) {
		return orderDetailsRepository.findByProductsProductCodeEquals(productsProductCode, page);
	}
	
	
	
	
	
	
	
	
	public Iterable<OrderDetails> search(
		
		
		
		
		
		
		Long productsId,
		
		
		Long ordersId,
		
		
		
		
		
		Integer orderLineNumber,
		Double priceEach,
		Integer quantityOrdered
		
	) {
		BooleanBuilder where = dynamicWhere(
			
			
			
			
			
			
			productsId,
			
			
			ordersId,
			
			
			
			
			
			orderLineNumber,
			priceEach,
			quantityOrdered
				
		);
		return orderDetailsRepository.findAll(where);
	}
	
	public Page<OrderDetails> searchPagination(
		Pageable page,
		
		
		
		
		
		
		Long productsId,
		
		
		Long ordersId,
		
		
		
		
		
		Integer orderLineNumber,
		Double priceEach,
		Integer quantityOrdered
		
	) {
		BooleanBuilder where = dynamicWhere(
			
			
			
			
			
			
			productsId,
			
			
			ordersId,
			
			
			
			
			
			orderLineNumber,
			priceEach,
			quantityOrdered
			
		);
		return orderDetailsRepository.findAll(where, page);
	}
	
	public BooleanBuilder dynamicWhere(
		
		
		
		
		
		
		Long productsId,
		
		
		Long ordersId,
		
		
		
		
		
		Integer orderLineNumber,
		Double priceEach,
		Integer quantityOrdered
		
	) {
		QOrderDetails qOrderDetails = QOrderDetails.orderDetails;
	
		BooleanBuilder where = new BooleanBuilder();
	
		
		
		
		
		
		
		if (productsId != null) {
			where.and(qOrderDetails.products.id.eq(productsId));
		}
		
		
		if (ordersId != null) {
			where.and(qOrderDetails.orders.id.eq(ordersId));
		}
		
		
		
		
		
		if (orderLineNumber != null) {
			where.and(qOrderDetails.orderLineNumber.eq(orderLineNumber));
		}
		if (priceEach != null) {
			where.and(qOrderDetails.priceEach.eq(priceEach));
		}
		if (quantityOrdered != null) {
			where.and(qOrderDetails.quantityOrdered.eq(quantityOrdered));
		}
		
	
		return where;
	}
	
	
	
	
	public void deleteOneById(Long id) {
	    orderDetailsRepository.deleteById(id);
	}
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this service
//End of user code
}
