package com.vladolium.odinmodel.service;

import com.vladolium.odinmodel.domain.*;
import java.time.*;
import java.util.*;
import org.springframework.data.domain.*;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Customers;
import com.vladolium.odinmodel.domain.Customers.*;
import com.vladolium.odinmodel.wrapperRequest.*;

public interface CustomersService {

	// covers create & update
	Customers createUpdate(Customers customers);
	
	
	
	
	
	
	
	
	
	Customers readOneById(Long id);
	
	
	
	
	
	
	
	Customers readOneByCustomerName(String customerName);
	
	
	
	
	
	
	
	
	
	
	Iterable<Customers> readAll();
	
	Page<Customers> readAllPagination(Pageable page);
	
	
	
	
	
	
	
	Iterable <Customers> readAllByEmployeesId(Long employeesId);
	
	Page<Customers> readAllByEmployeesId(Long employeesId, Pageable page);
	
	
	
	
	
	
	
	
	
	
	Iterable<Customers> search(
		
		
		
		
		
		
		Long employeesId,
		
		List<Reviews> reviewsList,
		String postalCode,
		String addressLine1,
		String lastName,
		Double creditLimit,
		String firstName,
		String country,
		String customerName,
		String phone,
		String addressLine2,
		String city,
		String state
		
	);
	
	Page<Customers> searchPagination(
		Pageable page,
		
		
		
		
		
		
		Long employeesId,
		
		List<Reviews> reviewsList,
		String postalCode,
		String addressLine1,
		String lastName,
		Double creditLimit,
		String firstName,
		String country,
		String customerName,
		String phone,
		String addressLine2,
		String city,
		String state
		
	);
	
	
	
	
	
	
	
	
	
	void deleteOneById(Long id);
	
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this service
//End of user code
}
