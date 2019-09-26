

package com.vladolium.odinmodel.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

@Entity
@Getter
@Setter
public class Customers {



@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id; 











@NotNull
		private Double creditLimit; 



@NotNull
@Column(unique=true)
private String customerName; 





















//Code between start and end will not be removed during generation.
//Start of user code for this entity
//End of user code

}





