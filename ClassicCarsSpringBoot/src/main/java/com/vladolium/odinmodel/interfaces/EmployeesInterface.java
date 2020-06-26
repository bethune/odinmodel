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
		String firstName,
		String extension,
		Integer reportsTo,
		String email,
		String jobTitle,
		Boolean isActive,
		String lastName
	);
	
	Page<Employees> searchPagination(
		Pageable page,
		Long officesId,
		String firstName,
		String extension,
		Integer reportsTo,
		String email,
		String jobTitle,
		Boolean isActive,
		String lastName
	);

	Iterable<Employees> readAllByOfficesId(Long officesId);
	
	Page<Employees> readAllByOfficesId(Long officesId, Pageable page);

	

	

//Code between start and end will not be removed during generation.
//Start of user code for this interface
//End of user code
}
