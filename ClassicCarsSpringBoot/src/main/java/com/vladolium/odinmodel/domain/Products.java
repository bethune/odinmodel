

package com.vladolium.odinmodel.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

@Entity
@Getter
@Setter
public class Products {



@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id; 
















@NotNull
private Integer quantityInStock; 





@NotNull
		private Double buyPrice; 




@NotNull
		private Double MSRP; 







@NotNull
private String productName; 
@NotNull
private String productScale; 
@NotNull
private String productDescription; 
@NotNull
private String productVendor; 
@NotNull
@Column(unique=true)
private String productCode; 

































//Code between start and end will not be removed during generation.
//Start of user code for this entity
//End of user code

}





