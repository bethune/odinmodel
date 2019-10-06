package com.vladolium.odinmodel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.vladolium.odinmodel.domain.Customers;

import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Customers;
import com.vladolium.odinmodel.domain.Customers.*;




@Repository
@Transactional
public interface CustomersRepository extends JpaRepository<Customers, Long> {














Customers findByIdEquals(Long id);







Customers findByCustomerNameEquals(String customerName);





//Code between start and end will not be removed during generation.
//Start of user code for this repository
//End of user code
}
