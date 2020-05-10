package com.vladolium.odinmodel.controllers;

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Reviews.*;

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
@RequestMapping("/api/reviews")
public class ReviewsController {

	private ReviewsInterface reviewsInterface;

	@Autowired
	public void setReviewsInterface(ReviewsInterface reviewsInterface) {
		this.reviewsInterface = reviewsInterface;
	}

	@PostMapping("")
	public Reviews saveOne(@RequestBody Reviews reviews) {
		return reviewsInterface.saveOne(reviews);
	}

	@DeleteMapping("/{id}")
	public void deleteOneById(@PathVariable Long id) {
		reviewsInterface.deleteOneById(id);
	}
	
	@GetMapping("/{id}")
	public Reviews readOneById(@PathVariable Long id) {
		return reviewsInterface.readOneById(id);
	}
	
	@PutMapping("/{id}")
	public Reviews updateOneById(@PathVariable Long id, @RequestBody Reviews reviews) {
		
		Reviews current = reviewsInterface.readOneById(id);
			
		current.setReviewTime(reviews.getReviewTime());
		current.setReviewDate(reviews.getReviewDate());
		current.setReviewText(reviews.getReviewText());
				
		return reviewsInterface.saveOne(current);
	}

	@GetMapping("")
	public Iterable<Reviews> readAll() {
		return reviewsInterface.readAll();
	}
	
	@GetMapping("/page={pageNumber}/perPage={perPageNumber}")
	public Page<Reviews> readAllPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return reviewsInterface.readAllPagination(page);
	}


	

	
//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code
}
