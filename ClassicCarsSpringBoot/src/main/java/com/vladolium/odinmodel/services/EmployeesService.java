package com.vladolium.odinmodel.services; 

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Employees;
import com.vladolium.odinmodel.model.Employees.*;
import com.vladolium.odinmodel.repositories.*;
import com.vladolium.odinmodel.repositories.EmployeesRepository;
import com.vladolium.odinmodel.interfaces.EmployeesInterface;
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
public class EmployeesService implements EmployeesInterface {

	private EmployeesRepository employeesRepository;

	@Autowired
	public void setEmployeesRepository(EmployeesRepository employeesRepository) {
		this.employeesRepository = employeesRepository;
	}

	// covers create, update and update with IRIC
	@Override
	public Employees saveOne(Employees employees) {
		return employeesRepository.save(employees);
	}
	
	


//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code
}
