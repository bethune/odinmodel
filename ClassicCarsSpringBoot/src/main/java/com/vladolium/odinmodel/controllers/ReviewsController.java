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

//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code
}
