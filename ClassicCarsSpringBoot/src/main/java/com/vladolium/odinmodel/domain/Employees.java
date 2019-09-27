

package com.vladolium.odinmodel.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

@Entity
public class Employees {







@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Getter
@Setter
private Long id; 





@NotNull
@Getter
@Setter
private Integer reportsTo; 














@NotNull
@Getter
@Setter
private String extension; 
@NotNull
@Getter
@Setter
private String email; 
@NotNull
@Getter
@Setter
private String jobTitle; 





















@NotNull
@Getter
@Setter
private Boolean isActive; 














//Code between start and end will not be removed during generation.
//Start of user code for this entity
//End of user code

}





