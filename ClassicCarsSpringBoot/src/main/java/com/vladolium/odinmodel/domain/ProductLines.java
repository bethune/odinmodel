

package com.vladolium.odinmodel.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

@Entity
@Getter
@Setter
public class ProductLines {






@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id; 

















private String htmlDescription; 
@NotNull
private String textDescription; 
@NotNull
private String productLine; 

























//Code between start and end will not be removed during generation.
//Start of user code for this entity
//End of user code

}





