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
import com.vladolium.odinmodel.model.Employees;
import com.vladolium.odinmodel.model.Employees.*;
import com.vladolium.odinmodel.repository.*;
import com.vladolium.odinmodel.repository.EmployeesRepository;
import com.vladolium.odinmodel.wrapper.*;

@Stateless
public class EmployeesService {

 	@PersistenceContext
    private EntityManager em;

	private EmployeesRepository employeesRepository;
	
	@PostConstruct
	private void init() {
		RepositoryFactorySupport factory = new JpaRepositoryFactory(em);
		this.employeesRepository = factory.getRepository(EmployeesRepository.class);
	}

	// covers create, update and update with IRIC
	public Employees createUpdate(Employees employees) {
		return employeesRepository.save(employees);
	}
	
	
	
	
	public Employees readOneById(Long id) {
		return employeesRepository.getOne(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Iterable<Employees> readAll() {
		return employeesRepository.findAll();
	}
	
	public Page<Employees> readAllPagination(Pageable page) {
		return employeesRepository.findAll(page);
	}
	
	
	
	
	
	public Iterable<Employees> readAllByOfficesId(Long officesId) {
		return employeesRepository.findByOfficesIdEquals(officesId);
	}
	
	public Page<Employees> readAllByOfficesId(Long officesId, Pageable page) {
		return employeesRepository.findByOfficesIdEquals(officesId, page);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Iterable<Employees> search(
		
		
		
		
		Long officesId,
		
		
		
		
		String extension,
		String firstName,
		Integer reportsTo,
		String jobTitle,
		Boolean isActive,
		String lastName,
		String email
		
	) {
		BooleanBuilder where = dynamicWhere(
			
			
			
			
			officesId,
			
			
			
			
			extension,
			firstName,
			reportsTo,
			jobTitle,
			isActive,
			lastName,
			email
				
		);
		return employeesRepository.findAll(where);
	}
	
	public Page<Employees> searchPagination(
		Pageable page,
		
		
		
		
		Long officesId,
		
		
		
		
		String extension,
		String firstName,
		Integer reportsTo,
		String jobTitle,
		Boolean isActive,
		String lastName,
		String email
		
	) {
		BooleanBuilder where = dynamicWhere(
			
			
			
			
			officesId,
			
			
			
			
			extension,
			firstName,
			reportsTo,
			jobTitle,
			isActive,
			lastName,
			email
			
		);
		return employeesRepository.findAll(where, page);
	}
	
	public BooleanBuilder dynamicWhere(
		
		
		
		
		Long officesId,
		
		
		
		
		String extension,
		String firstName,
		Integer reportsTo,
		String jobTitle,
		Boolean isActive,
		String lastName,
		String email
		
	) {
		QEmployees qEmployees = QEmployees.employees;
	
		BooleanBuilder where = new BooleanBuilder();
	
		
		
		
		
		if (officesId != null) {
			where.and(qEmployees.offices.id.eq(officesId));
		}
		
		
		
		
		if (extension != null) {
			where.and(qEmployees.extension.containsIgnoreCase(extension));
		}
		if (firstName != null) {
			where.and(qEmployees.firstName.containsIgnoreCase(firstName));
		}
		if (reportsTo != null) {
			where.and(qEmployees.reportsTo.eq(reportsTo));
		}
		if (jobTitle != null) {
			where.and(qEmployees.jobTitle.containsIgnoreCase(jobTitle));
		}
		if (isActive != null) {
			where.and(qEmployees.isActive.eq(isActive));
		}
		if (lastName != null) {
			where.and(qEmployees.lastName.containsIgnoreCase(lastName));
		}
		if (email != null) {
			where.and(qEmployees.email.containsIgnoreCase(email));
		}
		
	
		return where;
	}
	
	
	
	public void deleteOneById(Long id) {
	    employeesRepository.deleteById(id);
	}
	
	
	
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this service
//End of user code
}
