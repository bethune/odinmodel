

package com.vladolium.odinmodel.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
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
@Getter
@Setter
private Boolean isActive; 













//Code between start and end will not be removed during generation.
//Start of user code for this entity
//End of user code

}





