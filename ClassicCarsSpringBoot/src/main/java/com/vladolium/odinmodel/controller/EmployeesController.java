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
import com.vladolium.odinmodel.wrapper.*;

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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@DeleteMapping("/{id}")
	public void deleteOneById(@PathVariable Long id) {
		employeesService.deleteOneById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@DeleteMapping("/{id}/offices")
	public void deleteOneByIdIric(@PathVariable Long id) {
		Employees current = employeesService.readOneById(id);
		Iterable<Employees> listOfEmployees = employeesService
			.readAllByOfficesId(current.getOffices().getId());
		Long size = listOfEmployees.spliterator().getExactSizeIfKnown();
		if (size == 1) {
		    return;
		} else {
		    employeesService.deleteOneById(id);
		}
	}
	
	
	
	
	
	
	
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code
}
