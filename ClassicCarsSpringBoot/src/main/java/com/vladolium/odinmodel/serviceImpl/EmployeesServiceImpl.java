package com.vladolium.odinmodel.serviceImpl;

import com.vladolium.odinmodel.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;
import java.time.*;
import java.util.*;
import com.vladolium.odinmodel.repository.EmployeesRepository;
import com.vladolium.odinmodel.service.EmployeesService;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Employees;
import com.vladolium.odinmodel.domain.Employees.*;
import com.querydsl.core.BooleanBuilder;

@Service
public class EmployeesServiceImpl implements EmployeesService {

	private EmployeesRepository employeesRepository;

	@Autowired
	public void setEmployeesRepository(EmployeesRepository employeesRepository) {
		this.employeesRepository = employeesRepository;
	}

	// covers create & update
	@Override
	public Employees createUpdate(Employees employees) {
		return employeesRepository.save(employees);
	}
	
	
	
	
	
	
	
	
	@Override
	public Employees readOneById(Long id) {
		return employeesRepository.getOne(id);
	}
	
	
	
	
	
	
	
	
	
	@Override
	public Iterable<Employees> readAll() {
		return employeesRepository.findAll();
	}
	
	@Override
	public Page<Employees> readAllPagination(Pageable page) {
		return employeesRepository.findAll(page);
	}
	
	
	
	
	
	
	@Override
	public Iterable<Employees> readAllByOfficesId(Long officesId) {
		return employeesRepository.findByOfficesIdEquals(officesId);
	}
	
	@Override
	public Page<Employees> readAllByOfficesId(Long officesId, Pageable page) {
		return employeesRepository.findByOfficesIdEquals(officesId, page);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public Iterable<Employees> search(
		
		
		
		
		
		Long officesId,
		
		
		
		Boolean isActive,
		String extension,
		String jobTitle,
		Integer reportsTo,
		String lastName,
		String firstName,
		String email
		
	) {
		BooleanBuilder where = dynamicWhere(
			
			
			
			
			
			officesId,
			
			
			
			isActive,
			extension,
			jobTitle,
			reportsTo,
			lastName,
			firstName,
			email
				
		);
		return employeesRepository.findAll(where);
	}
	
	@Override
	public Page<Employees> searchPagination(
		Pageable page,
		
		
		
		
		
		Long officesId,
		
		
		
		Boolean isActive,
		String extension,
		String jobTitle,
		Integer reportsTo,
		String lastName,
		String firstName,
		String email
		
	) {
		BooleanBuilder where = dynamicWhere(
			
			
			
			
			
			officesId,
			
			
			
			isActive,
			extension,
			jobTitle,
			reportsTo,
			lastName,
			firstName,
			email
			
		);
		return employeesRepository.findAll(where, page);
	}
	
	public BooleanBuilder dynamicWhere(
		
		
		
		
		
		Long officesId,
		
		
		
		Boolean isActive,
		String extension,
		String jobTitle,
		Integer reportsTo,
		String lastName,
		String firstName,
		String email
		
	) {
		QEmployees qEmployees = QEmployees.employees;
	
		BooleanBuilder where = new BooleanBuilder();
	
		
		
		
		
		
		if (officesId != null) {
			where.and(qEmployees.offices.id.eq(officesId));
		}
		
		
		
		if (isActive != null) {
			where.and(qEmployees.isActive.eq(isActive));
		}
		if (extension != null) {
			where.and(qEmployees.extension.containsIgnoreCase(extension));
		}
		if (jobTitle != null) {
			where.and(qEmployees.jobTitle.containsIgnoreCase(jobTitle));
		}
		if (reportsTo != null) {
			where.and(qEmployees.reportsTo.eq(reportsTo));
		}
		if (lastName != null) {
			where.and(qEmployees.lastName.containsIgnoreCase(lastName));
		}
		if (firstName != null) {
			where.and(qEmployees.firstName.containsIgnoreCase(firstName));
		}
		if (email != null) {
			where.and(qEmployees.email.containsIgnoreCase(email));
		}
		
	
		return where;
	}
	
	
	
	
	
	
	
	
	
	@Override
	public void deleteOneById(Long id) {
		employeesRepository.deleteById(id);
	}
	

//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code
}
