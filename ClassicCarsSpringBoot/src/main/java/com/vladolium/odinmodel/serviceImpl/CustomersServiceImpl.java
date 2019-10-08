package com.vladolium.odinmodel.serviceImpl;

import static org.jooq.impl.DSL.trueCondition;

import java.util.List;

import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vladolium.odinmodel.domain.Customers;
import com.vladolium.odinmodel.domain.Reviews;
import com.vladolium.odinmodel.repository.CustomersRepository;
import com.vladolium.odinmodel.service.CustomersService;

@Service
public class CustomersServiceImpl implements CustomersService {

    private final DSLContext jooq;

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
    public Iterable<Customers> search(List<Reviews> reviewsList,

	    Long employeesId,

	    String postalCode, String lastName, String city, String phone, String state, String customerName,
	    String addressLine1, Double creditLimit, String firstName, String addressLine2, String country

    ) {
	Condition condition = dynamicCondition(reviewsList,

		employeesId,

		postalCode, lastName, city, phone, state, customerName, addressLine1, creditLimit, firstName,
		addressLine2, country);
	return customersRepository.findAll(condition);
    }

    public Condition dynamicCondition(List<Reviews> reviewsList,

	    Long employeesId,

	    String postalCode, String lastName, String city, String phone, String state, String customerName,
	    String addressLine1, Double creditLimit, String firstName, String addressLine2, String country

    ) {
	Condition condition = trueCondition();

	if (reviewsList != null) {
	    where.and(qCustomers.reviewsList.any().in(reviewsList));
	}

	if (employeesId != null) {
	    condition.and(Customers.EMPLOYEES.id.eq(employeesId));
	}

	if (postalCode != null) {
	    where.and(qCustomers.postalCode.containsIgnoreCase(postalCode));
	}
	if (lastName != null) {
	    where.and(qCustomers.lastName.containsIgnoreCase(lastName));
	}
	if (city != null) {
	    where.and(Customers.city.containsIgnoreCase(city));
	}
	if (phone != null) {
	    where.and(qCustomers.phone.containsIgnoreCase(phone));
	}
	if (state != null) {
	    where.and(qCustomers.state.containsIgnoreCase(state));
	}
	if (customerName != null) {
	    where.and(qCustomers.customerName.containsIgnoreCase(customerName));
	}
	if (addressLine1 != null) {
	    where.and(qCustomers.addressLine1.containsIgnoreCase(addressLine1));
	}
	if (creditLimit != null) {
	    where.and(qCustomers.creditLimit.eq(creditLimit));
	}
	if (firstName != null) {
	    where.and(qCustomers.firstName.containsIgnoreCase(firstName));
	}
	if (addressLine2 != null) {
	    where.and(qCustomers.addressLine2.containsIgnoreCase(addressLine2));
	}
	if (country != null) {
	    where.and(qCustomers.country.containsIgnoreCase(country));
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
