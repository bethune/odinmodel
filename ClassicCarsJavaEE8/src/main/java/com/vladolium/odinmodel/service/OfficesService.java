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
import com.vladolium.odinmodel.model.Offices;
import com.vladolium.odinmodel.model.Offices.*;
import com.vladolium.odinmodel.repository.*;
import com.vladolium.odinmodel.repository.OfficesRepository;
import com.vladolium.odinmodel.wrapper.*;

@Stateless
public class OfficesService {

 	@PersistenceContext
    private EntityManager em;

	private OfficesRepository officesRepository;
	
	@PostConstruct
	private void init() {
		RepositoryFactorySupport factory = new JpaRepositoryFactory(em);
		this.officesRepository = factory.getRepository(OfficesRepository.class);
	}

	// covers create, update and update with IRIC
	public Offices createUpdate(Offices offices) {
		return officesRepository.save(offices);
	}
	
	private EmployeesRepository employeesRepository;
	
	public Offices createOneIric(OfficesEmployees officesEmployees) {
		Offices currentOffices = officesRepository.save(officesEmployees.getOffices());
		Employees currentEmployees = officesEmployees.getEmployees();
		currentEmployees.setOffices(officesRepository.getOne(currentOffices.getId()));
		employeesRepository.save(currentEmployees);
		return currentOffices;
	}
	
	
	
	
	
	public Offices readOneById(Long id) {
		return officesRepository.getOne(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Iterable<Offices> readAll() {
		return officesRepository.findAll();
	}
	
	public Page<Offices> readAllPagination(Pageable page) {
		return officesRepository.findAll(page);
	}
	
	
	
	public Iterable<Offices> search(
		String addressLine1,
		String addressLine2,
		String country,
		String phone,
		String city,
		String postalCode,
		String territory,
		String state
		
	) {
		BooleanBuilder where = dynamicWhere(
			addressLine1,
			addressLine2,
			country,
			phone,
			city,
			postalCode,
			territory,
			state
				
		);
		return officesRepository.findAll(where);
	}
	
	public Page<Offices> searchPagination(
		Pageable page,
		String addressLine1,
		String addressLine2,
		String country,
		String phone,
		String city,
		String postalCode,
		String territory,
		String state
		
	) {
		BooleanBuilder where = dynamicWhere(
			addressLine1,
			addressLine2,
			country,
			phone,
			city,
			postalCode,
			territory,
			state
			
		);
		return officesRepository.findAll(where, page);
	}
	
	public BooleanBuilder dynamicWhere(
		String addressLine1,
		String addressLine2,
		String country,
		String phone,
		String city,
		String postalCode,
		String territory,
		String state
		
	) {
		QOffices qOffices = QOffices.offices;
	
		BooleanBuilder where = new BooleanBuilder();
	
		if (addressLine1 != null) {
			where.and(qOffices.addressLine1.containsIgnoreCase(addressLine1));
		}
		if (addressLine2 != null) {
			where.and(qOffices.addressLine2.containsIgnoreCase(addressLine2));
		}
		if (country != null) {
			where.and(qOffices.country.containsIgnoreCase(country));
		}
		if (phone != null) {
			where.and(qOffices.phone.containsIgnoreCase(phone));
		}
		if (city != null) {
			where.and(qOffices.city.containsIgnoreCase(city));
		}
		if (postalCode != null) {
			where.and(qOffices.postalCode.containsIgnoreCase(postalCode));
		}
		if (territory != null) {
			where.and(qOffices.territory.containsIgnoreCase(territory));
		}
		if (state != null) {
			where.and(qOffices.state.containsIgnoreCase(state));
		}
		
	
		return where;
	}
	
	
	
	
	
	public void deleteOneById(Long id) {
	    officesRepository.deleteById(id);
	}
	
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this service
//End of user code
}
