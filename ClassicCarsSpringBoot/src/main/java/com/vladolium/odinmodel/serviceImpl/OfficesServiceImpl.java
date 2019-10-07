
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
	String postalCode,
	String city,
	String phone,
	String territory,
	String state,
	String addressLine1,
	String addressLine2,
	String country
	) {
		BooleanBuilder where = dynamicWhere(
	postalCode,
	city,
	phone,
	territory,
	state,
	addressLine1,
	addressLine2,
	country
	);

	return officesRepository.findAll(where);
}





public Condition dynamicCondition(
		String postalCode,
		String city,
		String phone,
		String territory,
		String state,
		String addressLine1,
		String addressLine2,
		String country
	) {
		QOffices qOffices = QOffices.offices;

		BooleanBuilder where = new BooleanBuilder();

		if (postalCode != null) {
			where.and(qOffices.postalCode.containsIgnoreCase(postalCode));
		}
		if (city != null) {
			where.and(qOffices.city.containsIgnoreCase(city));
		}
		if (phone != null) {
			where.and(qOffices.phone.containsIgnoreCase(phone));
		}
		if (territory != null) {
			where.and(qOffices.territory.containsIgnoreCase(territory));
		}
		if (state != null) {
			where.and(qOffices.state.containsIgnoreCase(state));
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
