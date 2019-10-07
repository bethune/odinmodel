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
	Iterable<Customers> search(
		List<Reviews> reviewsList,
		
		
		
		
		
		Long employeesId,
		
		
		
		String postalCode,
		String lastName,
		String city,
		String phone,
		String state,
		String customerName,
		String addressLine1,
		Double creditLimit,
		String firstName,
		String addressLine2,
		String country
		
	);
	
	
	
	
	void deleteOneById(Long id);
	
	
	
	
	
	
	
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this service
//End of user code

}
