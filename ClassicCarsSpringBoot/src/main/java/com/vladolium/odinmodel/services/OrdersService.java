package com.vladolium.odinmodel.services;

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Orders.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.time.*;
import java.util.*;

import com.vladolium.odinmodel.repositories.*;
//import com.vladolium.odinmodel.specifications.*;
import com.vladolium.odinmodel.interfaces.*;
import com.vladolium.odinmodel.wrappers.*;

import com.querydsl.core.BooleanBuilder;

@Service
@Transactional
public class OrdersService implements OrdersInterface {

	private OrdersRepository ordersRepository;

	@Autowired
	public void setOrdersRepository(OrdersRepository ordersRepository) {
		this.ordersRepository = ordersRepository;
	}

	@Override
	public Orders saveOne(Orders orders) {
		return ordersRepository.save(orders);
	}

	@Override
	public void deleteOneById(Long id) {
	    ordersRepository.deleteById(id);
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
		LocalDate orderDate,
		LocalDate shippedDate,
		String comments,
		LocalDate requiredDate,
		String status
	) {
		BooleanBuilder where = dynamicWhere(
			customersId,
			orderDate,
			shippedDate,
			comments,
			requiredDate,
			status	
		);
		return ordersRepository.findAll(where);
	}
	
	@Override
	public Page<Orders> searchPagination(
		Pageable page,
		Long customersId,
		LocalDate orderDate,
		LocalDate shippedDate,
		String comments,
		LocalDate requiredDate,
		String status
	) {
		BooleanBuilder where = dynamicWhere(
			customersId,
			orderDate,
			shippedDate,
			comments,
			requiredDate,
			status
		);
		return ordersRepository.findAll(where, page);
	}
	
	public BooleanBuilder dynamicWhere(
		Long customersId,
		LocalDate orderDate,
		LocalDate shippedDate,
		String comments,
		LocalDate requiredDate,
		String status
	) {
		QOrders qOrders = QOrders.orders;
	
		BooleanBuilder where = new BooleanBuilder();
	
		if (customersId != null) {
			where.and(qOrders.customers.id.eq(customersId));
		}
		if (orderDate != null) {
			where.and(qOrders.orderDate.eq(orderDate));
		}
		if (shippedDate != null) {
			where.and(qOrders.shippedDate.eq(shippedDate));
		}
		if (comments != null) {
			where.and(qOrders.comments.eq(comments));
		}
		if (requiredDate != null) {
			where.and(qOrders.requiredDate.eq(requiredDate));
		}
		if (status != null) {
			where.and(qOrders.status.containsIgnoreCase(status));
		}
	
		return where;
	}


	@Override
	public Iterable<Orders> readAllByCustomersId(Long customersId) {
		return ordersRepository.findByCustomersIdEquals(customersId);
	}
	
	@Override
	public Page<Orders> readAllByCustomersId(Long customersId, Pageable page) {
		return ordersRepository.findByCustomersIdEquals(customersId, page);
	}
	
	
	
	@Override
	public Iterable<Orders> readAllByCustomersCustomerName(String customersCustomerName) {
		return ordersRepository.findByCustomersCustomerNameEquals(customersCustomerName);
	}
	
	@Override
	public Page<Orders> readAllByCustomersCustomerName(String customersCustomerName, Pageable page) {
		return ordersRepository.findByCustomersCustomerNameEquals(customersCustomerName, page);
	}

	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code
}
