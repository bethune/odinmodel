package com.vladolium.odinmodel.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.*;
import java.util.*;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Customers extends ContactDetails {

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
	@DecimalMax("300.00")
	private Double creditLimit;
	
	public Double getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(Double creditLimit) {
		this.creditLimit = creditLimit;
	}
	
	@NotNull
	@Size(max=50)
	private String firstName;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@NotNull
	@Column(unique=true)
	@Size(max=50)
	private String customerName;
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	@NotNull
	@Size(max=50)
	private String lastName;
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@ManyToOne
	@JoinColumn(name="employees_id")
	private Employees employees;
	
	public Employees getEmployees() {
		return employees;
	}
	public void setEmployees(Employees employees) {
		this.employees = employees;
	}
	@OneToMany
	@JoinColumn(name="customers_id")
	private List<Reviews> reviewsList;
	
	public List<Reviews> getReviewsList() {
		return reviewsList;
	}
	public void setReviewsList(List<Reviews> reviewsList) {
		this.reviewsList = reviewsList;
	}
		
/*Code between start and end will not be removed during generation.*/
//Start of user code for this inheriting entity
//End of user code
}
