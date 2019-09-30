
package com.vladolium.odinmodel.serviceImpl;

import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Orders;
import com.vladolium.odinmodel.domain.Orders.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;

import java.time.*;
import java.util.*;

import com.vladolium.odinmodel.repository.OrdersRepository;
import com.vladolium.odinmodel.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService {

	private OrdersRepository ordersRepository;

	@Autowired
	public void setOrdersRepository(OrdersRepository ordersRepository) {
		this.ordersRepository = ordersRepository;
	}

@Override
public Orders createUpdate(Orders orders) {
	return ordersRepository.save(orders);
}

//Code between start and end will not be removed during generation.
//Start of user code serviceImpl
//End of user code

}
