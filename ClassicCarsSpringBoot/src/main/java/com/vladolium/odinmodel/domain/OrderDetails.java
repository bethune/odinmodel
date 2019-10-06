
package com.vladolium.odinmodel.domain;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.*;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.*;


@Entity
public class OrderDetails {

	
	
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
	private Integer quantityOrdered; 
	
	public Integer getQuantityOrdered() {
		return quantityOrdered;
	}
	
	public void setQuantityOrdered(Integer quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}
	
	@NotNull
	private Integer orderLineNumber; 
	
	public Integer getOrderLineNumber() {
		return orderLineNumber;
	}
	
	public void setOrderLineNumber(Integer orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}
	
	
	
	
	
	
	
	
	
	@NotNull
	private Double priceEach; 
	
	public Double getPriceEach() {
		return priceEach;
	}
	
	public void setPriceEach(Double priceEach) {
		this.priceEach = priceEach;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@ManyToOne
	@JoinColumn(name="products_id")
	private Products products;
	
	public Products getProducts() {
		return products;
	}
	
	public void setProducts(Products products) {
		this.products = products;
	}
	
	
	
	@OneToOne
	@JoinColumn(name="orders_id")
	private Orders orders;
	
	public Orders getOrders() {
		return orders;
	}
	
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	
	
	
	
	
	
	
	
	

	//Code between start and end will not be removed during generation.
	//Start of user code for this entity
//End of user code

}

	



