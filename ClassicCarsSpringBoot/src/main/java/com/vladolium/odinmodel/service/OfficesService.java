package com.vladolium.odinmodel.service;

import com.vladolium.odinmodel.domain.*;
import java.time.*;
import java.util.*;
import org.springframework.data.domain.*;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Offices;
import com.vladolium.odinmodel.domain.Offices.*;
import com.vladolium.odinmodel.wrapperRequest.*;

public interface OfficesService {

	// covers create & update
	Offices createUpdate(Offices offices);
	
	Offices createOneIric(OfficesEmployees officesEmployees);
	
	
	Offices readOneById(Long id);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	Iterable<Offices> readAll();
	
	Page<Offices> readAllPagination(Pageable page);
	
	
	
	Iterable<Offices> search(
		String postalCode,
		String state,
		String territory,
		String city,
		String addressLine1,
		String addressLine2,
		String country,
		String phone
		
	);
	
	Page<Offices> searchPagination(
		Pageable page,
		String postalCode,
		String state,
		String territory,
		String city,
		String addressLine1,
		String addressLine2,
		String country,
		String phone
		
	);
	
	void deleteOneById(Long id);
	
	
	
	
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this service
//End of user code
}
