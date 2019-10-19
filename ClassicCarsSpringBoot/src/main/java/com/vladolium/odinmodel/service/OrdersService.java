package com.vladolium.odinmodel.service;

import com.vladolium.odinmodel.domain.*;
import java.time.*;
import java.util.*;
import org.springframework.data.domain.*;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Orders;
import com.vladolium.odinmodel.domain.Orders.*;
import com.vladolium.odinmodel.wrapperRequest.*;

public interface OrdersService {

	// covers create & update
	Orders createUpdate(Orders orders);
	
	
	
	
	Orders readOneById(Long id);
	
	
	
	
	
	
	
	
	
	
	
	Iterable<Orders> readAll();
	
	Page<Orders> readAllPagination(Pageable page);
	
	Iterable <Orders> readAllByCustomersId(Long customersId);
	
	Page<Orders> readAllByCustomersId(Long customersId, Pageable page);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	Iterable <Orders> readAllByCustomersCustomerName(String customersCustomerName);
	
	Page<Orders> readAllByCustomersCustomerName(String customersCustomerName, Pageable page);
	
	
	
	Iterable<Orders> search(
		Long customersId,
		
		
		
		
		
		
		
		
		
		
		
		LocalDate shippedDate,
		String comments,
		LocalDate orderDate,
		LocalDate requiredDate,
		String status
		
	);
	
	Page<Orders> searchPagination(
		Pageable page,
		Long customersId,
		
		
		
		
		
		
		
		
		
		
		
		LocalDate shippedDate,
		String comments,
		LocalDate orderDate,
		LocalDate requiredDate,
		String status
		
	);
	
	
	void deleteOneById(Long id);
	
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this service
//End of user code
}
