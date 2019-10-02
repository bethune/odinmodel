
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

//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code

}
