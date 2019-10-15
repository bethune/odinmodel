package com.vladolium.odinmodel.service;

import com.vladolium.odinmodel.domain.*;
import java.time.*;
import java.util.*;
import org.springframework.data.domain.*;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Offices;
import com.vladolium.odinmodel.domain.Offices.*;

public interface OfficesService {

	// covers create & update
	Offices createUpdate(Offices offices);
	Offices readOneById(Long id);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	Iterable<Offices> readAll();
	
	Page<Offices> readAllPagination(Pageable page);
	
	
	
	Iterable<Offices> search(
		String postalCode,
		String addressLine1,
		String country,
		String territory,
		String phone,
		String city,
		String addressLine2,
		String state
		
	);
	
	Page<Offices> searchPagination(
		Pageable page,
		String postalCode,
		String addressLine1,
		String country,
		String territory,
		String phone,
		String city,
		String addressLine2,
		String state
		
	);
	void deleteOneById(Long id);
	
	
	
	
	
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this service
//End of user code
}
