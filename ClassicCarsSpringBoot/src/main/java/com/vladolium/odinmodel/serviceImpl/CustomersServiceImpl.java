package com.vladolium.odinmodel.serviceImpl;

import com.vladolium.odinmodel.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Transactional;
import java.time.*;
import java.util.*;
import com.vladolium.odinmodel.repository.*;
import com.vladolium.odinmodel.repository.CustomersRepository;
import com.vladolium.odinmodel.service.CustomersService;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Customers;
import com.vladolium.odinmodel.domain.Customers.*;
import com.vladolium.odinmodel.wrapper.*;
import com.querydsl.core.BooleanBuilder;

@Service
@Transactional
public class CustomersServiceImpl implements CustomersService {

	private CustomersRepository customersRepository;

	@Autowired
	public void setCustomersRepository(CustomersRepository customersRepository) {
		this.customersRepository = customersRepository;
	}

	// covers create, update and update with IRIC
	@Override
	public Customers createUpdate(Customers customers) {
		return customersRepository.save(customers);
	}
	
	
	@Override
	public Customers readOneById(Long id) {
		return customersRepository.getOne(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public Customers readOneByCustomerName(String customerName) {
		return customersRepository.findByCustomerNameEquals(customerName);
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
	public Iterable<Customers> readAllByEmployeesId(Long employeesId) {
		return customersRepository.findByEmployeesIdEquals(employeesId);
	}
	
	@Override
	public Page<Customers> readAllByEmployeesId(Long employeesId, Pageable page) {
		return customersRepository.findByEmployeesIdEquals(employeesId, page);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public Iterable<Customers> search(
		List<Reviews> reviewsList,
		Long employeesId,
		
		
		
		
		
		
		
		String lastName,
		String country,
		String postalCode,
		Double creditLimit,
		String phone,
		String firstName,
		String customerName,
		String addressLine2,
		String city,
		String addressLine1,
		String state
		
	) {
		BooleanBuilder where = dynamicWhere(
			reviewsList,
			employeesId,
			
			
			
			
			
			
			
			lastName,
			country,
			postalCode,
			creditLimit,
			phone,
			firstName,
			customerName,
			addressLine2,
			city,
			addressLine1,
			state
				
		);
		return customersRepository.findAll(where);
	}
	
	@Override
	public Page<Customers> searchPagination(
		Pageable page,
		List<Reviews> reviewsList,
		Long employeesId,
		
		
		
		
		
		
		
		String lastName,
		String country,
		String postalCode,
		Double creditLimit,
		String phone,
		String firstName,
		String customerName,
		String addressLine2,
		String city,
		String addressLine1,
		String state
		
	) {
		BooleanBuilder where = dynamicWhere(
			reviewsList,
			employeesId,
			
			
			
			
			
			
			
			lastName,
			country,
			postalCode,
			creditLimit,
			phone,
			firstName,
			customerName,
			addressLine2,
			city,
			addressLine1,
			state
			
		);
		return customersRepository.findAll(where, page);
	}
	
	public BooleanBuilder dynamicWhere(
		List<Reviews> reviewsList,
		Long employeesId,
		
		
		
		
		
		
		
		String lastName,
		String country,
		String postalCode,
		Double creditLimit,
		String phone,
		String firstName,
		String customerName,
		String addressLine2,
		String city,
		String addressLine1,
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
		
		
		
		
		
		
		
		if (lastName != null) {
			where.and(qCustomers.lastName.containsIgnoreCase(lastName));
		}
		if (country != null) {
			where.and(qCustomers.country.containsIgnoreCase(country));
		}
		if (postalCode != null) {
			where.and(qCustomers.postalCode.containsIgnoreCase(postalCode));
		}
		if (creditLimit != null) {
			where.and(qCustomers.creditLimit.eq(creditLimit));
		}
		if (phone != null) {
			where.and(qCustomers.phone.containsIgnoreCase(phone));
		}
		if (firstName != null) {
			where.and(qCustomers.firstName.containsIgnoreCase(firstName));
		}
		if (customerName != null) {
			where.and(qCustomers.customerName.containsIgnoreCase(customerName));
		}
		if (addressLine2 != null) {
			where.and(qCustomers.addressLine2.containsIgnoreCase(addressLine2));
		}
		if (city != null) {
			where.and(qCustomers.city.containsIgnoreCase(city));
		}
		if (addressLine1 != null) {
			where.and(qCustomers.addressLine1.containsIgnoreCase(addressLine1));
		}
		if (state != null) {
			where.and(qCustomers.state.containsIgnoreCase(state));
		}
		
	
		return where;
	}
	
	@Override
	public void deleteOneById(Long id) {
	    customersRepository.deleteById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code
}
