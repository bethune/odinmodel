package com.vladolium.odinmodel.interfaces;

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Employees.*;

import java.time.*;
import java.util.*;

import org.springframework.data.domain.*;

import com.vladolium.odinmodel.wrappers.*;

public interface EmployeesInterface {

	Employees saveOne(Employees employees);
	
	void deleteOneById(Long id);
	
	Employees readOneById(Long id);

	Iterable<Employees> readAll();
	
	Page<Employees> readAllPagination(Pageable page);

	Iterable<Employees> search(
		Long officesId,
		
		
		List<Marks> marksList,
		Boolean isActive,
		Integer reportsTo,
		String lastName,
		String extension,
		String email,
		String jobTitle,
		String firstName
	);
	
	Page<Employees> searchPagination(
		Pageable page,
		Long officesId,
		
		
		List<Marks> marksList,
		Boolean isActive,
		Integer reportsTo,
		String lastName,
		String extension,
		String email,
		String jobTitle,
		String firstName
	);

	Iterable<Employees> readAllByOfficesId(Long officesId);
	
	Page<Employees> readAllByOfficesId(Long officesId, Pageable page);

	

	

//Code between start and end will not be removed during generation.
//Start of user code for this interface
//End of user code
}
