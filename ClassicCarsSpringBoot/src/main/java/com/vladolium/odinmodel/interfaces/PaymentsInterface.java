package com.vladolium.odinmodel.interfaces;

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Payments.*;

import java.time.*;
import java.util.*;

import org.springframework.data.domain.*;

import com.vladolium.odinmodel.wrappers.*;

public interface PaymentsInterface {

	Payments saveOne(Payments payments);
	
	void deleteOneById(Long id);
	
	Payments readOneById(Long id);

	Iterable<Payments> readAll();
	
	Page<Payments> readAllPagination(Pageable page);

	Iterable<Payments> search(
		Long customersId,
		String checkNumber,
		Instant paymentTimestamp,
		Double amount,
		LocalDate paymentDate
	);
	
	Page<Payments> searchPagination(
		Pageable page,
		Long customersId,
		String checkNumber,
		Instant paymentTimestamp,
		Double amount,
		LocalDate paymentDate
	);

	Iterable<Payments> readAllByCustomersId(Long customersId);
	
	Page<Payments> readAllByCustomersId(Long customersId, Pageable page);
	
	
	
	Iterable<Payments> readAllByCustomersCustomerName(String customersCustomerName);
	
	Page<Payments> readAllByCustomersCustomerName(String customersCustomerName, Pageable page);

	

	

//Code between start and end will not be removed during generation.
//Start of user code for this interface
//End of user code
}
