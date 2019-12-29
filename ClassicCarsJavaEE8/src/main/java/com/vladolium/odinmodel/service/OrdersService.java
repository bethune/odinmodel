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
import com.vladolium.odinmodel.model.Orders;
import com.vladolium.odinmodel.model.Orders.*;
import com.vladolium.odinmodel.repository.*;
import com.vladolium.odinmodel.repository.OrdersRepository;
import com.vladolium.odinmodel.wrapper.*;

@Stateless
public class OrdersService {

 	@PersistenceContext
    private EntityManager em;

	private OrdersRepository ordersRepository;
	
	@PostConstruct
	private void init() {
		RepositoryFactorySupport factory = new JpaRepositoryFactory(em);
		this.ordersRepository = factory.getRepository(OrdersRepository.class);
	}

	// covers create, update and update with IRIC
	public Orders createUpdate(Orders orders) {
		return ordersRepository.save(orders);
	}
	
	
	public Orders readOneById(Long id) {
		return ordersRepository.getOne(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Iterable<Orders> readAll() {
		return ordersRepository.findAll();
	}
	
	public Page<Orders> readAllPagination(Pageable page) {
		return ordersRepository.findAll(page);
	}
	
	
	
	
	
	public Iterable<Orders> readAllByCustomersId(Long customersId) {
		return ordersRepository.findByCustomersIdEquals(customersId);
	}
	
	public Page<Orders> readAllByCustomersId(Long customersId, Pageable page) {
		return ordersRepository.findByCustomersIdEquals(customersId, page);
	}
	
	
	
	
	
	
	
	
	
	
	public Iterable<Orders> readAllByCustomersCustomerName(String customersCustomerName) {
		return ordersRepository.findByCustomersCustomerNameEquals(customersCustomerName);
	}
	
	public Page<Orders> readAllByCustomersCustomerName(String customersCustomerName, Pageable page) {
		return ordersRepository.findByCustomersCustomerNameEquals(customersCustomerName, page);
	}
	
	
	
	
	
	
	
	
	
	
	public Iterable<Orders> search(
		
		
		
		
		Long customersId,
		
		
		
		
		
		
		
		LocalDate orderDate,
		LocalDate requiredDate,
		LocalDate shippedDate,
		String status,
		String comments
		
	) {
		BooleanBuilder where = dynamicWhere(
			
			
			
			
			customersId,
			
			
			
			
			
			
			
			orderDate,
			requiredDate,
			shippedDate,
			status,
			comments
				
		);
		return ordersRepository.findAll(where);
	}
	
	public Page<Orders> searchPagination(
		Pageable page,
		
		
		
		
		Long customersId,
		
		
		
		
		
		
		
		LocalDate orderDate,
		LocalDate requiredDate,
		LocalDate shippedDate,
		String status,
		String comments
		
	) {
		BooleanBuilder where = dynamicWhere(
			
			
			
			
			customersId,
			
			
			
			
			
			
			
			orderDate,
			requiredDate,
			shippedDate,
			status,
			comments
			
		);
		return ordersRepository.findAll(where, page);
	}
	
	public BooleanBuilder dynamicWhere(
		
		
		
		
		Long customersId,
		
		
		
		
		
		
		
		LocalDate orderDate,
		LocalDate requiredDate,
		LocalDate shippedDate,
		String status,
		String comments
		
	) {
		QOrders qOrders = QOrders.orders;
	
		BooleanBuilder where = new BooleanBuilder();
	
		
		
		
		
		if (customersId != null) {
			where.and(qOrders.customers.id.eq(customersId));
		}
		
		
		
		
		
		
		
		if (orderDate != null) {
			where.and(qOrders.orderDate.eq(orderDate));
		}
		if (requiredDate != null) {
			where.and(qOrders.requiredDate.eq(requiredDate));
		}
		if (shippedDate != null) {
			where.and(qOrders.shippedDate.eq(shippedDate));
		}
		if (status != null) {
			where.and(qOrders.status.containsIgnoreCase(status));
		}
		if (comments != null) {
			where.and(qOrders.comments.eq(comments));
		}
		
	
		return where;
	}
	
	public void deleteOneById(Long id) {
	    ordersRepository.deleteById(id);
	}
	
	
	
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this service
//End of user code
}
