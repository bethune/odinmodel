package com.vladolium.odinmodel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.format.annotation.*;
import java.time.*;
import java.util.*;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Offices;
import com.vladolium.odinmodel.domain.Offices.*;
import com.vladolium.odinmodel.service.OfficesService;
import com.vladolium.odinmodel.service.*;
import com.vladolium.odinmodel.wrapper.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/offices")
public class OfficesController {

	private OfficesService officesService;

	@Autowired
	public void setOfficesService(OfficesService officesService) {
		this.officesService = officesService;
	}

	@PostMapping("")
	public Offices createOne(@RequestBody Offices offices) {
		return officesService.createUpdate(offices);
	}
	
	@PostMapping("/employees")
	public Offices createOneIric(@RequestBody OfficesEmployees officesEmployees) {
		return officesService.createOneIric(officesEmployees);
	}
	
	
	
	
	
	
	
	
	@GetMapping("/{id}")
	public Offices readOneById(@PathVariable Long id) {
		return officesService.readOneById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("")
	public Iterable<Offices> readAll() {
		return officesService.readAll();
	}
	
	@GetMapping("/page={pageNumber}/perPage={perPageNumber}")
	public Page<Offices> readAllPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return officesService.readAllPagination(page);
	}
	
	private EmployeesService employeesService;
	
	@Autowired
	public void setEmployeesService(EmployeesService employeesService) {
		this.employeesService = employeesService;
	}
	
	
	
	
	
	
	
	@GetMapping("/{officesId}/employees")
	public Iterable<Employees> readAllEmployeesByOfficesId(@PathVariable Long officesId) {
		return employeesService.readAllByOfficesId(officesId);
	}
	
	@GetMapping("/{officesId}/employees/page={pageNumber}/perPage={perPageNumber}")
	public Page<Employees> readAllEmployeesByOfficesIdPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber,
		@PathVariable Long officesId
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return employeesService.readAllByOfficesId(officesId, page);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@DeleteMapping("/{id}")
	public void deleteOneById(@PathVariable Long id) {
		officesService.deleteOneById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code
}
