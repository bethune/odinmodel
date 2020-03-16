package com.vladolium.odinmodel.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.*;
import java.util.*;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class OrderDetails {

		
		
		
		
		
			
		
		
		
		
		
		
		
		
			@NotNull
			private Integer orderLineNumber;
			
			public Integer getOrderLineNumber() {
				return orderLineNumber;
			}
			public void setOrderLineNumber(Integer orderLineNumber) {
				this.orderLineNumber = orderLineNumber;
			}
		
		
		
		
			
		
		
		
		
		
		
		
		
		
			@NotNull
				@DecimalMin("20.00")@DecimalMax("300.00")
			private Double priceEach;
			
			public Double getPriceEach() {
				return priceEach;
			}
			public void setPriceEach(Double priceEach) {
				this.priceEach = priceEach;
			}
		
		
		
			
		
		
		
		
		
		
		
		
		
		
		
		
			
		
		
		
		
		
		
		
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
				@Min(10)
			private Integer quantityOrdered;
			
			public Integer getQuantityOrdered() {
				return quantityOrdered;
			}
			public void setQuantityOrdered(Integer quantityOrdered) {
				this.quantityOrdered = quantityOrdered;
			}
		
		
		
		
			
		
		
		
		
		
		
		
	

	

//Code between start and end will not be removed during generation.
//Start of user code for this entity
//End of user code
}
