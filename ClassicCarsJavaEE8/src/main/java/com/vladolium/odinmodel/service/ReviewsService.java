package com.vladolium.odinmodel.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.inject.Inject;
import javax.annotation.PostConstruct;
import com.vladolium.odinmodel.model.*;
import java.time.*;
import java.util.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.querydsl.*;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import com.querydsl.core.BooleanBuilder;
import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Reviews;
import com.vladolium.odinmodel.model.Reviews.*;
import com.vladolium.odinmodel.repository.*;
import com.vladolium.odinmodel.repository.ReviewsRepository;
import com.vladolium.odinmodel.wrapper.*;

@Stateless
public class ReviewsService {

 	@PersistenceContext
    private EntityManager em;

	private ReviewsRepository reviewsRepository;
	
	@PostConstruct
	private void init() {
		RepositoryFactorySupport factory = new JpaRepositoryFactory(em);
		this.reviewsRepository = factory.getRepository(ReviewsRepository.class);
	}

	// covers create, update and update with IRIC
	public Reviews createUpdate(Reviews reviews) {
		return reviewsRepository.save(reviews);
	}
	
	
	public Reviews readOneById(Long id) {
		return reviewsRepository.getOne(id);
	}
	
	
	
	
	
	
	
	
	public Iterable<Reviews> readAll() {
		return reviewsRepository.findAll();
	}
	
	public Page<Reviews> readAllPagination(Pageable page) {
		return reviewsRepository.findAll(page);
	}
	
	
	
	public Iterable<Reviews> search(
		LocalTime reviewTime,
		String reviewText,
		LocalDate reviewDate
		
	) {
		BooleanBuilder where = dynamicWhere(
			reviewTime,
			reviewText,
			reviewDate
				
		);
		return reviewsRepository.findAll(where);
	}
	
	public Page<Reviews> searchPagination(
		Pageable page,
		LocalTime reviewTime,
		String reviewText,
		LocalDate reviewDate
		
	) {
		BooleanBuilder where = dynamicWhere(
			reviewTime,
			reviewText,
			reviewDate
			
		);
		return reviewsRepository.findAll(where, page);
	}
	
	public BooleanBuilder dynamicWhere(
		LocalTime reviewTime,
		String reviewText,
		LocalDate reviewDate
		
	) {
		QReviews qReviews = QReviews.reviews;
	
		BooleanBuilder where = new BooleanBuilder();
	
		if (reviewTime != null) {
			where.and(qReviews.reviewTime.eq(reviewTime));
		}
		if (reviewText != null) {
			where.and(qReviews.reviewText.containsIgnoreCase(reviewText));
		}
		if (reviewDate != null) {
			where.and(qReviews.reviewDate.eq(reviewDate));
		}
		
	
		return where;
	}
	
	public void deleteOneById(Long id) {
	    reviewsRepository.deleteById(id);
	}
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this service
//End of user code
}
