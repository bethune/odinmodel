package com.vladolium.odinmodel.services; 

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Reviews;
import com.vladolium.odinmodel.model.Reviews.*;
import com.vladolium.odinmodel.repositories.*;
import com.vladolium.odinmodel.repositories.ReviewsRepository;
import com.vladolium.odinmodel.interfaces.ReviewsInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Transactional;
import java.time.*;
import java.util.*;
import com.vladolium.odinmodel.wrappers.*;
import com.querydsl.core.BooleanBuilder;

@Service
@Transactional
public class ReviewsService implements ReviewsInterface {

	private ReviewsRepository reviewsRepository;

	@Autowired
	public void setReviewsRepository(ReviewsRepository reviewsRepository) {
		this.reviewsRepository = reviewsRepository;
	}

	// covers create, update and update with IRIC
	@Override
	public Reviews saveOne(Reviews reviews) {
		return reviewsRepository.save(reviews);
	}
	
	


//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code
}
