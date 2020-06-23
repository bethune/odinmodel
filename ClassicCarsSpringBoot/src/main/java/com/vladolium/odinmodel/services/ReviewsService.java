package com.vladolium.odinmodel.services;

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Reviews.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.time.*;
import java.util.*;

import com.vladolium.odinmodel.repositories.*;
//import com.vladolium.odinmodel.specifications.*;
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
		Long customersId,
		LocalDate reviewDate,
		LocalTime reviewTime,
		String reviewText
	) {
		BooleanBuilder where = dynamicWhere(
			customersId,
			reviewDate,
			reviewTime,
			reviewText	
		);
		return reviewsRepository.findAll(where);
	}
	
	@Override
	public Page<Reviews> searchPagination(
		Pageable page,
		Long customersId,
		LocalDate reviewDate,
		LocalTime reviewTime,
		String reviewText
	) {
		BooleanBuilder where = dynamicWhere(
			customersId,
			reviewDate,
			reviewTime,
			reviewText
		);
		return reviewsRepository.findAll(where, page);
	}
	
	public BooleanBuilder dynamicWhere(
		Long customersId,
		LocalDate reviewDate,
		LocalTime reviewTime,
		String reviewText
	) {
		QReviews qReviews = QReviews.reviews;
	
		BooleanBuilder where = new BooleanBuilder();
	
		if (customersId != null) {
			where.and(qReviews.customers.id.eq(customersId));
		}
		if (reviewDate != null) {
			where.and(qReviews.reviewDate.eq(reviewDate));
		}
		if (reviewTime != null) {
			where.and(qReviews.reviewTime.eq(reviewTime));
		}
		if (reviewText != null) {
			where.and(qReviews.reviewText.containsIgnoreCase(reviewText));
		}
	
		return where;
	}


	@Override
	public Iterable<Reviews> readAllByCustomersId(Long customersId) {
		return reviewsRepository.findByCustomersIdEquals(customersId);
	}
	
	@Override
	public Page<Reviews> readAllByCustomersId(Long customersId, Pageable page) {
		return reviewsRepository.findByCustomersIdEquals(customersId, page);
	}
	
	
	
	@Override
	public Iterable<Reviews> readAllByCustomersCustomerName(String customersCustomerName) {
		return reviewsRepository.findByCustomersCustomerNameEquals(customersCustomerName);
	}
	
	@Override
	public Page<Reviews> readAllByCustomersCustomerName(String customersCustomerName, Pageable page) {
		return reviewsRepository.findByCustomersCustomerNameEquals(customersCustomerName, page);
	}

	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code
}
