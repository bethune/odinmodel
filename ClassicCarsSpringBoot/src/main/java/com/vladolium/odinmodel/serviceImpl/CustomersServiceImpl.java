package com.vladolium.odinmodel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.querydsl.core.BooleanBuilder;
import com.vladolium.odinmodel.domain.Customers;
import com.vladolium.odinmodel.domain.QCustomers;
import com.vladolium.odinmodel.domain.Reviews;
import com.vladolium.odinmodel.repository.CustomersRepository;
import com.vladolium.odinmodel.service.CustomersService;

@Service
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
    public Iterable<Customers> search(

	    Long employeesId,

	    List<Reviews> reviewsList, String city, String firstName, String phone, String lastName,
	    String addressLine1, String customerName, Double creditLimit, String country, String addressLine2,
	    String state, String postalCode

    ) {
	BooleanBuilder where = dynamicWhere(

		employeesId,

		reviewsList, city, firstName, phone, lastName, addressLine1, customerName, creditLimit, country,
		addressLine2, state, postalCode

	);
	return customersRepository.findAll(where);
    }

    @Override
    public Page<Customers> searchPagination(Pageable page,

	    Long employeesId,

	    List<Reviews> reviewsList, String city, String firstName, String phone, String lastName,
	    String addressLine1, String customerName, Double creditLimit, String country, String addressLine2,
	    String state, String postalCode

    ) {
	BooleanBuilder where = dynamicWhere(

		employeesId,

		reviewsList, city, firstName, phone, lastName, addressLine1, customerName, creditLimit, country,
		addressLine2, state, postalCode

	);
	return customersRepository.findAll(where, page);
    }

    public BooleanBuilder dynamicWhere(

	    Long employeesId,

	    List<Reviews> reviewsList, String city, String firstName, String phone, String lastName,
	    String addressLine1, String customerName, Double creditLimit, String country, String addressLine2,
	    String state, String postalCode

    ) {
	QCustomers qCustomers = QCustomers.customers;

	BooleanBuilder where = new BooleanBuilder();

	if (employeesId != null) {
	    where.and(qCustomers.employees.id.eq(employeesId));
	}

	if (reviewsList != null) {
	    where.and(qCustomers.reviewsList.any().in(reviewsList));
	}
	if (city != null) {
	    where.and(qCustomers.city.startsWithIgnoreCase(city));
	}
	if (firstName != null) {
	    where.and(qCustomers.firstName.containsIgnoreCase(firstName));
	}
	if (phone != null) {
	    where.and(qCustomers.phone.containsIgnoreCase(phone));
	}
	if (lastName != null) {
	    where.and(qCustomers.lastName.containsIgnoreCase(lastName));
	}
	if (addressLine1 != null) {
	    where.and(qCustomers.addressLine1.containsIgnoreCase(addressLine1));
	}
	if (customerName != null) {
	    where.and(qCustomers.customerName.containsIgnoreCase(customerName));
	}
	if (creditLimit != null) {
	    where.and(qCustomers.creditLimit.eq(creditLimit));
	}
	if (country != null) {
	    where.and(qCustomers.country.containsIgnoreCase(country));
	}
	if (addressLine2 != null) {
	    where.and(qCustomers.addressLine2.containsIgnoreCase(addressLine2));
	}
	if (state != null) {
	    where.and(qCustomers.state.containsIgnoreCase(state));
	}
	if (postalCode != null) {
	    where.and(qCustomers.postalCode.containsIgnoreCase(postalCode));
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
