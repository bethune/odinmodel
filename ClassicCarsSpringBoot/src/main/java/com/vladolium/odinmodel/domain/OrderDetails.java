

package com.vladolium.odinmodel.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.*;
import lombok.*;

@Entity
public class OrderDetails {


@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Getter
@Setter
private Long id; 










@NotNull
@Getter
@Setter
private Integer quantityOrdered; 

@NotNull
@Getter
@Setter
private Integer orderLineNumber; 









@NotNull
@Getter
@Setter
private Double priceEach; 







































































@ManyToOne
@JoinColumn(name="products_id")
@Getter
@Setter
private Products products;



@OneToOne
@JoinColumn(name="orders_id")
@Getter
@Setter
private Orders orders;









//Code between start and end will not be removed during generation.
//Start of user code for this entity
//End of user code

}





