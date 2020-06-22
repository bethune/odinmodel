package com.vladolium.odinmodel.interfaces;

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Offices.*;

import java.time.*;
import java.util.*;

import org.springframework.data.domain.*;

import com.vladolium.odinmodel.wrappers.*;

public interface OfficesInterface {

	Offices saveOne(Offices offices);
	
	void deleteOneById(Long id);
	
	Offices readOneById(Long id);

	Iterable<Offices> readAll();
	
	Page<Offices> readAllPagination(Pageable page);

	Iterable<Offices> search(
		String addressLine1,
		String postalCode,
		String territory,
		String city,
		String phone,
		String country,
		String state,
		String addressLine2
	);
	
	Page<Offices> searchPagination(
		Pageable page,
		String addressLine1,
		String postalCode,
		String territory,
		String city,
		String phone,
		String country,
		String state,
		String addressLine2
	);

	

	

	Offices saveOneWhenIricOnManyToOneRelationship(OfficesEmployees officesEmployees);

//Code between start and end will not be removed during generation.
//Start of user code for this interface
//End of user code
}
