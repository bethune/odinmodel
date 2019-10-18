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
import com.vladolium.odinmodel.wrapperRequest.*;

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
		
		
		current.setPostalCode(offices.getPostalCode());
		
		current.setAddressLine1(offices.getAddressLine1());
		
		current.setCountry(offices.getCountry());
		
		current.setTerritory(offices.getTerritory());
		
		current.setPhone(offices.getPhone());
		
		current.setCity(offices.getCity());
		
		current.setAddressLine2(offices.getAddressLine2());
		
		current.setState(offices.getState());
					
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
		@RequestParam(value = "postalCode", required = false) String postalCode,
		@RequestParam(value = "addressLine1", required = false) String addressLine1,
		@RequestParam(value = "country", required = false) String country,
		@RequestParam(value = "territory", required = false) String territory,
		@RequestParam(value = "phone", required = false) String phone,
		@RequestParam(value = "city", required = false) String city,
		@RequestParam(value = "addressLine2", required = false) String addressLine2,
		@RequestParam(value = "state", required = false) String state
		
	) {
		return officesService.search(
			postalCode,
			addressLine1,
			country,
			territory,
			phone,
			city,
			addressLine2,
			state
			
		);
	}
	
	@GetMapping("/search/page={pageNumber}/perPage={perPageNumber}")
	public Page<Offices> searchPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber,
		@RequestParam(value = "postalCode", required = false) String postalCode,
		@RequestParam(value = "addressLine1", required = false) String addressLine1,
		@RequestParam(value = "country", required = false) String country,
		@RequestParam(value = "territory", required = false) String territory,
		@RequestParam(value = "phone", required = false) String phone,
		@RequestParam(value = "city", required = false) String city,
		@RequestParam(value = "addressLine2", required = false) String addressLine2,
		@RequestParam(value = "state", required = false) String state
		
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
	
		return officesService.searchPagination(
			page,
			postalCode,
			addressLine1,
			country,
			territory,
			phone,
			city,
			addressLine2,
			state
			
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
