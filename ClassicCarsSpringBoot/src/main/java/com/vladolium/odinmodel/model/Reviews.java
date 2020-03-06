package com.vladolium.odinmodel.model; 

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Reviews {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@NotNull
	@Size(max=4000)
	private String reviewText;
	
	public String getReviewText() {
		return reviewText;
	}
	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}
	
	
	
	
	
	
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd") //for database
	@JsonFormat(pattern = "yyyy-MM-dd") //for frontend
	private LocalDate reviewDate;
	
	public LocalDate getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(LocalDate reviewDate) {
		this.reviewDate = reviewDate;
	}
	
	
	
	
	
	
	
	
	
	
	@NotNull
	@DateTimeFormat(pattern = "HH:mm") //for database
	@JsonFormat(pattern = "HH:mm") //for frontend
	private LocalTime reviewTime;
	
	public LocalTime getReviewTime() {
		return reviewTime;
	}
	public void setReviewTime(LocalTime reviewTime) {
		this.reviewTime = reviewTime;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this entity
//End of user code
}

 
