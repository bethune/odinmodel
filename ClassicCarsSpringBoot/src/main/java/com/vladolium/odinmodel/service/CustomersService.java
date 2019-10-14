package com.vladolium.odinmodel.service;

import com.vladolium.odinmodel.domain.*;
import java.time.*;
import java.util.*;
import org.springframework.data.domain.*;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Customers;
import com.vladolium.odinmodel.domain.Customers.*;

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
		List<Reviews> reviewsList,
		
		
		
		
		
		
		
		Long employeesId,
		String postalCode,
		String lastName,
		String country,
		String city,
		String addressLine2,
		String customerName,
		Double creditLimit,
		String firstName,
		String phone,
		String addressLine1,
		String state
		
	);
	
	Page<Customers> searchPagination(
		Pageable page,
		List<Reviews> reviewsList,
		
		
		
		
		
		
		
		Long employeesId,
		String postalCode,
		String lastName,
		String country,
		String city,
		String addressLine2,
		String customerName,
		Double creditLimit,
		String firstName,
		String phone,
		String addressLine1,
		String state
		
	);
	void deleteOneById(Long id);
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this service
//End of user code
}
