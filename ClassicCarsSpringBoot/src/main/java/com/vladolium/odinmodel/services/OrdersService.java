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


//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code
}
