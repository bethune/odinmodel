package com.vladolium.odinmodel.service;

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.OrderDetails;
import com.vladolium.odinmodel.model.OrderDetails.*;
import com.vladolium.odinmodel.repository.*;
import com.vladolium.odinmodel.repository.OrderDetailsRepository;
import com.vladolium.odinmodel.interfaces.OrderDetailsInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Transactional;
import java.time.*;
import java.util.*;

import com.vladolium.odinmodel.wrapper.*;
import com.querydsl.core.BooleanBuilder;

@Service
@Transactional
public class OrderDetailsService implements OrderDetailsInterface {

	private OrderDetailsRepository orderDetailsRepository;

	@Autowired
	public void setOrderDetailsRepository(OrderDetailsRepository orderDetailsRepository) {
		this.orderDetailsRepository = orderDetailsRepository;
	}


//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code
}
