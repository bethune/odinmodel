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
import static org.jooq.impl.DSL.*;

@Service
public class ReviewsServiceImpl implements ReviewsService {

	private final DSLContext jooq;

	private ReviewsRepository reviewsRepository;

	@Autowired
	public void setReviewsRepository(ReviewsRepository reviewsRepository) {
		this.reviewsRepository = reviewsRepository;
	}

	// covers create & update
	@Override
	public Reviews createUpdate(Reviews reviews) {
		return reviewsRepository.save(reviews);
	}
	
	
	
	@Override
	public Reviews readOneById(Long id) {
		return reviewsRepository.getOne(id);
	}
	
	
	
	
	@Override
	public Iterable<Reviews> readAll() {
		return reviewsRepository.findAll();
	}
	@Override
	public Page<Reviews> readAllPagination(Pageable page) {
		return reviewsRepository.findAll(page);
	}
	@Override
	public Iterable<Reviews> search(
		
		String reviewText,
		LocalTime reviewTime,
		LocalDate reviewDate
		
	) {
		Condition condition = dynamicCondition(
			
			reviewText,
			reviewTime,
			reviewDate
		);
		return reviewsRepository.findAll(condition);
	}
	public Condition dynamicCondition(
		
		String reviewText,
		LocalTime reviewTime,
		LocalDate reviewDate
		
	) {
		Condition condition = trueCondition();
	
			if (reviewText != null) {
				where.and(qReviews.reviewText.containsIgnoreCase(reviewText));
			}
			if (reviewTime != null) {
				where.and(qReviews.reviewTime.eq(reviewTime));
			}
			if (reviewDate != null) {
				where.and(qReviews.reviewDate.eq(reviewDate));
			}
	
			return where;
		}
	
	
	
	
	@Override
	public void deleteOneById(Long id) {
		reviewsRepository.deleteById(id);
	}
	

//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code

}
