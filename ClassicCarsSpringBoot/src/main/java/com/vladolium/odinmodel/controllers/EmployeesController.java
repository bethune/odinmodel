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
		current.setFirstName(employees.getFirstName());
		current.setExtension(employees.getExtension());
		current.setReportsTo(employees.getReportsTo());
		current.setEmail(employees.getEmail());
		current.setJobTitle(employees.getJobTitle());
		current.setIsActive(employees.getIsActive());
		current.setLastName(employees.getLastName());
				
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

	@GetMapping("/search")
	public Iterable<Employees> search(
		Long officesId,
		String firstName,
		String extension,
		Integer reportsTo,
		String email,
		String jobTitle,
		Boolean isActive,
		String lastName
	) {
		return employeesInterface.search(
			officesId,
			firstName,
			extension,
			reportsTo,
			email,
			jobTitle,
			isActive,
			lastName
		);
	}
	
	@GetMapping("/search/page={pageNumber}/perPage={perPageNumber}")
	public Page<Employees> searchPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber,
		Long officesId,
		String firstName,
		String extension,
		Integer reportsTo,
		String email,
		String jobTitle,
		Boolean isActive,
		String lastName
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
	
		return employeesInterface.searchPagination(
			page,
			officesId,
			firstName,
			extension,
			reportsTo,
			email,
			jobTitle,
			isActive,
			lastName
		);
	}

	private MarksInterface marksInterface;
	
	@Autowired
	public void setMarksInterface(MarksInterface marksInterface) {
		this.marksInterface = marksInterface;
	}
	
	
	
	
	
	@GetMapping("/{employeesId}/marks")
	public Iterable<Marks> readAllMarksByEmployeesId(@PathVariable Long employeesId) {
		return marksInterface.readAllByEmployeesId(employeesId);
	}
	
	@GetMapping("/{employeesId}/marks/page={pageNumber}/perPage={perPageNumber}")
	public Page<Marks> readAllMarksByEmployeesIdPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber,
		@PathVariable Long employeesId
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return marksInterface.readAllByEmployeesId(employeesId, page);
	}
	
	
	
	
	
	
	
	
	
	
	private CustomersInterface customersInterface;
	
	@Autowired
	public void setCustomersInterface(CustomersInterface customersInterface) {
		this.customersInterface = customersInterface;
	}
	
	
	
	
	
	@GetMapping("/{employeesId}/customers")
	public Iterable<Customers> readAllCustomersByEmployeesId(@PathVariable Long employeesId) {
		return customersInterface.readAllByEmployeesId(employeesId);
	}
	
	@GetMapping("/{employeesId}/customers/page={pageNumber}/perPage={perPageNumber}")
	public Page<Customers> readAllCustomersByEmployeesIdPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber,
		@PathVariable Long employeesId
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return customersInterface.readAllByEmployeesId(employeesId, page);
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
			current.setFirstName(employees.getFirstName());
			current.setExtension(employees.getExtension());
			current.setReportsTo(employees.getReportsTo());
			current.setEmail(employees.getEmail());
			current.setJobTitle(employees.getJobTitle());
			current.setIsActive(employees.getIsActive());
			current.setLastName(employees.getLastName());			
	
			return employeesInterface.saveOne(current);
	
		} else {
	
		    Iterable<Employees> listOfEmployees = employeesInterface.readAllByOfficesId(current.getOffices().getId());
	
		    Long size = listOfEmployees.spliterator().getExactSizeIfKnown();
	
		    if (size == 1) {
				return current;
		    } else {
	
				current.setOffices(employees.getOffices());
				current.setFirstName(employees.getFirstName());
				current.setExtension(employees.getExtension());
				current.setReportsTo(employees.getReportsTo());
				current.setEmail(employees.getEmail());
				current.setJobTitle(employees.getJobTitle());
				current.setIsActive(employees.getIsActive());
				current.setLastName(employees.getLastName());			
	
				return employeesInterface.saveOne(current);
	
		    }
		}
	}

//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code
}
