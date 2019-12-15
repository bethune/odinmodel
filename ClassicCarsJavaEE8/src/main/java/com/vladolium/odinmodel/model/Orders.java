package com.vladolium.odinmodel.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.*;
import java.util.*;

@Entity
public class Orders {

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
	@Size(max=15)
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
	
	
	
	
	
	@NotNull
	private LocalDate orderDate;
	
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	
	
	@NotNull
	private LocalDate requiredDate;
	
	public LocalDate getRequiredDate() {
		return requiredDate;
	}
	public void setRequiredDate(LocalDate requiredDate) {
		this.requiredDate = requiredDate;
	}
	
	private LocalDate shippedDate;
	
	public LocalDate getShippedDate() {
		return shippedDate;
	}
	public void setShippedDate(LocalDate shippedDate) {
		this.shippedDate = shippedDate;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Size(max=4000)
	@Lob
	private String comments;
	
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
	
	
	
	
	
	
	@ManyToOne
	@JoinColumn(name="customers_id")
	private Customers customers;
	
	public Customers getCustomers() {
		return customers;
	}
	public void setCustomers(Customers customers) {
		this.customers = customers;
	}
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this entity
//End of user code
}
