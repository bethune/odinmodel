package com.vladolium.odinmodel.repositories;

import com.vladolium.odinmodel.model.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.domain.*;
import org.springframework.data.querydsl.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ReviewsRepository extends JpaRepository<Reviews, Long>, QuerydslPredicateExecutor<Reviews> {

	Reviews findByIdEquals(Long id);

	Iterable <Reviews> findByCustomersIdEquals(Long customersId);
	
	Page <Reviews> findByCustomersIdEquals(Long customersId, Pageable page);

	Iterable <Reviews> findByCustomersCustomerNameEquals(String customersCustomerName);
	
	Page <Reviews> findByCustomersCustomerNameEquals(String customersCustomerName, Pageable page);

//Code between start and end will not be removed during generation.
//Start of user code for this repository
//End of user code
}
