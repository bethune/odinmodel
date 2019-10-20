package com.vladolium.odinmodel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.*;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Payments;
import com.vladolium.odinmodel.domain.Payments.*;
import org.springframework.data.querydsl.*;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;






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
