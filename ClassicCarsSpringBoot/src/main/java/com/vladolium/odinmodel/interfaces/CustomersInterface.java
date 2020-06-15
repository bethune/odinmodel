package com.vladolium.odinmodel.interfaces;

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Customers.*;

import java.time.*;
import java.util.*;

import org.springframework.data.domain.*;

import com.vladolium.odinmodel.wrappers.*;

public interface CustomersInterface {

	Customers saveOne(Customers customers);
	
	void deleteOneById(Long id);
	
	Customers readOneById(Long id);

	Iterable<Customers> readAll();
	
	Page<Customers> readAllPagination(Pageable page);

	Iterable<Customers> search(
		Long employeesId,
		
		
		List<Reviews> reviewsList,
		String state,
		String customerName,
		String phone,
		String lastName,
		String firstName,
		String country,
		String addressLine1,
		String city,
		Double creditLimit,
		String addressLine2,
		String postalCode
	);
	
	Page<Customers> searchPagination(
		Pageable page,
		Long employeesId,
		
		
		List<Reviews> reviewsList,
		String state,
		String customerName,
		String phone,
		String lastName,
		String firstName,
		String country,
		String addressLine1,
		String city,
		Double creditLimit,
		String addressLine2,
		String postalCode
	);

	Iterable<Customers> readAllByEmployeesId(Long employeesId);
	
	Page<Customers> readAllByEmployeesId(Long employeesId, Pageable page);

	Customers readOneByCustomerName(String customerName);

	

//Code between start and end will not be removed during generation.
//Start of user code for this interface
//End of user code
}
