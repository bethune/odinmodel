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
import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Customers;
import com.vladolium.odinmodel.model.Customers.*;
import com.vladolium.odinmodel.repository.*;
import com.vladolium.odinmodel.repository.CustomersRepository;
//import com.vladolium.odinmodel.wrapper.*;

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

	public Customers readOneById(Long id) {
		System.out.println("Testni ID u service je ======= " + id);
		System.out.println("Testni rezultat je ======= " + customersRepository.getOne(id).getCustomerName());
		return customersRepository.getOne(id);
	}

	public Customers readOneByCustomerName(String customerName) {
		return customersRepository.findByCustomerNameEquals(customerName);
	}

//Code between start and end will not be removed during generation.
//Start of user code for this service
//End of user code
}
