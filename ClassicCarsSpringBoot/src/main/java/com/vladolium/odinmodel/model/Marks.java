package com.vladolium.odinmodel.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.*;
import java.util.*;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Marks {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	private String comment;
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public enum MarkType {
		EXCELLENT,
		GOOD,
		AVERAGE,
		BAD,
		
	}
	
	@NotNull
	@Enumerated(javax.persistence.EnumType.STRING) // --obligatory for saving the value as string, not int
	private MarkType markType;
	
	public MarkType getMarkType() {
		return markType;
	}
	public void setMarkType(MarkType markType) {
		this.markType = markType;
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
	@ManyToOne
	@JoinColumn(name="customers_id")
	private Customers customers;
	
	public Customers getCustomers() {
		return customers;
	}
	public void setCustomers(Customers customers) {
		this.customers = customers;
	}

/*Code between start and end will not be removed during generation.*/
//Start of user code for this entity
//End of user code
}
