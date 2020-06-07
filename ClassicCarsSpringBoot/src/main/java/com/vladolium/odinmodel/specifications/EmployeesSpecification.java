package com.vladolium.odinmodel.specifications;

import org.springframework.data.jpa.domain.Specification;
import com.vladolium.odinmodel.model.*;

public class EmployeesSpecification {

	public static Specification<Employees> getEmployeesByLastName(String lastName) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.like(criteriaBuilder.lower(root.get("lastName")), "%" + lastName.toLowerCase() + "%");
	    };
	}
	public static Specification<Employees> getEmployeesByReportsTo(Integer reportsTo) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.equal(root.get("reportsTo"), reportsTo);
	    };
	}
	public static Specification<Employees> getEmployeesByExtension(String extension) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.like(criteriaBuilder.lower(root.get("extension")), "%" + extension.toLowerCase() + "%");
	    };
	}
	public static Specification<Employees> getEmployeesByEmail(String email) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.like(criteriaBuilder.lower(root.get("email")), "%" + email.toLowerCase() + "%");
	    };
	}
	public static Specification<Employees> getEmployeesByJobTitle(String jobTitle) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.like(criteriaBuilder.lower(root.get("jobTitle")), "%" + jobTitle.toLowerCase() + "%");
	    };
	}
	public static Specification<Employees> getEmployeesByFirstName(String firstName) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.like(criteriaBuilder.lower(root.get("firstName")), "%" + firstName.toLowerCase() + "%");
	    };
	}
	public static Specification<Employees> getEmployeesByIsActive(Boolean isActive) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.equal(root.get("isActive"), isActive);
	    };
	}
	
	@ManyToOne
	@JoinColumn(name="offices_id")
	private Offices offices;
	
	public Offices getOffices() {
		return offices;
	}
	public void setOffices(Offices offices) {
		this.offices = offices;
	}

/*Code between start and end will not be removed during generation.*/
//Start of user code for this specification
//End of user code
}
