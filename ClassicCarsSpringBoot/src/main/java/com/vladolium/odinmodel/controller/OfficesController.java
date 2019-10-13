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
	
	
	
	
	
	@PutMapping("/{id}")
	public Offices updateOneById(@PathVariable Long id, @RequestBody Offices offices) {
		Offices current = officesService.readOneById(id);
		
		current.setCity(offices.getCity());
		
		current.setPhone(offices.getPhone());
		
		current.setAddressLine1(offices.getAddressLine1());
		
		current.setTerritory(offices.getTerritory());
		
		current.setCountry(offices.getCountry());
		
		
		current.setAddressLine2(offices.getAddressLine2());
		
		current.setState(offices.getState());
		
		current.setPostalCode(offices.getPostalCode());
					
		return officesService.createUpdate(current);
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/search")
	public Iterable<Offices> search(
		@RequestParam(value = "city", required = false) String city,
		@RequestParam(value = "phone", required = false) String phone,
		@RequestParam(value = "addressLine1", required = false) String addressLine1,
		@RequestParam(value = "territory", required = false) String territory,
		@RequestParam(value = "country", required = false) String country,
		@RequestParam(value = "addressLine2", required = false) String addressLine2,
		@RequestParam(value = "state", required = false) String state,
		@RequestParam(value = "postalCode", required = false) String postalCode
		
	) {
		return officesService.search(
			city,
			phone,
			addressLine1,
			territory,
			country,
			addressLine2,
			state,
			postalCode
			
		);
	}
	
	@GetMapping("/search/page={pageNumber}/perPage={perPageNumber}")
	public Page<Offices> searchPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber,
		@RequestParam(value = "city", required = false) String city,
		@RequestParam(value = "phone", required = false) String phone,
		@RequestParam(value = "addressLine1", required = false) String addressLine1,
		@RequestParam(value = "territory", required = false) String territory,
		@RequestParam(value = "country", required = false) String country,
		@RequestParam(value = "addressLine2", required = false) String addressLine2,
		@RequestParam(value = "state", required = false) String state,
		@RequestParam(value = "postalCode", required = false) String postalCode
		
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
	
		return officesService.searchPagination(
			page,
			city,
			phone,
			addressLine1,
			territory,
			country,
			addressLine2,
			state,
			postalCode
			
		);
	}
	
	
	
	
	
	@DeleteMapping("/{id}")
	public void deleteOneById(@PathVariable Long id) {
		officesService.deleteOneById(id);
	}
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code
}
