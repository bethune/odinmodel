package com.vladolium.odinmodel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.format.annotation.*;
import java.time.*;
import java.util.*;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Employees;
import com.vladolium.odinmodel.domain.Employees.*;
import com.vladolium.odinmodel.service.EmployeesService;
import com.vladolium.odinmodel.service.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/employees")
public class EmployeesController {

	private EmployeesService employeesService;

	@Autowired
	public void setEmployeesService(EmployeesService employeesService) {
		this.employeesService = employeesService;
	}

	
	
	
	
	
	
	
	
	@GetMapping("/{id}")
	public Employees readOneById(@PathVariable Long id) {
		return employeesService.readOneById(id);
	}
	
	
	
	
	
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code

}
