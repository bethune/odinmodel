package com.vladolium.odinmodel.services; 

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Offices;
import com.vladolium.odinmodel.model.Offices.*;
import com.vladolium.odinmodel.repositories.*;
import com.vladolium.odinmodel.repositories.OfficesRepository;
import com.vladolium.odinmodel.interfaces.OfficesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Transactional;
import java.time.*;
import java.util.*;
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

	// covers create, update and update with IRIC
	@Override
	public Offices saveOne(Offices offices) {
		return officesRepository.save(offices);
	}
	
	private EmployeesRepository employeesRepository;
	
	// covers create with IRIC
	public Offices saveOneWithIric(OfficesEmployees officesEmployees) {
	
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
