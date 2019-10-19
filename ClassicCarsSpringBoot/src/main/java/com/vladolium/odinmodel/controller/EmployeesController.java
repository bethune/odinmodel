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
import com.vladolium.odinmodel.wrapperRequest.*;

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
		
		current.setJobTitle(employees.getJobTitle());
		
		current.setIsActive(employees.getIsActive());
		
		current.setReportsTo(employees.getReportsTo());
		
		current.setExtension(employees.getExtension());
		
		
		current.setLastName(employees.getLastName());
					
		return employeesService.createUpdate(current);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/{id}")
	public Employees readOneById(@PathVariable Long id) {
		return employeesService.readOneById(id);
	}
	
	
	
	
	
	
	
	
	
	
	@GetMapping("")
	public Iterable<Employees> readAll() {
		return employeesService.readAll();
	}
	
	@GetMapping("/page={pageNumber}/perPage={perPageNumber}")
	public Page<Employees> readAllPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return employeesService.readAllPagination(page);
	}
	
	private CustomersService customersService;
	
	@Autowired
	public void setCustomersService(CustomersService customersService) {
		this.customersService = customersService;
	}
	
	
	
	
	
	
	
	@GetMapping("/{employeesId}/customers")
	public Iterable<Customers> readAllCustomersByEmployeesId(@PathVariable Long employeesId) {
		return customersService.readAllByEmployeesId(employeesId);
	}
	
	@GetMapping("/{employeesId}/customers/page={pageNumber}/perPage={perPageNumber}")
	public Page<Customers> readAllCustomersByEmployeesIdPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber,
		@PathVariable Long employeesId
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return customersService.readAllByEmployeesId(employeesId, page);
	}
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/search")
	public Iterable<Employees> search(
		@RequestParam(value = "officesId", required = false) Long officesId,
		
		
		
		
		
		
		
		
		@RequestParam(value = "firstName", required = false) String firstName,
		@RequestParam(value = "email", required = false) String email,
		@RequestParam(value = "jobTitle", required = false) String jobTitle,
		@RequestParam(value = "isActive", required = false) Boolean isActive,
		@RequestParam(value = "reportsTo", required = false) Integer reportsTo,
		@RequestParam(value = "extension", required = false) String extension,
		@RequestParam(value = "lastName", required = false) String lastName
		
	) {
		return employeesService.search(
			officesId,
			
			
			
			
			
			
			
			
			firstName,
			email,
			jobTitle,
			isActive,
			reportsTo,
			extension,
			lastName
			
		);
	}
	
	@GetMapping("/search/page={pageNumber}/perPage={perPageNumber}")
	public Page<Employees> searchPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber,
		@RequestParam(value = "officesId", required = false) Long officesId,
		
		
		
		
		
		
		
		
		@RequestParam(value = "firstName", required = false) String firstName,
		@RequestParam(value = "email", required = false) String email,
		@RequestParam(value = "jobTitle", required = false) String jobTitle,
		@RequestParam(value = "isActive", required = false) Boolean isActive,
		@RequestParam(value = "reportsTo", required = false) Integer reportsTo,
		@RequestParam(value = "extension", required = false) String extension,
		@RequestParam(value = "lastName", required = false) String lastName
		
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
	
		return employeesService.searchPagination(
			page,
			officesId,
			
			
			
			
			
			
			
			
			firstName,
			email,
			jobTitle,
			isActive,
			reportsTo,
			extension,
			lastName
			
		);
	}
	
	
	
	
	
	
	
	@DeleteMapping("/{id}")
	public void deleteOneById(@PathVariable Long id) {
		employeesService.deleteOneById(id);
	}
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code
}
