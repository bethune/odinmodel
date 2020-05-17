package com.vladolium.odinmodel.repositories;

import com.vladolium.odinmodel.model.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.*;
import org.springframework.data.querydsl.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface CustomersRepositoryQuerydsl extends JpaRepository<Customers, Long>, QuerydslPredicateExecutor<Customers> {

	Customers findByCustomerNameEquals(String customerName);
	
	Customers findByIdEquals(Long id);

	Iterable <Customers> findByEmployeesIdEquals(Long employeesId);
	
	Page <Customers> findByEmployeesIdEquals(Long employeesId, Pageable page);

	

//Code between start and end will not be removed during generation.
//Start of user code for this repository
//End of user code
}
