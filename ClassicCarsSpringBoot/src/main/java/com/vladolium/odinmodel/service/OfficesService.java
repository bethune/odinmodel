package com.vladolium.odinmodel.service;

import com.vladolium.odinmodel.domain.*;
import java.time.*;
import java.util.*;
import org.springframework.data.domain.*;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Offices;
import com.vladolium.odinmodel.domain.Offices.*;
import com.vladolium.odinmodel.wrapper.*;

public interface OfficesService {

	// covers create, update and update with IRIC
	Offices createUpdate(Offices offices);
	
	Offices createOneIric(OfficesEmployees officesEmployees);
	
	
	
	
	
	
	Offices readOneById(Long id);
	
	
	
	
	
	
	
	
	
	
	
	
	
	Iterable<Offices> readAll();
	
	Page<Offices> readAllPagination(Pageable page);
	
	
	
	Iterable<Offices> search(
		String country,
		String postalCode,
		String phone,
		String territory,
		String addressLine2,
		String city,
		String addressLine1,
		String state
		
	);
	
	Page<Offices> searchPagination(
		Pageable page,
		String country,
		String postalCode,
		String phone,
		String territory,
		String addressLine2,
		String city,
		String addressLine1,
		String state
		
	);
	
	
	
	
	
	void deleteOneById(Long id);
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this service
//End of user code
}
