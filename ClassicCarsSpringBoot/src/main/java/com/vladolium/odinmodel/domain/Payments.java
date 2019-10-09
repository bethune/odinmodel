package com.vladolium.odinmodel.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.*;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.*;

@Entity
public class Payments {

	
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
	private Double amount;
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
	
	
	
	
	
	
	
	@NotNull
	private String checkNumber;
	public String getCheckNumber() {
		return checkNumber;
	}
	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd") //for database
	@JsonFormat(pattern = "yyyy-MM-dd") //for frontend
	private LocalDate paymentDate;
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private Instant paymentTimestamp = Instant.now();
	public Instant getPaymentTimestamp() {
	    return paymentTimestamp;
	}
	public void setPaymentTimestamp(Instant paymentTimestamp) {
	    this.paymentTimestamp = paymentTimestamp;
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

