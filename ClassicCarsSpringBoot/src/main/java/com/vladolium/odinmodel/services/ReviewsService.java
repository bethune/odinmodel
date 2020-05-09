package com.vladolium.odinmodel.services;

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Reviews.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Transactional;

import java.time.*;
import java.util.*;

import com.vladolium.odinmodel.repositories.*;
import com.vladolium.odinmodel.interfaces.*;
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

	@Override
	public Reviews saveOne(Reviews reviews) {
		return reviewsRepository.save(reviews);
	}

	@Override
	public void deleteOneById(Long id) {
	    reviewsRepository.deleteById(id);
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
		LocalTime reviewTime,
		LocalDate reviewDate,
		String reviewText
	) {
		BooleanBuilder where = dynamicWhere(
			reviewTime,
			reviewDate,
			reviewText	
		);
		return reviewsRepository.findAll(where);
	}
	
	@Override
	public Page<Reviews> searchPagination(
		Pageable page,
		LocalTime reviewTime,
		LocalDate reviewDate,
		String reviewText
	) {
		BooleanBuilder where = dynamicWhere(
			reviewTime,
			reviewDate,
			reviewText
		);
		return reviewsRepository.findAll(where, page);
	}
	
	public BooleanBuilder dynamicWhere(
		LocalTime reviewTime,
		LocalDate reviewDate,
		String reviewText
	) {
		QReviews qReviews = QReviews.reviews;
	
		BooleanBuilder where = new BooleanBuilder();
	
		if (reviewTime != null) {
			where.and(qReviews.reviewTime.eq(reviewTime));
		}
		if (reviewDate != null) {
			where.and(qReviews.reviewDate.eq(reviewDate));
		}
		if (reviewText != null) {
			where.and(qReviews.reviewText.containsIgnoreCase(reviewText));
		}
	
		return where;
	}

	

	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code
}
