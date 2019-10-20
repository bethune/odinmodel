
package com.vladolium.odinmodel.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.*;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.*;

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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@NotNull
	private Boolean isExpired;
	
	public Boolean getIsExpired() {
		return isExpired;
	}
	public void setIsExpired(Boolean isExpired) {
		this.isExpired = isExpired;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@ManyToMany
	@JoinTable(name="gifts_customers", 
		joinColumns = @JoinColumn(name = "gifts_id"), 
		inverseJoinColumns = @JoinColumn(name = "customers_id"))
	private Set<Customers> customersSet = new HashSet<>();
	
	public Set<Customers> getCustomersSet() {
		return customersSet;
	}
	public void setCustomersSet(Set<Customers> customersSet) {
		this.customersSet = customersSet;
	}
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this entity
//End of user code
}


	
