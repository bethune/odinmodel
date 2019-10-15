package com.vladolium.odinmodel.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.BooleanBuilder;
import com.vladolium.odinmodel.domain.Employees;
import com.vladolium.odinmodel.domain.Offices;
import com.vladolium.odinmodel.domain.QOffices;
import com.vladolium.odinmodel.repository.EmployeesRepository;
import com.vladolium.odinmodel.repository.OfficesRepository;
import com.vladolium.odinmodel.service.OfficesService;

@Service
@Transactional
public class OfficesServiceImpl implements OfficesService {

    private OfficesRepository officesRepository;

    @Autowired
    public void setOfficesRepository(OfficesRepository officesRepository) {
	this.officesRepository = officesRepository;
    }

    private EmployeesRepository employeesRepository;

    @Autowired
    public void setEmployeesRepository(EmployeesRepository employeesRepository) {
	this.employeesRepository = employeesRepository;
    }

    // covers create & update
    @Override
    public Offices createUpdate(Offices offices) {
	return officesRepository.save(offices);
    }

    @Override
    public Offices createIric(Offices offices, Employees employees) {
	officesRepository.save(offices);
	employees.setOffices(officesRepository.getOne(offices.getId()));
	employeesRepository.save(employees);
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
    public Iterable<Offices> search(String postalCode, String addressLine1, String country, String territory,
	    String phone, String city, String addressLine2, String state

    ) {
	BooleanBuilder where = dynamicWhere(postalCode, addressLine1, country, territory, phone, city, addressLine2,
		state

	);
	return officesRepository.findAll(where);
    }

    @Override
    public Page<Offices> searchPagination(Pageable page, String postalCode, String addressLine1, String country,
	    String territory, String phone, String city, String addressLine2, String state

    ) {
	BooleanBuilder where = dynamicWhere(postalCode, addressLine1, country, territory, phone, city, addressLine2,
		state

	);
	return officesRepository.findAll(where, page);
    }

    public BooleanBuilder dynamicWhere(String postalCode, String addressLine1, String country, String territory,
	    String phone, String city, String addressLine2, String state

    ) {
	QOffices qOffices = QOffices.offices;

	BooleanBuilder where = new BooleanBuilder();

	if (postalCode != null) {
	    where.and(qOffices.postalCode.containsIgnoreCase(postalCode));
	}
	if (addressLine1 != null) {
	    where.and(qOffices.addressLine1.containsIgnoreCase(addressLine1));
	}
	if (country != null) {
	    where.and(qOffices.country.containsIgnoreCase(country));
	}
	if (territory != null) {
	    where.and(qOffices.territory.containsIgnoreCase(territory));
	}
	if (phone != null) {
	    where.and(qOffices.phone.containsIgnoreCase(phone));
	}
	if (city != null) {
	    where.and(qOffices.city.containsIgnoreCase(city));
	}
	if (addressLine2 != null) {
	    where.and(qOffices.addressLine2.containsIgnoreCase(addressLine2));
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
