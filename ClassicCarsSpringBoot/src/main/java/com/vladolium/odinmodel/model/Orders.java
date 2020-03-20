package com.vladolium.odinmodel.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.*;
import java.util.*;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Orders {

	//Numerical fields ------------------------------------------------------------
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
	
	//Textual fields ------------------------------------------------------------
	
	@NotNull
	@Size(max=15)
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	//Logical fields ------------------------------------------------------------
	
	
	
	//Date and time fields ------------------------------------------------------------
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd") //for database
	@JsonFormat(pattern = "yyyy-MM-dd") //for frontend
	private LocalDate requiredDate;
	
	public LocalDate getRequiredDate() {
		return requiredDate;
	}
	public void setRequiredDate(LocalDate requiredDate) {
		this.requiredDate = requiredDate;
	}
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd") //for database
	@JsonFormat(pattern = "yyyy-MM-dd") //for frontend
	private LocalDate shippedDate;
	
	public LocalDate getShippedDate() {
		return shippedDate;
	}
	public void setShippedDate(LocalDate shippedDate) {
		this.shippedDate = shippedDate;
	}
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd") //for database
	@JsonFormat(pattern = "yyyy-MM-dd") //for frontend
	private LocalDate orderDate;
	
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	
	
	
	
	
	
	
	//Binary fields ------------------------------------------------------------
	
	@Size(max=4000)
	@Lob
	private String comments;
	
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}

/*Code between start and end will not be removed during generation.*/
//Start of user code for this entity
//End of user code
}
