package com.vladolium.odinmodel.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.*;
import java.util.*;

@Entity
public class Products {

	
	
	
	
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
	
	
	@NotNull
	private Integer quantityInStock;
	
	public Integer getQuantityInStock() {
		return quantityInStock;
	}
	public void setQuantityInStock(Integer quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	
	
	
	
	
	
	
	
	
	@NotNull
	private Double msrp;
	
	public Double getMsrp() {
		return msrp;
	}
	public void setMsrp(Double msrp) {
		this.msrp = msrp;
	}
	
	
	
	@NotNull
	@DecimalMin("10.00")
	private Double buyPrice;
	
	public Double getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}
	
	
	
	
	
	
	@NotNull
	@Column(unique=true)
	@Size(max=15)
	private String productCode;
	
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
	
	
	
	
	@NotNull
	@Size(max=70)
	private String productName;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	@NotNull
	@Size(max=10)
	private String productScale;
	
	public String getProductScale() {
		return productScale;
	}
	public void setProductScale(String productScale) {
		this.productScale = productScale;
	}
	
	@NotNull
	@Size(max=50)
	private String productVendor;
	
	public String getProductVendor() {
		return productVendor;
	}
	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@NotNull
	@Size(max=4000)
	@Lob
	private String productDescription;
	
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
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
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this entity
//End of user code
}
