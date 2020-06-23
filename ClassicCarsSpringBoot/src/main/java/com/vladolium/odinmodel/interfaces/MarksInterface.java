package com.vladolium.odinmodel.interfaces;

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Marks.*;

import java.time.*;
import java.util.*;

import org.springframework.data.domain.*;

import com.vladolium.odinmodel.wrappers.*;

public interface MarksInterface {

	Marks saveOne(Marks marks);
	
	void deleteOneById(Long id);
	
	Marks readOneById(Long id);

	Iterable<Marks> readAll();
	
	Page<Marks> readAllPagination(Pageable page);

	Iterable<Marks> search(
		Long customersId,
		
		
		
		
		
		
		
		
		
		
		Long employeesId,
		String comment,
		MarkType markType
	);
	
	Page<Marks> searchPagination(
		Pageable page,
		Long customersId,
		
		
		
		
		
		
		
		
		
		
		Long employeesId,
		String comment,
		MarkType markType
	);

	Iterable<Marks> readAllByCustomersId(Long customersId);
	
	Page<Marks> readAllByCustomersId(Long customersId, Pageable page);
	
	
	
	Iterable<Marks> readAllByCustomersCustomerName(String customersCustomerName);
	
	Page<Marks> readAllByCustomersCustomerName(String customersCustomerName, Pageable page);
	
	
	
	
	
	
	
	Iterable<Marks> readAllByEmployeesId(Long employeesId);
	
	Page<Marks> readAllByEmployeesId(Long employeesId, Pageable page);

	Marks readOneByComment(String comment);

	

//Code between start and end will not be removed during generation.
//Start of user code for this interface
//End of user code
}
