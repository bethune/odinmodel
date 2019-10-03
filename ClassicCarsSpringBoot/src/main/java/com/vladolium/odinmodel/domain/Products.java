

package com.vladolium.odinmodel.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.*;
import lombok.*;

@Entity
public class Products {











@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Getter
@Setter
private Long id; 



@NotNull
@Getter
@Setter
private Integer quantityInStock; 
















@NotNull
@Getter
@Setter
private Double buyPrice; 

@NotNull
@Getter
@Setter
private Double MSRP; 







@NotNull
@Column(unique=true)
@Getter
@Setter
private String productCode; 
@NotNull
@Getter
@Setter
private String productVendor; 
@NotNull
@Getter
@Setter
private String productScale; 
@NotNull
@Getter
@Setter
private String productName; 


















































































@NotNull
@Lob
@Getter
@Setter
private String productDescription; 

















@ManyToOne
@JoinColumn(name="productLines_id")
@Getter
@Setter
private ProductLines productLines;












//Code between start and end will not be removed during generation.
//Start of user code for this entity
//End of user code

}





