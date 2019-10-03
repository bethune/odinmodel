package com.vladolium.odinmodel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vladolium.odinmodel.domain.Customers;




public interface CustomersRepository extends JpaRepository<Customers, Long> {














Customers findByIdEquals(Long id);







Customers findByCustomerNameEquals(String customerName);





//Code between start and end will not be removed during generation.
//Start of user code for this repository
//End of user code

}
