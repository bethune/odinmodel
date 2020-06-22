package com.vladolium.odinmodel.controllers;

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Offices.*;

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
@RequestMapping("/api/offices")
public class OfficesController {

	private OfficesInterface officesInterface;

	@Autowired
	public void setOfficesInterface(OfficesInterface officesInterface) {
		this.officesInterface = officesInterface;
	}

	@PostMapping("")
	public Offices saveOne(@RequestBody Offices offices) {
		return officesInterface.saveOne(offices);
	}

	@DeleteMapping("/{id}")
	public void deleteOneById(@PathVariable Long id) {
		officesInterface.deleteOneById(id);
	}
	
	@GetMapping("/{id}")
	public Offices readOneById(@PathVariable Long id) {
		return officesInterface.readOneById(id);
	}
	
	@PutMapping("/{id}")
	public Offices updateOneById(@PathVariable Long id, @RequestBody Offices offices) {
		
		Offices current = officesInterface.readOneById(id);
			
		current.setAddressLine1(offices.getAddressLine1());
		current.setPostalCode(offices.getPostalCode());
		current.setTerritory(offices.getTerritory());
		current.setCity(offices.getCity());
		current.setPhone(offices.getPhone());
		current.setCountry(offices.getCountry());
		current.setState(offices.getState());
		current.setAddressLine2(offices.getAddressLine2());
				
		return officesInterface.saveOne(current);
	}

	@GetMapping("")
	public Iterable<Offices> readAll() {
		return officesInterface.readAll();
	}
	
	@GetMapping("/page={pageNumber}/perPage={perPageNumber}")
	public Page<Offices> readAllPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return officesInterface.readAllPagination(page);
	}

	@GetMapping("/search")
	public Iterable<Offices> search(
		String addressLine1,
		String postalCode,
		String territory,
		String city,
		String phone,
		String country,
		String state,
		String addressLine2
	) {
		return officesInterface.search(
			addressLine1,
			postalCode,
			territory,
			city,
			phone,
			country,
			state,
			addressLine2
		);
	}
	
	@GetMapping("/search/page={pageNumber}/perPage={perPageNumber}")
	public Page<Offices> searchPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber,
		String addressLine1,
		String postalCode,
		String territory,
		String city,
		String phone,
		String country,
		String state,
		String addressLine2
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
	
		return officesInterface.searchPagination(
			page,
			addressLine1,
			postalCode,
			territory,
			city,
			phone,
			country,
			state,
			addressLine2
		);
	}

	private EmployeesInterface employeesInterface;
	
	@Autowired
	public void setEmployeesInterface(EmployeesInterface employeesInterface) {
		this.employeesInterface = employeesInterface;
	}
	
	
	
	
	@GetMapping("/{officesId}/employees")
	public Iterable<Employees> readAllEmployeesByOfficesId(@PathVariable Long officesId) {
		return employeesInterface.readAllByOfficesId(officesId);
	}
	
	@GetMapping("/{officesId}/employees/page={pageNumber}/perPage={perPageNumber}")
	public Page<Employees> readAllEmployeesByOfficesIdPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber,
		@PathVariable Long officesId
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return employeesInterface.readAllByOfficesId(officesId, page);
	}

	

	@PostMapping("/employees")
	public Offices saveOneWhenIricOnManyToOneRelationship(@RequestBody OfficesEmployees officesEmployees) {
		return officesInterface.saveOneWhenIricOnManyToOneRelationship(officesEmployees);
	}

//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code
}
