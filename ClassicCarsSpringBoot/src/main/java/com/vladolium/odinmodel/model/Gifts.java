package com.vladolium.odinmodel.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.*;
import java.util.*;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Gifts {

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
	@Column(unique=true)
	private String giftName;
	
	public String getGiftName() {
		return giftName;
	}
	public void setGiftName(String giftName) {
		this.giftName = giftName;
	}
	@NotNull
	private Boolean isExpired;
	
	public Boolean getIsExpired() {
		return isExpired;
	}
	public void setIsExpired(Boolean isExpired) {
		this.isExpired = isExpired;
	}
	
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") //for database
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm") //for frontend
	private LocalDateTime expiresOn;
	
	public LocalDateTime getExpiresOn() {
		return expiresOn;
	}
	public void setExpiresOn(LocalDateTime expiresOn) {
		this.expiresOn = expiresOn;
	}
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") //for database
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm") //for frontend
	private LocalDateTime beginsOn;
	
	public LocalDateTime getBeginsOn() {
		return beginsOn;
	}
	public void setBeginsOn(LocalDateTime beginsOn) {
		this.beginsOn = beginsOn;
	}
	
	public enum GiftType {
		FREE,
		PLATINUM,
		LIMITED,
		
	}
	
	@NotNull
	@Enumerated(javax.persistence.EnumType.STRING) // --obligatory for saving the value as string, not int
	private GiftType giftType;
	
	public GiftType getGiftType() {
		return giftType;
	}
	public void setGiftType(GiftType giftType) {
		this.giftType = giftType;
	}

/*Code between start and end will not be removed during generation.*/
//Start of user code for this entity
//End of user code
}
