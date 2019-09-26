

package com.vladolium.odinmodel.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

@Entity
@Getter
@Setter
public class Gifts {




@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id; 
















@NotNull
@Column(unique=true)
private String giftName; 






public enum GiftType {
	FREE, 
	PLATINUM, 
	LIMITED, 
}
@NotNull
@Enumerated(javax.persistence.EnumType.STRING) // --obligatory for saving the value as string, not int
private GiftType giftType; 









@NotNull
private Boolean isActive; 








//Code between start and end will not be removed during generation.
//Start of user code for this entity
//End of user code

}





