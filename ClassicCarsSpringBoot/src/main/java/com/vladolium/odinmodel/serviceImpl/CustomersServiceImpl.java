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
import com.vladolium.odinmodel.wrapperRequest.*;
import com.querydsl.core.BooleanBuilder;

@Service
@Transactional
public class CustomersServiceImpl implements CustomersService {

	private CustomersRepository customersRepository;

	@Autowired
	public void setCustomersRepository(CustomersRepository customersRepository) {
		this.customersRepository = customersRepository;
	}

	// covers create & update
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
		
		
		Long employeesId,
		
		
		
		
		
		List<Reviews> reviewsList,
		String lastName,
		String customerName,
		String phone,
		String addressLine2,
		Double creditLimit,
		String addressLine1,
		String firstName,
		String state,
		String postalCode,
		String city,
		String country
		
	) {
		BooleanBuilder where = dynamicWhere(
			
			
			employeesId,
			
			
			
			
			
			reviewsList,
			lastName,
			customerName,
			phone,
			addressLine2,
			creditLimit,
			addressLine1,
			firstName,
			state,
			postalCode,
			city,
			country
				
		);
		return customersRepository.findAll(where);
	}
	
	@Override
	public Page<Customers> searchPagination(
		Pageable page,
		
		
		Long employeesId,
		
		
		
		
		
		List<Reviews> reviewsList,
		String lastName,
		String customerName,
		String phone,
		String addressLine2,
		Double creditLimit,
		String addressLine1,
		String firstName,
		String state,
		String postalCode,
		String city,
		String country
		
	) {
		BooleanBuilder where = dynamicWhere(
			
			
			employeesId,
			
			
			
			
			
			reviewsList,
			lastName,
			customerName,
			phone,
			addressLine2,
			creditLimit,
			addressLine1,
			firstName,
			state,
			postalCode,
			city,
			country
			
		);
		return customersRepository.findAll(where, page);
	}
	
	public BooleanBuilder dynamicWhere(
		
		
		Long employeesId,
		
		
		
		
		
		List<Reviews> reviewsList,
		String lastName,
		String customerName,
		String phone,
		String addressLine2,
		Double creditLimit,
		String addressLine1,
		String firstName,
		String state,
		String postalCode,
		String city,
		String country
		
	) {
		QCustomers qCustomers = QCustomers.customers;
	
		BooleanBuilder where = new BooleanBuilder();
	
		
		
		if (employeesId != null) {
			where.and(qCustomers.employees.id.eq(employeesId));
		}
		
		
		
		
		
		if (reviewsList != null) {
			where.and(qCustomers.reviewsList.any().in(reviewsList));
		}
		if (lastName != null) {
			where.and(qCustomers.lastName.containsIgnoreCase(lastName));
		}
		if (customerName != null) {
			where.and(qCustomers.customerName.containsIgnoreCase(customerName));
		}
		if (phone != null) {
			where.and(qCustomers.phone.containsIgnoreCase(phone));
		}
		if (addressLine2 != null) {
			where.and(qCustomers.addressLine2.containsIgnoreCase(addressLine2));
		}
		if (creditLimit != null) {
			where.and(qCustomers.creditLimit.eq(creditLimit));
		}
		if (addressLine1 != null) {
			where.and(qCustomers.addressLine1.containsIgnoreCase(addressLine1));
		}
		if (firstName != null) {
			where.and(qCustomers.firstName.containsIgnoreCase(firstName));
		}
		if (state != null) {
			where.and(qCustomers.state.containsIgnoreCase(state));
		}
		if (postalCode != null) {
			where.and(qCustomers.postalCode.containsIgnoreCase(postalCode));
		}
		if (city != null) {
			where.and(qCustomers.city.containsIgnoreCase(city));
		}
		if (country != null) {
			where.and(qCustomers.country.containsIgnoreCase(country));
		}
		
	
		return where;
	}
	
	@Override
	public void deleteOneById(Long id) {
		Customers currentCustomers = customersRepository.getOne(id);
		Iterable<Customers> listOfCustomers = customersRepository.findByEmployeesIdEquals(currentCustomers.getEmployees().getId());
		Long size = listOfCustomers.spliterator().getExactSizeIfKnown();
		if (size == 1) {
		    return;
		} else {
		    customersRepository.deleteById(id);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code
}
