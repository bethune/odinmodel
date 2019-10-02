
package com.vladolium.odinmodel.serviceImpl;

import com.vladolium.odinmodel.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;

import java.time.*;
import java.util.*;

import com.vladolium.odinmodel.repository.EmployeesRepository;
import com.vladolium.odinmodel.service.EmployeesService;

@Service
public class EmployeesServiceImpl implements EmployeesService {

	private EmployeesRepository employeesRepository;

	@Autowired
	public void setEmployeesRepository(EmployeesRepository employeesRepository) {
		this.employeesRepository = employeesRepository;
	}

@Override
public Employees createUpdate(Employees employees) {
	return employeesRepository.save(employees);
}

//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code

}
