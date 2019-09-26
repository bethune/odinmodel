

package com.vladolium.odinmodel.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

@Entity
@Getter
@Setter
public class Orders {




@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id; 






















@NotNull
private String comments; 
@NotNull
private String status; 



























//Code between start and end will not be removed during generation.
//Start of user code for this entity
//End of user code

}





