package com.vladolium.odinmodel.specifications;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import com.vladolium.odinmodel.model.*;

public class CustomersSpecification {

	public static Specification<Customers> getCustomersByCity(String city) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.like(criteriaBuilder.lower(root.get("city")), "%" + city.toLowerCase() + "%");
	    };
	}
	public static Specification<Customers> getCustomersByPhone(String phone) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.like(criteriaBuilder.lower(root.get("phone")), "%" + phone.toLowerCase() + "%");
	    };
	}
	public static Specification<Customers> getCustomersByAddressLine2(String addressLine2) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.like(criteriaBuilder.lower(root.get("addressLine2")), "%" + addressLine2.toLowerCase() + "%");
	    };
	}
	public static Specification<Customers> getCustomersByFirstName(String firstName) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.like(criteriaBuilder.lower(root.get("firstName")), "%" + firstName.toLowerCase() + "%");
	    };
	}
	public static Specification<Customers> getCustomersByCreditLimit(Double creditLimit) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.equal(root.get("creditLimit"), creditLimit);
	    };
	}
	public static Specification<Customers> getCustomersByCustomerName(String customerName) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.like(criteriaBuilder.lower(root.get("customerName")), "%" + customerName.toLowerCase() + "%");
	    };
	}
	public static Specification<Customers> getCustomersByAddressLine1(String addressLine1) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.like(criteriaBuilder.lower(root.get("addressLine1")), "%" + addressLine1.toLowerCase() + "%");
	    };
	}
	public static Specification<Customers> getCustomersByCountry(String country) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.like(criteriaBuilder.lower(root.get("country")), "%" + country.toLowerCase() + "%");
	    };
	}
	public static Specification<Customers> getCustomersByLastName(String lastName) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.like(criteriaBuilder.lower(root.get("lastName")), "%" + lastName.toLowerCase() + "%");
	    };
	}
	public static Specification<Customers> getCustomersByState(String state) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.like(criteriaBuilder.lower(root.get("state")), "%" + state.toLowerCase() + "%");
	    };
	}
	public static Specification<Customers> getCustomersByPostalCode(String postalCode) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.like(criteriaBuilder.lower(root.get("postalCode")), "%" + postalCode.toLowerCase() + "%");
	    };
	}
	
	//many to one
	public static Specification<Customers> getCustomersByEmployeesId(Long employeesId) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.equal(root.get("employees").get("id"),  employeesId);
	    };
	}
	
	//one to many
	public static Specification<Customers> getCustomersByReviews(List<Reviews> reviewsList) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.in(root.get("reviewsList")).value(reviewsList);
	    };
	}

/*Code between start and end will not be removed during generation.*/
//Start of user code for this specification
//End of user code
}