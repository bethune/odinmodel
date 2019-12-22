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
import com.vladolium.odinmodel.model.Employees;
import com.vladolium.odinmodel.model.Employees.*;
import com.vladolium.odinmodel.repository.*;
import com.vladolium.odinmodel.repository.EmployeesRepository;
//import com.vladolium.odinmodel.wrapper.*;

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

	
	
	public Employees readOneById(Long id) {
		return employeesRepository.getOne(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this service
//End of user code
}
