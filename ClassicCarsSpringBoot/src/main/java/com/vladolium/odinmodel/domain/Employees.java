

package com.vladolium.odinmodel.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

@Entity
@Getter
@Setter
public class Employees {







@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id; 





@NotNull
private Integer reportsTo; 














@NotNull
private String extension; 
@NotNull
private String email; 
@NotNull
private String jobTitle; 





















@NotNull
private Boolean isActive; 






//Code between start and end will not be removed during generation.
//Start of user code for this entity
//End of user code

}





