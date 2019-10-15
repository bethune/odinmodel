
package com.vladolium.odinmodel.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Offices extends ContactDetails {

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
    @Size(max = 10)
    private String territory;

    public String getTerritory() {
	return territory;
    }

    public void setTerritory(String territory) {
	this.territory = territory;
    }

//Code between start and end will not be removed during generation.
//Start of user code for this inheriting entity
//End of user code
}
