package com.vladolium.odinmodel.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

@Entity
@Getter
@Setter
public class OrderDetails {


@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;



@NotNull
private Integer orderLineNumber;


@NotNull
private Integer quantityOrdered;





@NotNull
		private Double priceEach;
















//Start of user code entity
//End of user code

}

