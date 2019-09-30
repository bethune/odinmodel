
package com.vladolium.odinmodel.serviceImpl;

import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.OrderDetails;
import com.vladolium.odinmodel.domain.OrderDetails.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;

import java.time.*;
import java.util.*;

import com.vladolium.odinmodel.repository.OrderDetailsRepository;
import com.vladolium.odinmodel.service.OrderDetailsService;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

	private OrderDetailsRepository orderDetailsRepository;

	@Autowired
	public void setOrderDetailsRepository(OrderDetailsRepository orderDetailsRepository) {
		this.orderDetailsRepository = orderDetailsRepository;
	}

@Override
public OrderDetails createUpdate(OrderDetails orderDetails) {
	return orderDetailsRepository.save(orderDetails);
}

//Code between start and end will not be removed during generation.
//Start of user code serviceImpl
//End of user code

}
