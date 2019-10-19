package com.vladolium.odinmodel.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.BooleanBuilder;
import com.vladolium.odinmodel.domain.Employees;
import com.vladolium.odinmodel.domain.QEmployees;
import com.vladolium.odinmodel.repository.EmployeesRepository;
import com.vladolium.odinmodel.service.EmployeesService;

@Service
@Transactional
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
    public Iterable<Employees> search(Long officesId,

	    Integer reportsTo, Boolean isActive, String extension, String firstName, String lastName, String jobTitle,
	    String email

    ) {
	BooleanBuilder where = dynamicWhere(officesId,

		reportsTo, isActive, extension, firstName, lastName, jobTitle, email

	);
	return employeesRepository.findAll(where);
    }

    @Override
    public Page<Employees> searchPagination(Pageable page, Long officesId,

	    Integer reportsTo, Boolean isActive, String extension, String firstName, String lastName, String jobTitle,
	    String email

    ) {
	BooleanBuilder where = dynamicWhere(officesId,

		reportsTo, isActive, extension, firstName, lastName, jobTitle, email

	);
	return employeesRepository.findAll(where, page);
    }

    public BooleanBuilder dynamicWhere(Long officesId,

	    Integer reportsTo, Boolean isActive, String extension, String firstName, String lastName, String jobTitle,
	    String email

    ) {
	QEmployees qEmployees = QEmployees.employees;

	BooleanBuilder where = new BooleanBuilder();

	if (officesId != null) {
	    where.and(qEmployees.offices.id.eq(officesId));
	}

	if (reportsTo != null) {
	    where.and(qEmployees.reportsTo.eq(reportsTo));
	}
	if (isActive != null) {
	    where.and(qEmployees.isActive.eq(isActive));
	}
	if (extension != null) {
	    where.and(qEmployees.extension.containsIgnoreCase(extension));
	}
	if (firstName != null) {
	    where.and(qEmployees.firstName.containsIgnoreCase(firstName));
	}
	if (lastName != null) {
	    where.and(qEmployees.lastName.containsIgnoreCase(lastName));
	}
	if (jobTitle != null) {
	    where.and(qEmployees.jobTitle.containsIgnoreCase(jobTitle));
	}
	if (email != null) {
	    where.and(qEmployees.email.containsIgnoreCase(email));
	}

	return where;
    }

    @Override
    public void deleteOneById(Long id) {
	Employees currentEmployees = employeesRepository.getOne(id);
	Iterable<Employees> listOfEmployees = employeesRepository
		.findByOfficesIdEquals(currentEmployees.getOffices().getId());
	Long size = listOfEmployees.spliterator().getExactSizeIfKnown();
	if (size == 1) {
	    return;
	} else {
	    employeesRepository.deleteById(id);
	}
    }

//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code
}
