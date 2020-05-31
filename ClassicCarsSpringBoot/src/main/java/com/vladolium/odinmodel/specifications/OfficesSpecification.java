package com.vladolium.odinmodel.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.vladolium.odinmodel.model.Offices;

public class OfficesSpecification {

	public static Specification<Offices> getOfficesByCity(String city) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("city".toLowerCase()), city.toLowerCase());
        };
    }
	
	public static Specification<Offices> getOfficesByPhone(String phone) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("phone".toLowerCase()), phone.toLowerCase());
        };
    }
	
	public static Specification<Offices> getOfficesByAddressLine1(String addressLine1) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("addressLine1".toLowerCase()), addressLine1.toLowerCase());
        };
    }
	
	public static Specification<Offices> getOfficesByAddressLine2(String addressLine2) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("addressLine2".toLowerCase()), addressLine2.toLowerCase());
        };
    }
	
	public static Specification<Offices> getOfficesByTerritory(String territory) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("territory".toLowerCase()), territory.toLowerCase());
        };
    }
	
	public static Specification<Offices> getOfficesByCountry(String country) {
		
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("country")), "%" + country.toLowerCase() + "%");
        };
    }
	
	public static Specification<Offices> getOfficesByState(String state) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("state".toLowerCase()), state.toLowerCase());
        };
    }
	
	public static Specification<Offices> getOfficesByPostalCode(String postalCode) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("postalCode".toLowerCase()), postalCode.toLowerCase());
        };
    }

//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code
}
