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
		String city,
		String phone,
		String addressLine2,
		String firstName,
		Double creditLimit,
		String customerName,
		String addressLine1,
		String country,
		String lastName,
		String state,
		String postalCode
	);
	
	Page<Customers> searchPagination(
		Pageable page,
		Long employeesId,
		
		
		List<Reviews> reviewsList,
		String city,
		String phone,
		String addressLine2,
		String firstName,
		Double creditLimit,
		String customerName,
		String addressLine1,
		String country,
		String lastName,
		String state,
		String postalCode
	);

	Iterable<Customers> readAllByEmployeesId(Long employeesId);
	
	Page<Customers> readAllByEmployeesId(Long employeesId, Pageable page);

	Customers readOneByCustomerName(String customerName);

	

//Code between start and end will not be removed during generation.
//Start of user code for this interface
//End of user code
}
