package com.vladolium.odinmodel.view;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.*;
//import org.springframework.format.annotation.*;
import java.time.*;
import java.util.*;
import java.io.Serializable;
import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Reviews;
import com.vladolium.odinmodel.model.Reviews.*;
import com.vladolium.odinmodel.service.ReviewsService;
import com.vladolium.odinmodel.service.*;
import com.vladolium.odinmodel.wrapper.*;

@Named
@ViewScoped
public class ReviewsView implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private ReviewsService reviewsService;

	
	private Reviews reviews;
	
	public Reviews createOne() {
		return reviewsService.createUpdate(reviews);
	}
	
	
	public Reviews updateOneById(Long id) {
		Reviews current = reviewsService.readOneById(id);
		
		
		current.setReviewTime(reviews.getReviewTime());
		
		current.setReviewText(reviews.getReviewText());
		
		current.setReviewDate(reviews.getReviewDate());
					
		return reviewsService.createUpdate(current);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Reviews readOneById(Long id) {
		return reviewsService.readOneById(id);
	}
	
	
	
	
	
	
	
	
	public Iterable<Reviews> readAll() {
		return reviewsService.readAll();
	}
	
	public Page<Reviews> readAllPagination(
		Integer pageNumber,
		Integer perPageNumber
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return reviewsService.readAllPagination(page);
	}
	
	
	public Iterable<Reviews> search(
		LocalTime reviewTime,
		String reviewText,
		LocalDate reviewDate
		
	) {
		return reviewsService.search(
			reviewTime,
			reviewText,
			reviewDate
			
		);
	}
	
	public Page<Reviews> searchPagination(
		Integer pageNumber,
		Integer perPageNumber,
		LocalTime reviewTime,
		String reviewText,
		LocalDate reviewDate
		
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
	
		return reviewsService.searchPagination(
			page,
			reviewTime,
			reviewText,
			reviewDate
			
		);
	}
	public void deleteOneById(Long id) {
		reviewsService.deleteOneById(id);
	}
	
	
	
	
	
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this view
//End of user code
}
