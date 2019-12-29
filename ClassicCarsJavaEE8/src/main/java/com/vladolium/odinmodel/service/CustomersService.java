package com.vladolium.odinmodel.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.inject.Inject;
import javax.annotation.PostConstruct;
import com.vladolium.odinmodel.model.*;
import java.time.*;
import java.util.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.querydsl.*;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import com.querydsl.core.BooleanBuilder;
import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Customers;
import com.vladolium.odinmodel.model.Customers.*;
import com.vladolium.odinmodel.repository.*;
import com.vladolium.odinmodel.repository.CustomersRepository;
import com.vladolium.odinmodel.wrapper.*;

@Stateless
public class CustomersService {

 	@PersistenceContext
    private EntityManager em;

	private CustomersRepository customersRepository;
	
	@PostConstruct
	private void init() {
		RepositoryFactorySupport factory = new JpaRepositoryFactory(em);
		this.customersRepository = factory.getRepository(CustomersRepository.class);
	}

	// covers create, update and update with IRIC
	public Customers createUpdate(Customers customers) {
		return customersRepository.save(customers);
	}
	
	
	
	
	
	
	public Customers readOneById(Long id) {
		return customersRepository.getOne(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public Customers readOneByCustomerName(String customerName) {
		return customersRepository.findByCustomerNameEquals(customerName);
	}
	
	
	
	
	
	
	
	
	
	
	public Iterable<Customers> readAll() {
		return customersRepository.findAll();
	}
	
	public Page<Customers> readAllPagination(Pageable page) {
		return customersRepository.findAll(page);
	}
	
	
	
	public Iterable<Customers> readAllByEmployeesId(Long employeesId) {
		return customersRepository.findByEmployeesIdEquals(employeesId);
	}
	
	public Page<Customers> readAllByEmployeesId(Long employeesId, Pageable page) {
		return customersRepository.findByEmployeesIdEquals(employeesId, page);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Iterable<Customers> search(
		List<Reviews> reviewsList,
		
		
		Long employeesId,
		
		
		
		
		
		String addressLine1,
		String addressLine2,
		String country,
		String lastName,
		Double creditLimit,
		String phone,
		String customerName,
		String city,
		String firstName,
		String postalCode,
		String state
		
	) {
		BooleanBuilder where = dynamicWhere(
			reviewsList,
			
			
			employeesId,
			
			
			
			
			
			addressLine1,
			addressLine2,
			country,
			lastName,
			creditLimit,
			phone,
			customerName,
			city,
			firstName,
			postalCode,
			state
				
		);
		return customersRepository.findAll(where);
	}
	
	public Page<Customers> searchPagination(
		Pageable page,
		List<Reviews> reviewsList,
		
		
		Long employeesId,
		
		
		
		
		
		String addressLine1,
		String addressLine2,
		String country,
		String lastName,
		Double creditLimit,
		String phone,
		String customerName,
		String city,
		String firstName,
		String postalCode,
		String state
		
	) {
		BooleanBuilder where = dynamicWhere(
			reviewsList,
			
			
			employeesId,
			
			
			
			
			
			addressLine1,
			addressLine2,
			country,
			lastName,
			creditLimit,
			phone,
			customerName,
			city,
			firstName,
			postalCode,
			state
			
		);
		return customersRepository.findAll(where, page);
	}
	
	public BooleanBuilder dynamicWhere(
		List<Reviews> reviewsList,
		
		
		Long employeesId,
		
		
		
		
		
		String addressLine1,
		String addressLine2,
		String country,
		String lastName,
		Double creditLimit,
		String phone,
		String customerName,
		String city,
		String firstName,
		String postalCode,
		String state
		
	) {
		QCustomers qCustomers = QCustomers.customers;
	
		BooleanBuilder where = new BooleanBuilder();
	
		if (reviewsList != null) {
			where.and(qCustomers.reviewsList.any().in(reviewsList));
		}
		
		
		if (employeesId != null) {
			where.and(qCustomers.employees.id.eq(employeesId));
		}
		
		
		
		
		
		if (addressLine1 != null) {
			where.and(qCustomers.addressLine1.containsIgnoreCase(addressLine1));
		}
		if (addressLine2 != null) {
			where.and(qCustomers.addressLine2.containsIgnoreCase(addressLine2));
		}
		if (country != null) {
			where.and(qCustomers.country.containsIgnoreCase(country));
		}
		if (lastName != null) {
			where.and(qCustomers.lastName.containsIgnoreCase(lastName));
		}
		if (creditLimit != null) {
			where.and(qCustomers.creditLimit.eq(creditLimit));
		}
		if (phone != null) {
			where.and(qCustomers.phone.containsIgnoreCase(phone));
		}
		if (customerName != null) {
			where.and(qCustomers.customerName.containsIgnoreCase(customerName));
		}
		if (city != null) {
			where.and(qCustomers.city.containsIgnoreCase(city));
		}
		if (firstName != null) {
			where.and(qCustomers.firstName.containsIgnoreCase(firstName));
		}
		if (postalCode != null) {
			where.and(qCustomers.postalCode.containsIgnoreCase(postalCode));
		}
		if (state != null) {
			where.and(qCustomers.state.containsIgnoreCase(state));
		}
		
	
		return where;
	}
	
	
	
	
	
	public void deleteOneById(Long id) {
	    customersRepository.deleteById(id);
	}
	
	
	
	
	
	
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this service
//End of user code
}
