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
import com.vladolium.odinmodel.specifications.*;
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
		Specification<Reviews> where = dynamicWhere(
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
		Specification<Reviews> where = dynamicWhere(
			reviewTime,
			reviewDate,
			reviewText
		);
		return reviewsRepository.findAll(where, page);
	}
	
	public Specification<Reviews> dynamicWhere(
		LocalTime reviewTime,
		LocalDate reviewDate,
		String reviewText
	) {
		Specification<Reviews> where = Specification
			.where(reviewTime == null ? null : ReviewsSpecification.getReviewsByReviewTime(reviewTime))
			.and(reviewDate == null ? null : ReviewsSpecification.getReviewsByReviewDate(reviewDate))
			.and(reviewText == null ? null : ReviewsSpecification.getReviewsByReviewText(reviewText));
	
		return where;
	}

	

	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code
}
