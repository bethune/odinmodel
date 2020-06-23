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

@Service
@Transactional
public class CustomersService implements CustomersInterface {

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
		String state,
		String city,
		String customerName,
		String firstName,
		String lastName,
		String country,
		String addressLine1,
		Double creditLimit,
		String addressLine2,
		String phone,
		String postalCode
	) {
		BooleanBuilder where = dynamicWhere(
			employeesId,
			state,
			city,
			customerName,
			firstName,
			lastName,
			country,
			addressLine1,
			creditLimit,
			addressLine2,
			phone,
			postalCode	
		);
		return customersRepository.findAll(where);
	}
	
	@Override
	public Page<Customers> searchPagination(
		Pageable page,
		Long employeesId,
		String state,
		String city,
		String customerName,
		String firstName,
		String lastName,
		String country,
		String addressLine1,
		Double creditLimit,
		String addressLine2,
		String phone,
		String postalCode
	) {
		BooleanBuilder where = dynamicWhere(
			employeesId,
			state,
			city,
			customerName,
			firstName,
			lastName,
			country,
			addressLine1,
			creditLimit,
			addressLine2,
			phone,
			postalCode
		);
		return customersRepository.findAll(where, page);
	}
	
	public BooleanBuilder dynamicWhere(
		Long employeesId,
		String state,
		String city,
		String customerName,
		String firstName,
		String lastName,
		String country,
		String addressLine1,
		Double creditLimit,
		String addressLine2,
		String phone,
		String postalCode
	) {
		QCustomers qCustomers = QCustomers.customers;
	
		BooleanBuilder where = new BooleanBuilder();
	
		if (employeesId != null) {
			where.and(qCustomers.employees.id.eq(employeesId));
		}
		if (state != null) {
			where.and(qCustomers.state.containsIgnoreCase(state));
		}
		if (city != null) {
			where.and(qCustomers.city.containsIgnoreCase(city));
		}
		if (customerName != null) {
			where.and(qCustomers.customerName.containsIgnoreCase(customerName));
		}
		if (firstName != null) {
			where.and(qCustomers.firstName.containsIgnoreCase(firstName));
		}
		if (lastName != null) {
			where.and(qCustomers.lastName.containsIgnoreCase(lastName));
		}
		if (country != null) {
			where.and(qCustomers.country.containsIgnoreCase(country));
		}
		if (addressLine1 != null) {
			where.and(qCustomers.addressLine1.containsIgnoreCase(addressLine1));
		}
		if (creditLimit != null) {
			where.and(qCustomers.creditLimit.eq(creditLimit));
		}
		if (addressLine2 != null) {
			where.and(qCustomers.addressLine2.containsIgnoreCase(addressLine2));
		}
		if (phone != null) {
			where.and(qCustomers.phone.containsIgnoreCase(phone));
		}
		if (postalCode != null) {
			where.and(qCustomers.postalCode.containsIgnoreCase(postalCode));
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
}
