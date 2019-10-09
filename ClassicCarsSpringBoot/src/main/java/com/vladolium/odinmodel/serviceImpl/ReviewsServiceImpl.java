package com.vladolium.odinmodel.serviceImpl;

import com.vladolium.odinmodel.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;
import java.time.*;
import java.util.*;
import com.vladolium.odinmodel.repository.ReviewsRepository;
import com.vladolium.odinmodel.service.ReviewsService;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Reviews;
import com.vladolium.odinmodel.domain.Reviews.*;

@Service
public class ReviewsServiceImpl implements ReviewsService {

	private ReviewsRepository reviewsRepository;

	@Autowired
	public void setReviewsRepository(ReviewsRepository reviewsRepository) {
		this.reviewsRepository = reviewsRepository;
	}

	
	
	@Override
	public Reviews readOneById(Long id) {
		return reviewsRepository.getOne(id);
	}
	
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code

}
