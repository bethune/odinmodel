package com.vladolium.odinmodel.services;

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Offices.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.time.*;
import java.util.*;

import com.vladolium.odinmodel.repositories.*;
//import com.vladolium.odinmodel.specifications.*;
import com.vladolium.odinmodel.interfaces.*;
import com.vladolium.odinmodel.wrappers.*;

import com.querydsl.core.BooleanBuilder;
/*
@Service
@Transactional
public class OfficesServiceQuerydsl implements OfficesInterface {

	private OfficesRepository officesRepository;

	@Autowired
	public void setOfficesRepository(OfficesRepository officesRepository) {
		this.officesRepository = officesRepository;
	}

	@Override
	public Offices saveOne(Offices offices) {
		return officesRepository.save(offices);
	}

	@Override
	public void deleteOneById(Long id) {
	    officesRepository.deleteById(id);
	}
	
	@Override
	public Offices readOneById(Long id) {
		return officesRepository.getOne(id);
	}

	@Override
	public Iterable<Offices> readAll() {
		return officesRepository.findAll();
	}
	
	@Override
	public Page<Offices> readAllPagination(Pageable page) {
		return officesRepository.findAll(page);
	}

	@Override
	public Iterable<Offices> search(
		String addressLine1,
		String addressLine2,
		String country,
		String phone,
		String state,
		String territory,
		String postalCode,
		String city
	) {
		BooleanBuilder where = dynamicWhere(
			addressLine1,
			addressLine2,
			country,
			phone,
			state,
			territory,
			postalCode,
			city	
		);
		return officesRepository.findAll(where);
	}
	
	@Override
	public Page<Offices> searchPagination(
		Pageable page,
		String addressLine1,
		String addressLine2,
		String country,
		String phone,
		String state,
		String territory,
		String postalCode,
		String city
	) {
		BooleanBuilder where = dynamicWhere(
			addressLine1,
			addressLine2,
			country,
			phone,
			state,
			territory,
			postalCode,
			city
		);
		return officesRepository.findAll(where, page);
	}
	
	public BooleanBuilder dynamicWhere(
		String addressLine1,
		String addressLine2,
		String country,
		String phone,
		String state,
		String territory,
		String postalCode,
		String city
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
		if (state != null) {
			where.and(qOffices.state.containsIgnoreCase(state));
		}
		if (territory != null) {
			where.and(qOffices.territory.containsIgnoreCase(territory));
		}
		if (postalCode != null) {
			where.and(qOffices.postalCode.containsIgnoreCase(postalCode));
		}
		if (city != null) {
			where.and(qOffices.city.containsIgnoreCase(city));
		}
	
		return where;
	}


	

	
	
	private EmployeesRepository employeesRepository;
	
	public Offices saveOneWhenIricOnManyToOneRelationship(OfficesEmployees officesEmployees) {
		
		Offices currentOffices = officesRepository.save(officesEmployees.getOffices());
		
		Employees currentEmployees = officesEmployees.getEmployees();
		
		currentEmployees.setOffices(officesRepository.getOne(currentOffices.getId()));
		
		employeesRepository.save(currentEmployees);
		
		return currentOffices;
	}

//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code
}*/
