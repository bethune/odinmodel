

package com.vladolium.odinmodel.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.*;
import lombok.*;

@Entity
public class Gifts {


@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Getter
@Setter
private Long id; 



























@NotNull
@Column(unique=true)
@Getter
@Setter
private String giftName; 





public enum GiftType {
	FREE, 
	PLATINUM, 
	LIMITED, 
}
@NotNull
@Enumerated(javax.persistence.EnumType.STRING) // --obligatory for saving the value as string, not int
@Getter
@Setter
private GiftType giftType; 




















@NotNull
@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") //for database
//@JsonFormat(pattern = "yyyy-MM-dd HH:mm") //for frontend
@Getter
@Setter
private LocalDateTime beginsOn; 

@NotNull
@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") //for database
//@JsonFormat(pattern = "yyyy-MM-dd HH:mm") //for frontend
@Getter
@Setter
private LocalDateTime expiresOn; 

























@NotNull
@Getter
@Setter
private Boolean isExpired; 





















@ManyToMany
@JoinTable(name="gifts_customers", 
	joinColumns = @JoinColumn(name = "gifts_id"), 
	inverseJoinColumns = @JoinColumn(name = "customers_id"))
@Getter
@Setter
private Set<Customers> customersSet = new HashSet<>();






//Code between start and end will not be removed during generation.
//Start of user code for this entity
//End of user code

}





