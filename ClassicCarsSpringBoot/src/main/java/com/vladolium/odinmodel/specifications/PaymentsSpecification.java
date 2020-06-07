package com.vladolium.odinmodel.specifications;

import org.springframework.data.jpa.domain.Specification;
import com.vladolium.odinmodel.model.*;

public class PaymentsSpecification {

	public static Specification<Payments> getPaymentsByCheckNumber(String checkNumber) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.like(criteriaBuilder.lower(root.get("checkNumber")), "%" + checkNumber.toLowerCase() + "%");
	    };
	}
	public static Specification<Payments> getPaymentsByPaymentDate(Date paymentDate) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.equal(root.get("paymentDate"), paymentDate);
	    };
	}
	public static Specification<Payments> getPaymentsByAmount(Double amount) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.equal(root.get("amount"), amount);
	    };
	}
	public static Specification<Payments> getPaymentsByPaymentTimestamp(Instant paymentTimestamp) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.equal(root.get("paymentTimestamp"), paymentTimestamp);
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
