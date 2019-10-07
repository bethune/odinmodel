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
import static org.jooq.impl.DSL.*;

@Service
public class EmployeesServiceImpl implements EmployeesService {

	private final DSLContext jooq;

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
	public Iterable<Employees> search(
		Long officesId,
		
		
		
		
		
		
		
		
		
		String firstName,
		String email,
		Integer reportsTo,
		String extension,
		String lastName,
		Boolean isActive,
		String jobTitle
		
	) {
		Condition condition = dynamicCondition(
			Long officesId,
			
			
			
			
			
			
			
			
			
			firstName,
			email,
			reportsTo,
			extension,
			lastName,
			isActive,
			jobTitle
		);
		return employeesRepository.findAll(condition);
	}
	public Condition dynamicCondition(
		Long officesId,
		
		
		
		
		
		
		
		
		
		String firstName,
		String email,
		Integer reportsTo,
		String extension,
		String lastName,
		Boolean isActive,
		String jobTitle
		
	) {
		Condition condition = trueCondition();
	
		if (officesId != null) {
			condition.and(employees.offices.id.eq(officesId));
		}
	
	
	
	
	
	
	
	
			if (firstName != null) {
				where.and(qEmployees.firstName.containsIgnoreCase(firstName));
			}
			if (email != null) {
				where.and(qEmployees.email.containsIgnoreCase(email));
			}
			if (reportsTo != null) {
				where.and(qEmployees.reportsTo.eq(reportsTo));
			}
			if (extension != null) {
				where.and(qEmployees.extension.containsIgnoreCase(extension));
			}
			if (lastName != null) {
				where.and(qEmployees.lastName.containsIgnoreCase(lastName));
			}
			if (isActive != null) {
				where.and(qEmployees.isActive.eq(isActive));
			}
			if (jobTitle != null) {
				where.and(qEmployees.jobTitle.containsIgnoreCase(jobTitle));
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
