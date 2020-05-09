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
		String city,
		String phone,
		String addressLine2,
		String territory,
		String addressLine1,
		String country,
		String state,
		String postalCode
	);
	
	Page<Offices> searchPagination(
		Pageable page,
		String city,
		String phone,
		String addressLine2,
		String territory,
		String addressLine1,
		String country,
		String state,
		String postalCode
	);

	

	

	Offices saveOneWhenIricOnManyToOneRelationship(OfficesEmployees officesEmployees);

//Code between start and end will not be removed during generation.
//Start of user code for this interface
//End of user code
}
