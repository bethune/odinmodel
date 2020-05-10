package com.vladolium.odinmodel.controllers;

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Employees.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.format.annotation.*;

import java.time.*;
import java.util.*;

import com.vladolium.odinmodel.interfaces.*;
import com.vladolium.odinmodel.wrappers.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/employees")
public class EmployeesController {

	private EmployeesInterface employeesInterface;

	@Autowired
	public void setEmployeesInterface(EmployeesInterface employeesInterface) {
		this.employeesInterface = employeesInterface;
	}

	@PostMapping("")
	public Employees saveOne(@RequestBody Employees employees) {
		return employeesInterface.saveOne(employees);
	}

	@DeleteMapping("/{id}")
	public void deleteOneById(@PathVariable Long id) {
		employeesInterface.deleteOneById(id);
	}
	
	@GetMapping("/{id}")
	public Employees readOneById(@PathVariable Long id) {
		return employeesInterface.readOneById(id);
	}
	
	@PutMapping("/{id}")
	public Employees updateOneById(@PathVariable Long id, @RequestBody Employees employees) {
		
		Employees current = employeesInterface.readOneById(id);
			
		current.setOffices(employees.getOffices());
		current.setLastName(employees.getLastName());
		current.setReportsTo(employees.getReportsTo());
		current.setExtension(employees.getExtension());
		current.setEmail(employees.getEmail());
		current.setJobTitle(employees.getJobTitle());
		current.setFirstName(employees.getFirstName());
		current.setIsActive(employees.getIsActive());
				
		return employeesInterface.saveOne(current);
	}

	@GetMapping("")
	public Iterable<Employees> readAll() {
		return employeesInterface.readAll();
	}
	
	@GetMapping("/page={pageNumber}/perPage={perPageNumber}")
	public Page<Employees> readAllPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return employeesInterface.readAllPagination(page);
	}


	

	@DeleteMapping("/{id}/offices")
	public void deleteOneByIdWhenIricOnManyToOneRelationship(@PathVariable Long id) {
		
		Employees current = employeesInterface.readOneById(id);
	
		Iterable<Employees> listOfEmployees = employeesInterface
			.readAllByOfficesId(current.getOffices().getId());
	
		Long size = listOfEmployees.spliterator().getExactSizeIfKnown();
	
		if (size == 1) {
		    return;
		} else {
		    employeesInterface.deleteOneById(id);
		}
	}
	
	@PutMapping("/{id}/offices")
	public Employees updateOneByIdWhenIricOnManyToOneRelationship(@PathVariable Long id, @RequestBody Employees employees) {
	
		Employees current = employeesInterface.readOneById(id);
	
		if (current.getOffices().getId() == employees.getOffices().getId()) {
	
			current.setOffices(employees.getOffices());
			current.setLastName(employees.getLastName());
			current.setReportsTo(employees.getReportsTo());
			current.setExtension(employees.getExtension());
			current.setEmail(employees.getEmail());
			current.setJobTitle(employees.getJobTitle());
			current.setFirstName(employees.getFirstName());
			current.setIsActive(employees.getIsActive());			
	
			return employeesInterface.saveOne(current);
	
		} else {
	
		    Iterable<Employees> listOfEmployees = employeesInterface.readAllByOfficesId(current.getOffices().getId());
	
		    Long size = listOfEmployees.spliterator().getExactSizeIfKnown();
	
		    if (size == 1) {
				return current;
		    } else {
	
				current.setOffices(employees.getOffices());
				current.setLastName(employees.getLastName());
				current.setReportsTo(employees.getReportsTo());
				current.setExtension(employees.getExtension());
				current.setEmail(employees.getEmail());
				current.setJobTitle(employees.getJobTitle());
				current.setFirstName(employees.getFirstName());
				current.setIsActive(employees.getIsActive());			
	
				return employeesInterface.saveOne(current);
	
		    }
		}
	}
//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code
}
