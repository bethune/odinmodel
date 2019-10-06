
package com.vladolium.odinmodel.domain;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.*;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.*;


@Entity
public class ProductLines {

	
	
	
	
	
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
	private String productLine; 
	
	public String getProductLine() {
		return productLine;
	}
	
	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@NotNull
	@Lob
	private String textDescription; 
	
	public String getTextDescription() {
		return textDescription;
	}
	
	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}
	
	
	
	
	
	@Lob
	private byte[] image; 
	
	public byte[] getImage() {
		return image;
	}
	
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	//Code between start and end will not be removed during generation.
	//Start of user code for this entity
//End of user code

}

	



