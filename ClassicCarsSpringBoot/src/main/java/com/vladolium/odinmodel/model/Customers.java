package com.vladolium.odinmodel.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.*;
import java.util.*;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Customers extends ContactDetails {

	// Numerical fields ------------------------------------------------------------

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

	// Textual fields ------------------------------------------------------------

	@NotNull
	@Size(max = 50)
	private String firstName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@NotNull
	@Column(unique = true)
	@Size(max = 50)
	private String customerName;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@NotNull
	@Size(max = 50)
	private String lastName;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// Logical fields ------------------------------------------------------------

	// Date and time fields
	// ------------------------------------------------------------

	// Binary fields ------------------------------------------------------------

	/* Code between start and end will not be removed during generation. */
//Start of user code for this inheriting entity
//End of user code
}
