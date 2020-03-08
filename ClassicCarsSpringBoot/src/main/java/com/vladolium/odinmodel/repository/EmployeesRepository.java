package com.vladolium.odinmodel.repository;

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Employees;
import com.vladolium.odinmodel.model.Employees.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.*;

import org.springframework.data.querydsl.*;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface EmployeesRepository extends JpaRepository<Employees, Long>, QuerydslPredicateExecutor<Employees> {

	Employees findByIdEquals(Long id);

	Iterable<Employees> findByOfficesIdEquals(Long officesId);

	Page<Employees> findByOfficesIdEquals(Long officesId, Pageable page);

//Code between start and end will not be removed during generation.
//Start of user code for this repository
//End of user code
}
