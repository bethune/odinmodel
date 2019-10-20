
package com.vladolium.odinmodel.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    @Size(max = 50)
    private String productLine;

    public String getProductLine() {
	return productLine;
    }

    public void setProductLine(String productLine) {
	this.productLine = productLine;
    }

    @NotNull
    @Size(max = 4000)
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
