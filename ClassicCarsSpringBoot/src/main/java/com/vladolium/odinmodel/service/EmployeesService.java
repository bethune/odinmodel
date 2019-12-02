package com.vladolium.odinmodel.service;

import com.vladolium.odinmodel.domain.*;
import java.time.*;
import java.util.*;
import org.springframework.data.domain.*;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Employees;
import com.vladolium.odinmodel.domain.Employees.*;
import com.vladolium.odinmodel.wrapper.*;

public interface EmployeesService {

	// covers create, update and update with IRIC
	Employees createUpdate(Employees employees);
	
	
	Employees readOneById(Long id);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	Iterable<Employees> readAll();
	
	Page<Employees> readAllPagination(Pageable page);
	
	
	
	
	
	
	Iterable <Employees> readAllByOfficesId(Long officesId);
	
	Page<Employees> readAllByOfficesId(Long officesId, Pageable page);
	
	
	
	
	
	
	
	
	
	
	
	
	
	Iterable<Employees> search(
		
		
		
		
		
		Long officesId,
		
		
		
		Boolean isActive,
		String extension,
		Integer reportsTo,
		String jobTitle,
		String lastName,
		String email,
		String firstName
		
	);
	
	Page<Employees> searchPagination(
		Pageable page,
		
		
		
		
		
		Long officesId,
		
		
		
		Boolean isActive,
		String extension,
		Integer reportsTo,
		String jobTitle,
		String lastName,
		String email,
		String firstName
		
	);
	void deleteOneById(Long id);
	
	
	
	
	
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this service
//End of user code
}
