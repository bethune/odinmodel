

package com.vladolium.odinmodel.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

@Entity
public class Orders {







@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Getter
@Setter
private Long id; 



















@NotNull
@Getter
@Setter
private String comments; 
@NotNull
@Getter
@Setter
private String status; 



































//Code between start and end will not be removed during generation.
//Start of user code for this entity
//End of user code

}





