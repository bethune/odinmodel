package com.vladolium.odinmodel.service;

import com.vladolium.odinmodel.domain.*;
import java.time.*;
import java.util.*;
import org.springframework.data.domain.*;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Employees;
import com.vladolium.odinmodel.domain.Employees.*;

public interface EmployeesService {

	// covers create & update
	Employees createUpdate(Employees employees);
	
	
	
	
	
	
	Employees readOneById(Long id);
	
	
	
	
	
	
	
	
	
	
	Iterable<Employees> readAll();
	Page<Employees> readAllPagination(Pageable page);
	Iterable<Employees> search(
		Long officesId,
		
		
		
		
		
		
		
		
		
		String firstName,
		String email,
		Integer reportsTo,
		String extension,
		String lastName,
		Boolean isActive,
		String jobTitle
		
	);
	
	
	
	
	
	
	
	void deleteOneById(Long id);
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this service
//End of user code

}
