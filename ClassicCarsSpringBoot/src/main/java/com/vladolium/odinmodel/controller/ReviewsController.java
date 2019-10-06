
package com.vladolium.odinmodel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.format.annotation.*;

import java.time.*;
import java.util.*;

import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.service.ReviewsService;
import com.vladolium.odinmodel.service.*;

import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Reviews;
import com.vladolium.odinmodel.domain.Reviews.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/reviews")
public class ReviewsController {

	private ReviewsService reviewsService;

	@Autowired
	public void setReviewsService(ReviewsService reviewsService) {
		this.reviewsService = reviewsService;
	}



@PostMapping("")
public Reviews createOne(@RequestBody Reviews reviews) {
	return reviewsService.createUpdate(reviews);
}






@PutMapping("/{id}")
public Reviews updateOneById(@PathVariable Long id, @RequestBody Reviews reviews) {
	Reviews current = reviewsService.readOneById(id);
	current.setReviewText(reviews.getReviewText());

	current.setReviewTime(reviews.getReviewTime());

	current.setReviewDate(reviews.getReviewDate());

	return reviewsService.createUpdate(current);
}












@GetMapping("/{id}")
public Reviews readOneById(@PathVariable Long id) {
	return reviewsService.readOneById(id);
}









@GetMapping("")
public Iterable<Reviews> readAll() {
	return reviewsService.readAll();
}


@GetMapping("/{pageNumber}/{perPageNumber}")
public Page<Reviews> readAllPagination(
	@PathVariable Integer pageNumber,
	@PathVariable Integer perPageNumber
) {
	Pageable page = PageRequest.of(pageNumber, perPageNumber);
	return reviewsService.readAllPagination(page);
}










@GetMapping("/search")
public Iterable<Reviews> search(


	@RequestParam(value = "reviewText", required = false) String reviewText,
	@RequestParam(value = "reviewTime", required = false) @DateTimeFormat(pattern = "HH:mm") LocalTime reviewTime,
	@RequestParam(value = "reviewDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate reviewDate
) {
	return reviewsService.search(
	reviewText,
	reviewTime,
	reviewDate
	);
}










@DeleteMapping("/{id}")
public void deleteOneById(@PathVariable Long id) {
	reviewsService.deleteOneById(id);
}

	

//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code

}
