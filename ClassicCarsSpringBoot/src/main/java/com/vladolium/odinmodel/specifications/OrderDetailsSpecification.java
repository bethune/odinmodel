package com.vladolium.odinmodel.specifications;

import org.springframework.data.jpa.domain.Specification;
import com.vladolium.odinmodel.model.*;

public class OrderDetailsSpecification {

	public static Specification<OrderDetails> getOrderDetailsByOrderLineNumber(Integer orderLineNumber) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.equal(root.get("orderLineNumber"), orderLineNumber);
	    };
	}
	public static Specification<OrderDetails> getOrderDetailsByQuantityOrdered(Integer quantityOrdered) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.equal(root.get("quantityOrdered"), quantityOrdered);
	    };
	}
	public static Specification<OrderDetails> getOrderDetailsByPriceEach(Double priceEach) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.equal(root.get("priceEach"), priceEach);
	    };
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

/*Code between start and end will not be removed during generation.*/
//Start of user code for this specification
//End of user code
}
