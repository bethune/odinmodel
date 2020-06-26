package com.vladolium.odinmodel.controllers;

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Marks.*;

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
@RequestMapping("/api/marks")
public class MarksController {

	private MarksInterface marksInterface;

	@Autowired
	public void setMarksInterface(MarksInterface marksInterface) {
		this.marksInterface = marksInterface;
	}

	@PostMapping("")
	public Marks saveOne(@RequestBody Marks marks) {
		return marksInterface.saveOne(marks);
	}

	@DeleteMapping("/{id}")
	public void deleteOneById(@PathVariable Long id) {
		marksInterface.deleteOneById(id);
	}
	
	@GetMapping("/{id}")
	public Marks readOneById(@PathVariable Long id) {
		return marksInterface.readOneById(id);
	}
	
	@PutMapping("/{id}")
	public Marks updateOneById(@PathVariable Long id, @RequestBody Marks marks) {
		
		Marks current = marksInterface.readOneById(id);
			
		current.setEmployees(marks.getEmployees());				
		current.setCustomers(marks.getCustomers());
		current.setMarkType(marks.getMarkType());
		current.setComment(marks.getComment());
				
		return marksInterface.saveOne(current);
	}

	@GetMapping("")
	public Iterable<Marks> readAll() {
		return marksInterface.readAll();
	}
	
	@GetMapping("/page={pageNumber}/perPage={perPageNumber}")
	public Page<Marks> readAllPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return marksInterface.readAllPagination(page);
	}

	@GetMapping("/search")
	public Iterable<Marks> search(
		Long employeesId,
		
		
		
		
		
		
		
		
		
		
		Long customersId,
		MarkType markType,
		String comment
	) {
		return marksInterface.search(
			employeesId,
			
			
			
			
			
			
			
			
			
			
			customersId,
			markType,
			comment
		);
	}
	
	@GetMapping("/search/page={pageNumber}/perPage={perPageNumber}")
	public Page<Marks> searchPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber,
		Long employeesId,
		
		
		
		
		
		
		
		
		
		
		Long customersId,
		MarkType markType,
		String comment
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
	
		return marksInterface.searchPagination(
			page,
			employeesId,
			
			
			
			
			
			
			
			
			
			
			customersId,
			markType,
			comment
		);
	}

	

	

	

//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code
}
