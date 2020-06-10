package com.vladolium.odinmodel.services;

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Customers.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.time.*;
import java.util.*;

import com.vladolium.odinmodel.repositories.*;
//import com.vladolium.odinmodel.specifications.*;
import com.vladolium.odinmodel.interfaces.*;
import com.vladolium.odinmodel.wrappers.*;

import com.querydsl.core.BooleanBuilder;
/*
@Service
@Transactional
public class CustomersServiceQuerydsl implements CustomersInterface {

	private CustomersRepository customersRepository;

	@Autowired
	public void setCustomersRepository(CustomersRepository customersRepository) {
		this.customersRepository = customersRepository;
	}

	@Override
	public Customers saveOne(Customers customers) {
		return customersRepository.save(customers);
	}

	@Override
	public void deleteOneById(Long id) {
	    customersRepository.deleteById(id);
	}
	
	@Override
	public Customers readOneById(Long id) {
		return customersRepository.getOne(id);
	}

	@Override
	public Iterable<Customers> readAll() {
		return customersRepository.findAll();
	}
	
	@Override
	public Page<Customers> readAllPagination(Pageable page) {
		return customersRepository.findAll(page);
	}

	@Override
	public Iterable<Customers> search(
		Long employeesId,
		
		
		List<Reviews> reviewsList,
		String addressLine1,
		String addressLine2,
		String customerName,
		String country,
		String phone,
		String state,
		Double creditLimit,
		String postalCode,
		String city,
		String firstName,
		String lastName
	) {
		BooleanBuilder where = dynamicWhere(
			employeesId,
			
			
			reviewsList,
			addressLine1,
			addressLine2,
			customerName,
			country,
			phone,
			state,
			creditLimit,
			postalCode,
			city,
			firstName,
			lastName	
		);
		return customersRepository.findAll(where);
	}
	
	@Override
	public Page<Customers> searchPagination(
		Pageable page,
		Long employeesId,
		
		
		List<Reviews> reviewsList,
		String addressLine1,
		String addressLine2,
		String customerName,
		String country,
		String phone,
		String state,
		Double creditLimit,
		String postalCode,
		String city,
		String firstName,
		String lastName
	) {
		BooleanBuilder where = dynamicWhere(
			employeesId,
			
			
			reviewsList,
			addressLine1,
			addressLine2,
			customerName,
			country,
			phone,
			state,
			creditLimit,
			postalCode,
			city,
			firstName,
			lastName
		);
		return customersRepository.findAll(where, page);
	}
	
	public BooleanBuilder dynamicWhere(
		Long employeesId,
		
		
		List<Reviews> reviewsList,
		String addressLine1,
		String addressLine2,
		String customerName,
		String country,
		String phone,
		String state,
		Double creditLimit,
		String postalCode,
		String city,
		String firstName,
		String lastName
	) {
		QCustomers qCustomers = QCustomers.customers;
	
		BooleanBuilder where = new BooleanBuilder();
	
		if (employeesId != null) {
			where.and(qCustomers.employees.id.eq(employeesId));
		}
		
		
		if (reviewsList != null) {
			where.and(qCustomers.reviewsList.any().in(reviewsList));
		}
		if (addressLine1 != null) {
			where.and(qCustomers.addressLine1.containsIgnoreCase(addressLine1));
		}
		if (addressLine2 != null) {
			where.and(qCustomers.addressLine2.containsIgnoreCase(addressLine2));
		}
		if (customerName != null) {
			where.and(qCustomers.customerName.containsIgnoreCase(customerName));
		}
		if (country != null) {
			where.and(qCustomers.country.containsIgnoreCase(country));
		}
		if (phone != null) {
			where.and(qCustomers.phone.containsIgnoreCase(phone));
		}
		if (state != null) {
			where.and(qCustomers.state.containsIgnoreCase(state));
		}
		if (creditLimit != null) {
			where.and(qCustomers.creditLimit.eq(creditLimit));
		}
		if (postalCode != null) {
			where.and(qCustomers.postalCode.containsIgnoreCase(postalCode));
		}
		if (city != null) {
			where.and(qCustomers.city.containsIgnoreCase(city));
		}
		if (firstName != null) {
			where.and(qCustomers.firstName.containsIgnoreCase(firstName));
		}
		if (lastName != null) {
			where.and(qCustomers.lastName.containsIgnoreCase(lastName));
		}
	
		return where;
	}


	@Override
	public Iterable<Customers> readAllByEmployeesId(Long employeesId) {
		return customersRepository.findByEmployeesIdEquals(employeesId);
	}
	
	@Override
	public Page<Customers> readAllByEmployeesId(Long employeesId, Pageable page) {
		return customersRepository.findByEmployeesIdEquals(employeesId, page);
	}

	@Override
	public Customers readOneByCustomerName(String customerName) {
		return customersRepository.findByCustomerNameEquals(customerName);
	}
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code
}*/
