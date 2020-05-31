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
import com.vladolium.odinmodel.specifications.OfficesSpecification;
import com.vladolium.odinmodel.interfaces.*;
import com.vladolium.odinmodel.wrappers.*;

import com.querydsl.core.BooleanBuilder;

@Service
@Transactional
public class OfficesService implements OfficesInterface {

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
	public Iterable<Offices> search(String city, String phone, String addressLine2, String territory,
			String addressLine1, String country, String state, String postalCode) {
		Specification<Offices> where = dynamicWhere(city, phone, addressLine2, territory, addressLine1, country, state,
				postalCode);
		return officesRepository.findAll(where);
	}

	@Override
	public Page<Offices> searchPagination(Pageable page, String city, String phone, String addressLine2,
			String territory, String addressLine1, String country, String state, String postalCode) {
		Specification<Offices> where = dynamicWhere(city, phone, addressLine2, territory, addressLine1, country, state,
				postalCode);
		return officesRepository.findAll(where, page);
	}

	Specification<Offices> dynamicWhere(String city, String phone, String addressLine2, String territory,
			String addressLine1, String country, String state, String postalCode) {
		Specification<Offices> where = Specification
				.where(city == null ? null : OfficesSpecification.getOfficesByCity(city))
				.or(phone == null ? null : OfficesSpecification.getOfficesByPhone(phone))
				.or(addressLine1 == null ? null : OfficesSpecification.getOfficesByAddressLine1(addressLine1))
				.or(addressLine1 == null ? null : OfficesSpecification.getOfficesByAddressLine1(addressLine1))
				.or(territory == null ? null : OfficesSpecification.getOfficesByTerritory(territory))
				.or(country == null ? null : OfficesSpecification.getOfficesByCountry(country))
				.or(state == null ? null : OfficesSpecification.getOfficesByState(state))
				.or(postalCode == null ? null : OfficesSpecification.getOfficesByPostalCode(postalCode));
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
}
