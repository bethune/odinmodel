package com.vladolium.odinmodel.specifications;

import org.springframework.data.jpa.domain.Specification;
import com.vladolium.odinmodel.model.*;

public class ProductLinesSpecification {

	public static Specification<ProductLines> getProductLinesByProductLine(String productLine) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.like(criteriaBuilder.lower(root.get("productLine")), "%" + productLine.toLowerCase() + "%");
	    };
	}
	public static Specification<ProductLines> getProductLinesByImage(Blob image) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.equal(root.get("image"), image);
	    };
	}
	public static Specification<ProductLines> getProductLinesByTextDescription(Clob textDescription) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.equal(root.get("textDescription"), textDescription);
	    };
	}
	
	

/*Code between start and end will not be removed during generation.*/
//Start of user code for this specification
//End of user code
}
