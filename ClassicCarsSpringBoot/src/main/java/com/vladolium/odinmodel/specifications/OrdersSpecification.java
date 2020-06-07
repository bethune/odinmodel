package com.vladolium.odinmodel.specifications;

import org.springframework.data.jpa.domain.Specification;
import com.vladolium.odinmodel.model.*;

public class OrdersSpecification {

	public static Specification<Orders> getOrdersByStatus(String status) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.like(criteriaBuilder.lower(root.get("status")), "%" + status.toLowerCase() + "%");
	    };
	}
	public static Specification<Orders> getOrdersByOrderDate(Date orderDate) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.equal(root.get("orderDate"), orderDate);
	    };
	}
	public static Specification<Orders> getOrdersByComments(Clob comments) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.equal(root.get("comments"), comments);
	    };
	}
	public static Specification<Orders> getOrdersByRequiredDate(Date requiredDate) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.equal(root.get("requiredDate"), requiredDate);
	    };
	}
	public static Specification<Orders> getOrdersByShippedDate(Date shippedDate) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.equal(root.get("shippedDate"), shippedDate);
	    };
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
//Start of user code for this specification
//End of user code
}
