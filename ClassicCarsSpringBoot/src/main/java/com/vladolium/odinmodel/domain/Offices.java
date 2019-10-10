

package com.vladolium.odinmodel.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.*;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.*;

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

	
