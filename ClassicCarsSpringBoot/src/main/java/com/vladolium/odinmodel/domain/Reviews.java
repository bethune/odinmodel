

package com.vladolium.odinmodel.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

@Entity
public class Reviews {




@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Getter
@Setter
private Long id; 
















@NotNull
@Getter
@Setter
private String reviewText; 































//Code between start and end will not be removed during generation.
//Start of user code for this entity
//End of user code

}





