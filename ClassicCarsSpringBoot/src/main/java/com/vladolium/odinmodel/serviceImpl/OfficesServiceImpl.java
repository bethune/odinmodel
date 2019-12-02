package com.vladolium.odinmodel.serviceImpl;

import com.vladolium.odinmodel.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Transactional;
import java.time.*;
import java.util.*;
import com.vladolium.odinmodel.repository.*;
import com.vladolium.odinmodel.repository.OfficesRepository;
import com.vladolium.odinmodel.service.OfficesService;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Offices;
import com.vladolium.odinmodel.domain.Offices.*;
import com.vladolium.odinmodel.wrapper.*;
import com.querydsl.core.BooleanBuilder;

@Service
@Transactional
public class OfficesServiceImpl implements OfficesService {

	private OfficesRepository officesRepository;

	@Autowired
	public void setOfficesRepository(OfficesRepository officesRepository) {
		this.officesRepository = officesRepository;
	}

	// covers create, update and update with IRIC
	@Override
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
		String country,
		String postalCode,
		String phone,
		String territory,
		String addressLine2,
		String city,
		String addressLine1,
		String state
		
	) {
		BooleanBuilder where = dynamicWhere(
			country,
			postalCode,
			phone,
			territory,
			addressLine2,
			city,
			addressLine1,
			state
				
		);
		return officesRepository.findAll(where);
	}
	
	@Override
	public Page<Offices> searchPagination(
		Pageable page,
		String country,
		String postalCode,
		String phone,
		String territory,
		String addressLine2,
		String city,
		String addressLine1,
		String state
		
	) {
		BooleanBuilder where = dynamicWhere(
			country,
			postalCode,
			phone,
			territory,
			addressLine2,
			city,
			addressLine1,
			state
			
		);
		return officesRepository.findAll(where, page);
	}
	
	public BooleanBuilder dynamicWhere(
		String country,
		String postalCode,
		String phone,
		String territory,
		String addressLine2,
		String city,
		String addressLine1,
		String state
		
	) {
		QOffices qOffices = QOffices.offices;
	
		BooleanBuilder where = new BooleanBuilder();
	
		if (country != null) {
			where.and(qOffices.country.containsIgnoreCase(country));
		}
		if (postalCode != null) {
			where.and(qOffices.postalCode.containsIgnoreCase(postalCode));
		}
		if (phone != null) {
			where.and(qOffices.phone.containsIgnoreCase(phone));
		}
		if (territory != null) {
			where.and(qOffices.territory.containsIgnoreCase(territory));
		}
		if (addressLine2 != null) {
			where.and(qOffices.addressLine2.containsIgnoreCase(addressLine2));
		}
		if (city != null) {
			where.and(qOffices.city.containsIgnoreCase(city));
		}
		if (addressLine1 != null) {
			where.and(qOffices.addressLine1.containsIgnoreCase(addressLine1));
		}
		if (state != null) {
			where.and(qOffices.state.containsIgnoreCase(state));
		}
		
	
		return where;
	}
	
	
	
	
	
	
	@Override
	public void deleteOneById(Long id) {
	    officesRepository.deleteById(id);
	}
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code
}
