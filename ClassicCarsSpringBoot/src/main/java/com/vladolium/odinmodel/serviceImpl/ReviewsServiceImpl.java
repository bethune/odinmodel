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
import com.querydsl.core.BooleanBuilder;

@Service
public class ReviewsServiceImpl implements ReviewsService {

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
		LocalDate reviewDate,
		String reviewText,
		LocalTime reviewTime
		
	) {
		BooleanBuilder where = dynamicWhere(
			reviewDate,
			reviewText,
			reviewTime
				
		);
		return reviewsRepository.findAll(where);
	}
	
	@Override
	public Page<Reviews> searchPagination(
		Pageable page,
		LocalDate reviewDate,
		String reviewText,
		LocalTime reviewTime
		
	) {
		BooleanBuilder where = dynamicWhere(
			reviewDate,
			reviewText,
			reviewTime
			
		);
		return reviewsRepository.findAll(where, page);
	}
	
	public BooleanBuilder dynamicWhere(
		LocalDate reviewDate,
		String reviewText,
		LocalTime reviewTime
		
	) {
		QReviews qReviews = QReviews.reviews;
	
		BooleanBuilder where = new BooleanBuilder();
	
		if (reviewDate != null) {
			where.and(qReviews.reviewDate.eq(reviewDate));
		}
		if (reviewText != null) {
			where.and(qReviews.reviewText.containsIgnoreCase(reviewText));
		}
		if (reviewTime != null) {
			where.and(qReviews.reviewTime.eq(reviewTime));
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
