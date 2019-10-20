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
import com.vladolium.odinmodel.wrapperRequest.*;
import com.querydsl.core.BooleanBuilder;

@Service
@Transactional
public class OfficesServiceImpl implements OfficesService {

	private OfficesRepository officesRepository;

	@Autowired
	public void setOfficesRepository(OfficesRepository officesRepository) {
		this.officesRepository = officesRepository;
	}

	// covers create & update
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
		String postalCode,
		String state,
		String territory,
		String city,
		String addressLine1,
		String addressLine2,
		String country,
		String phone
		
	) {
		BooleanBuilder where = dynamicWhere(
			postalCode,
			state,
			territory,
			city,
			addressLine1,
			addressLine2,
			country,
			phone
				
		);
		return officesRepository.findAll(where);
	}
	
	@Override
	public Page<Offices> searchPagination(
		Pageable page,
		String postalCode,
		String state,
		String territory,
		String city,
		String addressLine1,
		String addressLine2,
		String country,
		String phone
		
	) {
		BooleanBuilder where = dynamicWhere(
			postalCode,
			state,
			territory,
			city,
			addressLine1,
			addressLine2,
			country,
			phone
			
		);
		return officesRepository.findAll(where, page);
	}
	
	public BooleanBuilder dynamicWhere(
		String postalCode,
		String state,
		String territory,
		String city,
		String addressLine1,
		String addressLine2,
		String country,
		String phone
		
	) {
		QOffices qOffices = QOffices.offices;
	
		BooleanBuilder where = new BooleanBuilder();
	
		if (postalCode != null) {
			where.and(qOffices.postalCode.containsIgnoreCase(postalCode));
		}
		if (state != null) {
			where.and(qOffices.state.containsIgnoreCase(state));
		}
		if (territory != null) {
			where.and(qOffices.territory.containsIgnoreCase(territory));
		}
		if (city != null) {
			where.and(qOffices.city.containsIgnoreCase(city));
		}
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
