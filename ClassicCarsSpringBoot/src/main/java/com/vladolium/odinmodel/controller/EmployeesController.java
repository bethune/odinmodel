
package com.vladolium.odinmodel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.format.annotation.*;

import java.time.*;
import java.util.*;

import com.vladolium.odinmodel.domain.*;
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

@PostMapping("")
public Employees createOne(@RequestBody Employees employees) {
	return employeesService.createUpdate(employees);
}








@PutMapping("/{id}")
public Employees updateOneById(@PathVariable Long id, @RequestBody Employees employees) {
	Employees current = employeesService.readOneById(id);
	current.setOffices(employees.getOffices());
	current.setFirstName(employees.getFirstName());

	current.setEmail(employees.getEmail());

	current.setReportsTo(employees.getReportsTo());

	current.setExtension(employees.getExtension());

	current.setLastName(employees.getLastName());


	current.setIsActive(employees.getIsActive());

	current.setJobTitle(employees.getJobTitle());
	return employeesService.createUpdate(current);
}





















@GetMapping("/{id}")
public Employees findOneById(@PathVariable Long id) {
	return employeesService.readOneById(id);
}

























@DeleteMapping("/{id}")
public void deleteOneById(@PathVariable Long id) {
	employeesService.deleteOneById(id);
}



	

//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code

}
