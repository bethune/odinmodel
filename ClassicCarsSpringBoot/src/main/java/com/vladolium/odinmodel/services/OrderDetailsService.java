package com.vladolium.odinmodel.services;

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.OrderDetails.*;

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
public class OrderDetailsService implements OrderDetailsInterface {

	private OrderDetailsRepository orderDetailsRepository;

	@Autowired
	public void setOrderDetailsRepository(OrderDetailsRepository orderDetailsRepository) {
		this.orderDetailsRepository = orderDetailsRepository;
	}

	@Override
	public OrderDetails saveOne(OrderDetails orderDetails) {
		return orderDetailsRepository.save(orderDetails);
	}

	@Override
	public void deleteOneById(Long id) {
	    orderDetailsRepository.deleteById(id);
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

	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code
}
