package com.vladolium.odinmodel.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.vladolium.odinmodel.model.Customers;

public interface CustomersRepository extends JpaRepository<Customers, Long>, JpaSpecificationExecutor<Customers> {

	Customers findByCustomerNameEquals(String customerName);
	
	Customers findByIdEquals(Long id);

	Iterable <Customers> findByEmployeesIdEquals(Long employeesId);
	
	Page <Customers> findByEmployeesIdEquals(Long employeesId, Pageable page);

	

//Code between start and end will not be removed during generation.
//Start of user code for this repository
//End of user code
}
