package com.vladolium.odinmodel.repositories;

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Marks.MarkType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.domain.*;
import org.springframework.data.querydsl.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface MarksRepository extends JpaRepository<Marks, Long>, QuerydslPredicateExecutor<Marks> {

	Marks findByMarkTypeEquals(MarkType markType);
	
	Marks findByIdEquals(Long id);
	
	Marks findByCommentEquals(String comment);

	Iterable <Marks> findByCustomersIdEquals(Long customersId);
	
	Page <Marks> findByCustomersIdEquals(Long customersId, Pageable page);

	Iterable <Marks> findByCustomersCustomerNameEquals(String customersCustomerName);
	
	Page <Marks> findByCustomersCustomerNameEquals(String customersCustomerName, Pageable page);

//Code between start and end will not be removed during generation.
//Start of user code for this repository
//End of user code
}