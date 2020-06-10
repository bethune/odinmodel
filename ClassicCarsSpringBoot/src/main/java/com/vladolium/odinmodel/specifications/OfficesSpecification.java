package com.vladolium.odinmodel.specifications;

import org.springframework.data.jpa.domain.Specification;
import com.vladolium.odinmodel.model.*;

public class OfficesSpecification {

	public static Specification<Offices> getOfficesByAddressLine1(String addressLine1) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.like(criteriaBuilder.lower(root.get("addressLine1")), "%" + addressLine1.toLowerCase() + "%");
	    };
	}
	public static Specification<Offices> getOfficesByAddressLine2(String addressLine2) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.like(criteriaBuilder.lower(root.get("addressLine2")), "%" + addressLine2.toLowerCase() + "%");
	    };
	}
	public static Specification<Offices> getOfficesByCountry(String country) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.like(criteriaBuilder.lower(root.get("country")), "%" + country.toLowerCase() + "%");
	    };
	}
	public static Specification<Offices> getOfficesByPhone(String phone) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.like(criteriaBuilder.lower(root.get("phone")), "%" + phone.toLowerCase() + "%");
	    };
	}
	public static Specification<Offices> getOfficesByState(String state) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.like(criteriaBuilder.lower(root.get("state")), "%" + state.toLowerCase() + "%");
	    };
	}
	public static Specification<Offices> getOfficesByTerritory(String territory) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.like(criteriaBuilder.lower(root.get("territory")), "%" + territory.toLowerCase() + "%");
	    };
	}
	public static Specification<Offices> getOfficesByPostalCode(String postalCode) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.like(criteriaBuilder.lower(root.get("postalCode")), "%" + postalCode.toLowerCase() + "%");
	    };
	}
	public static Specification<Offices> getOfficesByCity(String city) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.like(criteriaBuilder.lower(root.get("city")), "%" + city.toLowerCase() + "%");
	    };
	}
	
	

/*Code between start and end will not be removed during generation.*/
//Start of user code for this specification
//End of user code
}