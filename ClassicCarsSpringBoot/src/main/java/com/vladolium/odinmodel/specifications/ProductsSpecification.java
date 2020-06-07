package com.vladolium.odinmodel.specifications;

import org.springframework.data.jpa.domain.Specification;
import com.vladolium.odinmodel.model.*;

public class ProductsSpecification {

	public static Specification<Products> getProductsByProductName(String productName) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.like(criteriaBuilder.lower(root.get("productName")), "%" + productName.toLowerCase() + "%");
	    };
	}
	public static Specification<Products> getProductsByQuantityInStock(Integer quantityInStock) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.equal(root.get("quantityInStock"), quantityInStock);
	    };
	}
	public static Specification<Products> getProductsByProductVendor(String productVendor) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.like(criteriaBuilder.lower(root.get("productVendor")), "%" + productVendor.toLowerCase() + "%");
	    };
	}
	public static Specification<Products> getProductsByProductDescription(Clob productDescription) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.equal(root.get("productDescription"), productDescription);
	    };
	}
	public static Specification<Products> getProductsByBuyPrice(Double buyPrice) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.equal(root.get("buyPrice"), buyPrice);
	    };
	}
	public static Specification<Products> getProductsByProductScale(String productScale) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.like(criteriaBuilder.lower(root.get("productScale")), "%" + productScale.toLowerCase() + "%");
	    };
	}
	public static Specification<Products> getProductsByMsrp(Double msrp) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.equal(root.get("msrp"), msrp);
	    };
	}
	public static Specification<Products> getProductsByProductCode(String productCode) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.like(criteriaBuilder.lower(root.get("productCode")), "%" + productCode.toLowerCase() + "%");
	    };
	}
	
	@ManyToOne
	@JoinColumn(name="productLines_id")
	private ProductLines productLines;
	
	public ProductLines getProductLines() {
		return productLines;
	}
	public void setProductLines(ProductLines productLines) {
		this.productLines = productLines;
	}

/*Code between start and end will not be removed during generation.*/
//Start of user code for this specification
//End of user code
}
