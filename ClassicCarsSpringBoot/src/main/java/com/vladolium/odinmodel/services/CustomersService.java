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
import com.vladolium.odinmodel.specifications.*;
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
		List<Reviews> reviewsList,
		String city,
		String phone,
		String addressLine2,
		String firstName,
		Double creditLimit,
		String customerName,
		String addressLine1,
		String country,
		String lastName,
		String state,
		String postalCode
		
		
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
		/*Specification<Customers> where = dynamicWhere(
			employeesId,
			reviewsList,
			city,
			phone,
			addressLine2,
			firstName,
			creditLimit,
			customerName,
			addressLine1,
			country,
			lastName,
			state,
			postalCode	
		);*/
		return customersRepository.findAll();
	}
	
	@Override
	public Page<Customers> searchPagination(
		Pageable page,
		Long employeesId,
		List<Reviews> reviewsList,
		String city,
		String phone,
		String addressLine2,
		String firstName,
		Double creditLimit,
		String customerName,
		String addressLine1,
		String country,
		String lastName,
		String state,
		String postalCode
	) {
		Specification<Customers> where = dynamicWhere(
			employeesId,
			reviewsList,
			city,
			phone,
			addressLine2,
			firstName,
			creditLimit,
			customerName,
			addressLine1,
			country,
			lastName,
			state,
			postalCode
		);
		return customersRepository.findAll(where, page);
	}
	
	public Specification<Customers> dynamicWhere(
		Long employeesId,
		List<Reviews> reviewsList,
		String city,
		String phone,
		String addressLine2,
		String firstName,
		Double creditLimit,
		String customerName,
		String addressLine1,
		String country,
		String lastName,
		String state,
		String postalCode
	) {
		Specification<Customers> where = Specification
			.where(city == null ? null : CustomersSpecification.getCustomersByCity(city))
			.and(phone == null ? null : CustomersSpecification.getCustomersByPhone(phone))
			.and(addressLine2 == null ? null : CustomersSpecification.getCustomersByAddressLine2(addressLine2))
			.and(firstName == null ? null : CustomersSpecification.getCustomersByFirstName(firstName))
			.and(creditLimit == null ? null : CustomersSpecification.getCustomersByCreditLimit(creditLimit))
			.and(customerName == null ? null : CustomersSpecification.getCustomersByCustomerName(customerName))
			.and(addressLine1 == null ? null : CustomersSpecification.getCustomersByAddressLine1(addressLine1))
			.and(country == null ? null : CustomersSpecification.getCustomersByCountry(country))
			.and(lastName == null ? null : CustomersSpecification.getCustomersByLastName(lastName))
			.and(state == null ? null : CustomersSpecification.getCustomersByState(state))
			.and(postalCode == null ? null : CustomersSpecification.getCustomersByPostalCode(postalCode))
			.and(employeesId == null ? null : CustomersSpecification.getCustomersByEmployeesId(employeesId))
			.and(reviewsList == null ? null : CustomersSpecification.getCustomersByReviews(reviewsList));
	
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