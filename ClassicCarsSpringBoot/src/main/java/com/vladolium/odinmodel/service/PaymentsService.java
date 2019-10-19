package com.vladolium.odinmodel.service;

import com.vladolium.odinmodel.domain.*;
import java.time.*;
import java.util.*;
import org.springframework.data.domain.*;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Payments;
import com.vladolium.odinmodel.domain.Payments.*;
import com.vladolium.odinmodel.wrapperRequest.*;

public interface PaymentsService {

	// covers create & update
	Payments createUpdate(Payments payments);
	
	
	
	
	
	
	Payments readOneById(Long id);
	
	
	
	
	
	
	
	Iterable<Payments> readAll();
	
	Page<Payments> readAllPagination(Pageable page);
	
	Iterable <Payments> readAllByCustomersId(Long customersId);
	
	Page<Payments> readAllByCustomersId(Long customersId, Pageable page);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	Iterable <Payments> readAllByCustomersCustomerName(String customersCustomerName);
	
	Page<Payments> readAllByCustomersCustomerName(String customersCustomerName, Pageable page);
	
	
	
	Iterable<Payments> search(
		Long customersId,
		
		
		
		
		
		
		
		
		
		
		
		String checkNumber,
		LocalDate paymentDate,
		Double amount,
		Instant paymentTimestamp
		
	);
	
	Page<Payments> searchPagination(
		Pageable page,
		Long customersId,
		
		
		
		
		
		
		
		
		
		
		
		String checkNumber,
		LocalDate paymentDate,
		Double amount,
		Instant paymentTimestamp
		
	);
	
	
	
	
	void deleteOneById(Long id);
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this service
//End of user code
}
