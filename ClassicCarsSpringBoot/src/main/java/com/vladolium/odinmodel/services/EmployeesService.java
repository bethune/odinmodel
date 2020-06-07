package com.vladolium.odinmodel.services;

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Employees.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.time.*;
import java.util.*;

import com.vladolium.odinmodel.repositories.*;
import com.vladolium.odinmodel.specifications.*;
import com.vladolium.odinmodel.interfaces.*;
import com.vladolium.odinmodel.wrappers.*;

import com.querydsl.core.BooleanBuilder;

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
		String lastName,
		Integer reportsTo,
		String extension,
		String email,
		String jobTitle,
		String firstName,
		Boolean isActive
	) {
		Specification<Employees> where = dynamicWhere(
			officesId,
			lastName,
			reportsTo,
			extension,
			email,
			jobTitle,
			firstName,
			isActive	
		);
		return employeesRepository.findAll(where);
	}
	
	@Override
	public Page<Employees> searchPagination(
		Pageable page,
		Long officesId,
		String lastName,
		Integer reportsTo,
		String extension,
		String email,
		String jobTitle,
		String firstName,
		Boolean isActive
	) {
		Specification<Employees> where = dynamicWhere(
			officesId,
			lastName,
			reportsTo,
			extension,
			email,
			jobTitle,
			firstName,
			isActive
		);
		return employeesRepository.findAll(where, page);
	}
	
	public Specification<Employees> dynamicWhere(
		Long officesId,
		String lastName,
		Integer reportsTo,
		String extension,
		String email,
		String jobTitle,
		String firstName,
		Boolean isActive
	) {
		Specification<Employees> where = Specification
			.where(lastName == null ? null : EmployeesSpecification.getEmployeesByLastName(lastName))
			.and(reportsTo == null ? null : EmployeesSpecification.getEmployeesByReportsTo(reportsTo))
			.and(extension == null ? null : EmployeesSpecification.getEmployeesByExtension(extension))
			.and(email == null ? null : EmployeesSpecification.getEmployeesByEmail(email))
			.and(jobTitle == null ? null : EmployeesSpecification.getEmployeesByJobTitle(jobTitle))
			.and(firstName == null ? null : EmployeesSpecification.getEmployeesByFirstName(firstName))
			.and(isActive == null ? null : EmployeesSpecification.getEmployeesByIsActive(isActive))
			.and(officesId == null ? null : EmployeesSpecification.getEmployeesByOfficesId(officesId));
	
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
