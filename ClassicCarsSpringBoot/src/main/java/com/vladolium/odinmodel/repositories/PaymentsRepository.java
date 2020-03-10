package com.vladolium.odinmodel.repositories; 

import com.vladolium.odinmodel.model.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.*;
import org.springframework.data.querydsl.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface PaymentsRepository extends JpaRepository<Payments, Long>, QuerydslPredicateExecutor<Payments> {






	Payments findByIdEquals(Long id);
	
	
	
	
	

	
	
	
	
	
	
	
	
	Iterable <Payments> findByCustomersIdEquals(Long customersId);
	
	Page <Payments> findByCustomersIdEquals(Long customersId, Pageable page);
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	Iterable <Payments> findByCustomersCustomerNameEquals(String customersCustomerName);
	
	Page <Payments> findByCustomersCustomerNameEquals(String customersCustomerName, Pageable page);
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this repository
//End of user code
}
