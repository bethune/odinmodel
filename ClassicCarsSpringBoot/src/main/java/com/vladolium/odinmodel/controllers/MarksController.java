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
			
		current.setCustomers(marks.getCustomers());				
		current.setEmployees(marks.getEmployees());
		current.setComment(marks.getComment());
		current.setMarkType(marks.getMarkType());
				
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
		Long customersId,
		
		
		
		
		
		
		
		
		
		
		Long employeesId,
		String comment,
		MarkType markType
	) {
		return marksInterface.search(
			customersId,
			
			
			
			
			
			
			
			
			
			
			employeesId,
			comment,
			markType
		);
	}
	
	@GetMapping("/search/page={pageNumber}/perPage={perPageNumber}")
	public Page<Marks> searchPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber,
		Long customersId,
		
		
		
		
		
		
		
		
		
		
		Long employeesId,
		String comment,
		MarkType markType
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
	
		return marksInterface.searchPagination(
			page,
			customersId,
			
			
			
			
			
			
			
			
			
			
			employeesId,
			comment,
			markType
		);
	}

	

	@GetMapping("/comment={comment}")
	public Marks readOneByComment(@PathVariable String comment) {
		return marksInterface.readOneByComment(comment);
	}
	
	@PutMapping("/comment={comment}")
	public Marks updateOneByComment(@PathVariable String comment, @RequestBody Marks marks) {
		
		Marks current = marksInterface.readOneByComment(comment);
			
		current.setCustomers(marks.getCustomers());				
		current.setEmployees(marks.getEmployees());
		current.setComment(marks.getComment());
		current.setMarkType(marks.getMarkType());
				
		return marksInterface.saveOne(current);
	}

	

//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code
}
