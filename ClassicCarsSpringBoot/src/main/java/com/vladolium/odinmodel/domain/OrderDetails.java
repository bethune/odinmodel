
package com.vladolium.odinmodel.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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
    @Min(10)
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
    @DecimalMin("20.00")
    @DecimalMax("300.00")
    private Double priceEach;

    public Double getPriceEach() {
	return priceEach;
    }

    public void setPriceEach(Double priceEach) {
	this.priceEach = priceEach;
    }

    @ManyToOne
    @JoinColumn(name = "products_id")
    private Products products;

    public Products getProducts() {
	return products;
    }

    public void setProducts(Products products) {
	this.products = products;
    }

    @OneToOne
    @JoinColumn(name = "orders_id")
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
