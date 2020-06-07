package com.vladolium.odinmodel.specifications;

import org.springframework.data.jpa.domain.Specification;
import com.vladolium.odinmodel.model.*;

public class GiftsSpecification {

	public static Specification<Gifts> getGiftsByIsExpired(Boolean isExpired) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.equal(root.get("isExpired"), isExpired);
	    };
	}
	public static Specification<Gifts> getGiftsByExpiresOn(DateTime expiresOn) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.equal(root.get("expiresOn"), expiresOn);
	    };
	}
	public static Specification<Gifts> getGiftsByGiftName(String giftName) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.like(criteriaBuilder.lower(root.get("giftName")), "%" + giftName.toLowerCase() + "%");
	    };
	}
	public static Specification<Gifts> getGiftsByGiftType(GiftType giftType) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.equal(root.get("giftType"), giftType);
	    };
	}
	public static Specification<Gifts> getGiftsByBeginsOn(DateTime beginsOn) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.equal(root.get("beginsOn"), beginsOn);
	    };
	}
	
	@ManyToMany
	@JoinTable(name="gifts_customers", 
		joinColumns = @JoinColumn(name = "gifts_id"), 
		inverseJoinColumns = @JoinColumn(name = "customers_id"))
	private Set<Customers> customersSet = new HashSet<>();
	
	public Set<Customers> getCustomersSet() {
		return customersSet;
	}
	public void setCustomersSet(Set<Customers> customersSet) {
		this.customersSet = customersSet;
	}

/*Code between start and end will not be removed during generation.*/
//Start of user code for this specification
//End of user code
}
