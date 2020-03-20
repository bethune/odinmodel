package com.vladolium.odinmodel.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.*;
import java.util.*;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Offices extends ContactDetails {

	//Numerical fields ------------------------------------------------------------
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
	
	//Textual fields ------------------------------------------------------------
	
	@NotNull
	@Size(max=10)
	private String territory;
	
	public String getTerritory() {
		return territory;
	}
	public void setTerritory(String territory) {
		this.territory = territory;
	}
	
	
	
	//Logical fields ------------------------------------------------------------
	
	
	
	//Date and time fields ------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	//Binary fields ------------------------------------------------------------
		
/*Code between start and end will not be removed during generation.*/
//Start of user code for this inheriting entity
//End of user code
}
