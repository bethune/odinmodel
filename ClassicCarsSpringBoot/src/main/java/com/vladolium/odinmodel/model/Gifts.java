package com.vladolium.odinmodel.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.*;
import java.util.*;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Gifts {

	
		
			
		
	
	
			private Long id;
			
			public Long getId() {
				return id;
			}
			public void setId(Long id) {
				this.id = id;
			}
			
		
			
		
	
	
		
			
		
	
	
		
			
		
	
	
		
			
		
	
	
		
			
		
	
	
		
				public enum GiftType {
					FREE,
					PLATINUM,
					LIMITED,
				}
				@Enumerated(javax.persistence.EnumType.STRING) // --obligatory for saving the value as string, not int
				private GiftType giftType;
				
				public GiftType getGiftType() {
					return giftType;
				}
				public void setGiftType(GiftType giftType) {
					this.giftType = giftType;
				}
				
			
		
	
	
	


//Code between start and end will not be removed during generation.
//Start of user code for this entity
	//End of user code
}
