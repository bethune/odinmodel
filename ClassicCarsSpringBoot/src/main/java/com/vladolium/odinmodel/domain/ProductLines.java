

package com.vladolium.odinmodel.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

@Entity
public class ProductLines {






@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Getter
@Setter
private Long id; 

















@Getter
@Setter
private String htmlDescription; 
@NotNull
@Getter
@Setter
private String textDescription; 
@NotNull
@Getter
@Setter
private String productLine; 

































//Code between start and end will not be removed during generation.
//Start of user code for this entity
//End of user code

}





