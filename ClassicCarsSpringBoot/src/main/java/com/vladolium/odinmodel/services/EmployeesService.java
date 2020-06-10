package com.vladolium.odinmodel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.BooleanBuilder;
//import com.vladolium.odinmodel.specifications.*;
import com.vladolium.odinmodel.interfaces.EmployeesInterface;
import com.vladolium.odinmodel.model.Employees;
import com.vladolium.odinmodel.model.QEmployees;
import com.vladolium.odinmodel.repositories.EmployeesRepository;

@Service
@Transactional
public class EmployeesService implements EmployeesInterface {

	private EmployeesRepository employeesRepository;

	@Autowired
	public void setEmployeesRepository(EmployeesRepository employeesRepository) {
		this.employeesRepository = employeesRepository;
	}

	@Override
	public Employees saveOne(Employees employees) {
		return employeesRepository.save(employees);
	}

	@Override
	public void deleteOneById(Long id) {
	    employeesRepository.deleteById(id);
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
	public Iterable<Employees> search(
		Long officesId,
		Boolean isActive,
		Integer reportsTo,
		String lastName,
		String extension,
		String email,
		String jobTitle,
		String firstName
	) {
		BooleanBuilder where = dynamicWhere(
			officesId,
			isActive,
			reportsTo,
			lastName,
			extension,
			email,
			jobTitle,
			firstName	
		);
		return employeesRepository.findAll(where);
	}
	
	@Override
	public Page<Employees> searchPagination(
		Pageable page,
		Long officesId,
		Boolean isActive,
		Integer reportsTo,
		String lastName,
		String extension,
		String email,
		String jobTitle,
		String firstName
	) {
		BooleanBuilder where = dynamicWhere(
			officesId,
			isActive,
			reportsTo,
			lastName,
			extension,
			email,
			jobTitle,
			firstName
		);
		return employeesRepository.findAll(where, page);
	}
	
	public BooleanBuilder dynamicWhere(
		Long officesId,
		Boolean isActive,
		Integer reportsTo,
		String lastName,
		String extension,
		String email,
		String jobTitle,
		String firstName
	) {
		QEmployees qEmployees = QEmployees.employees;
	
		BooleanBuilder where = new BooleanBuilder();
	
		if (officesId != null) {
			where.and(qEmployees.offices.id.eq(officesId));
		}
		if (isActive != null) {
			where.and(qEmployees.isActive.eq(isActive));
		}
		if (reportsTo != null) {
			where.and(qEmployees.reportsTo.eq(reportsTo));
		}
		if (lastName != null) {
			where.and(qEmployees.lastName.containsIgnoreCase(lastName));
		}
		if (extension != null) {
			where.and(qEmployees.extension.containsIgnoreCase(extension));
		}
		if (email != null) {
			where.and(qEmployees.email.containsIgnoreCase(email));
		}
		if (jobTitle != null) {
			where.and(qEmployees.jobTitle.containsIgnoreCase(jobTitle));
		}
		if (firstName != null) {
			where.and(qEmployees.firstName.containsIgnoreCase(firstName));
		}
	
		return where;
	}


	@Override
	public Iterable<Employees> readAllByOfficesId(Long officesId) {
		return employeesRepository.findByOfficesIdEquals(officesId);
	}
	
	@Override
	public Page<Employees> readAllByOfficesId(Long officesId, Pageable page) {
		return employeesRepository.findByOfficesIdEquals(officesId, page);
	}

	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code
}
