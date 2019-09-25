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
		private Double MSRP;






@NotNull
		private Double buyPrice;


















//Start of user code entity
//End of user code

}

