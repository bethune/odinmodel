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
import com.vladolium.odinmodel.specifications.CustomersSpecification;
import com.vladolium.odinmodel.specifications.OfficesSpecification;
//import com.vladolium.odinmodel.specifications.*;
import com.vladolium.odinmodel.interfaces.*;
import com.vladolium.odinmodel.wrappers.*;

import com.querydsl.core.BooleanBuilder;
/*
@Service
@Transactional
public class CustomersServiceSpecification implements CustomersInterface {

	private CustomersRepositorySpecification customersRepository;

	@Autowired
	public void setCustomersRepository(CustomersRepositorySpecification customersRepository) {
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
		String state,
		String customerName,
		String phone,
		String lastName,
		String firstName,
		String country,
		String addressLine1,
		String city,
		Double creditLimit,
		String addressLine2,
		String postalCode		
	) {
		Specification<Customers> where = dynamicWhere(
			employeesId,
			
			
			reviewsList,
			state,
			customerName,
			phone,
			lastName,
			firstName,
			country,
			addressLine1,
			city,
			creditLimit,
			addressLine2,
			postalCode	
		);
		return customersRepository.findAll(where);
	}
	
	@Override
	public Page<Customers> searchPagination(
		Pageable page,
		Long employeesId,
		
		
		List<Reviews> reviewsList,
		String state,
		String customerName,
		String phone,
		String lastName,
		String firstName,
		String country,
		String addressLine1,
		String city,
		Double creditLimit,
		String addressLine2,
		String postalCode
	) {
		Specification<Customers> where = dynamicWhere(
			employeesId,
			
			
			reviewsList,
			state,
			customerName,
			phone,
			lastName,
			firstName,
			country,
			addressLine1,
			city,
			creditLimit,
			addressLine2,
			postalCode
			
		);
		return customersRepository.findAll(where, page);
	}
	
	public Specification<Customers> dynamicWhere(
			
			Long employeesId,
			
			
			List<Reviews> reviewsList,
			String state,
			String customerName,
			String phone,
			String lastName,
			String firstName,
			String country,
			String addressLine1,
			String city,
			Double creditLimit,
			String addressLine2,
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
				.and(reviewsList == null ? null : CustomersSpecification.getCustomersByReviews(reviewsList))
				;
		
			return where;
		}
	
	/*
	public BooleanBuilder dynamicWhere1(
		Long employeesId,
		
		
		List<Reviews> reviewsList,
		String state,
		String customerName,
		String phone,
		String lastName,
		String firstName,
		String country,
		String addressLine1,
		String city,
		Double creditLimit,
		String addressLine2,
		String postalCode
	) {
		QCustomers qCustomers = QCustomers.customers;
	
		BooleanBuilder where = new BooleanBuilder();
	
		if (employeesId != null) {
			where.and(qCustomers.employees.id.eq(employeesId));
		}
		
		
		if (reviewsList != null) {
			where.and(qCustomers.reviewsList.any().in(reviewsList));
		}
		if (state != null) {
			where.and(qCustomers.state.containsIgnoreCase(state));
		}
		if (customerName != null) {
			where.and(qCustomers.customerName.containsIgnoreCase(customerName));
		}
		if (phone != null) {
			where.and(qCustomers.phone.containsIgnoreCase(phone));
		}
		if (lastName != null) {
			where.and(qCustomers.lastName.containsIgnoreCase(lastName));
		}
		if (firstName != null) {
			where.and(qCustomers.firstName.containsIgnoreCase(firstName));
		}
		if (country != null) {
			where.and(qCustomers.country.containsIgnoreCase(country));
		}
		if (addressLine1 != null) {
			where.and(qCustomers.addressLine1.containsIgnoreCase(addressLine1));
		}
		if (city != null) {
			where.and(qCustomers.city.containsIgnoreCase(city));
		}
		if (creditLimit != null) {
			where.and(qCustomers.creditLimit.eq(creditLimit));
		}
		if (addressLine2 != null) {
			where.and(qCustomers.addressLine2.containsIgnoreCase(addressLine2));
		}
		if (postalCode != null) {
			where.and(qCustomers.postalCode.containsIgnoreCase(postalCode));
		}
	
		return where;
	}
*/
/*
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
