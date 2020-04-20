package com.vladolium.odinmodel.services;

import com.vladolium.odinmodel.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Transactional;

import java.time.*;
import java.util.*;

import com.vladolium.odinmodel.repositories.*;
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

	
	
	



//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code
}
