package com.vladolium.odinmodel.specifications;

import org.springframework.data.jpa.domain.Specification;
import com.vladolium.odinmodel.model.*;

public class ReviewsSpecification {

	public static Specification<Reviews> getReviewsByReviewTime(Time reviewTime) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.equal(root.get("reviewTime"), reviewTime);
	    };
	}
	public static Specification<Reviews> getReviewsByReviewDate(Date reviewDate) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.equal(root.get("reviewDate"), reviewDate);
	    };
	}
	public static Specification<Reviews> getReviewsByReviewText(String reviewText) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.like(criteriaBuilder.lower(root.get("reviewText")), "%" + reviewText.toLowerCase() + "%");
	    };
	}
	
	

/*Code between start and end will not be removed during generation.*/
//Start of user code for this specification
//End of user code
}
