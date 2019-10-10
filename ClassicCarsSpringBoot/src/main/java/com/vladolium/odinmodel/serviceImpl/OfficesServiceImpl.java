package com.vladolium.odinmodel.serviceImpl;

import com.vladolium.odinmodel.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;
import java.time.*;
import java.util.*;
import com.vladolium.odinmodel.repository.OfficesRepository;
import com.vladolium.odinmodel.service.OfficesService;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Offices;
import com.vladolium.odinmodel.domain.Offices.*;
import com.querydsl.core.BooleanBuilder;

@Service
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
		String city,
		String phone,
		String addressLine1,
		String territory,
		String country,
		String addressLine2,
		String state,
		String postalCode
		
	) {
		BooleanBuilder where = dynamicWhere(
			city,
			phone,
			addressLine1,
			territory,
			country,
			addressLine2,
			state,
			postalCode
				
		);
		return officesRepository.findAll(where);
	}
	
	public BooleanBuilder dynamicWhere(
		String city,
		String phone,
		String addressLine1,
		String territory,
		String country,
		String addressLine2,
		String state,
		String postalCode
		
	) {
		QOffices qOffices = QOffices.offices;
	
		BooleanBuilder where = new BooleanBuilder();
	
		if (city != null) {
			where.and(qOffices.city.containsIgnoreCase(city));
		}
		if (phone != null) {
			where.and(qOffices.phone.containsIgnoreCase(phone));
		}
		if (addressLine1 != null) {
			where.and(qOffices.addressLine1.containsIgnoreCase(addressLine1));
		}
		if (territory != null) {
			where.and(qOffices.territory.containsIgnoreCase(territory));
		}
		if (country != null) {
			where.and(qOffices.country.containsIgnoreCase(country));
		}
		if (addressLine2 != null) {
			where.and(qOffices.addressLine2.containsIgnoreCase(addressLine2));
		}
		if (state != null) {
			where.and(qOffices.state.containsIgnoreCase(state));
		}
		if (postalCode != null) {
			where.and(qOffices.postalCode.containsIgnoreCase(postalCode));
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
