package com.vladolium.odinmodel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.*;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Customers;
import com.vladolium.odinmodel.domain.Customers.*;
import org.springframework.data.querydsl.*;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CustomersRepository extends JpaRepository<Customers, Long>, QuerydslPredicateExecutor<Customers> {














Customers findByIdEquals(Long id);









Customers findByCustomerNameEquals(String customerName);









Iterable <Customers> findByEmployeesIdEquals(Long employeesId);

Page <Customers> findByEmployeesIdEquals(Long employeesId, Pageable page);












//Code between start and end will not be removed during generation.
//Start of user code for this repository
//End of user code
}
