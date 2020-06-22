package com.vladolium.odinmodel.interfaces;

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Orders.*;

import java.time.*;
import java.util.*;

import org.springframework.data.domain.*;

import com.vladolium.odinmodel.wrappers.*;

public interface OrdersInterface {

	Orders saveOne(Orders orders);
	
	void deleteOneById(Long id);
	
	Orders readOneById(Long id);

	Iterable<Orders> readAll();
	
	Page<Orders> readAllPagination(Pageable page);

	Iterable<Orders> search(
		Long customersId,
		LocalDate requiredDate,
		LocalDate orderDate,
		String status,
		LocalDate shippedDate,
		String comments
	);
	
	Page<Orders> searchPagination(
		Pageable page,
		Long customersId,
		LocalDate requiredDate,
		LocalDate orderDate,
		String status,
		LocalDate shippedDate,
		String comments
	);

	Iterable<Orders> readAllByCustomersId(Long customersId);
	
	Page<Orders> readAllByCustomersId(Long customersId, Pageable page);
	
	
	
	
	
	Iterable<Orders> readAllByCustomersCustomerName(String customersCustomerName);
	
	Page<Orders> readAllByCustomersCustomerName(String customersCustomerName, Pageable page);

	

	

//Code between start and end will not be removed during generation.
//Start of user code for this interface
//End of user code
}
