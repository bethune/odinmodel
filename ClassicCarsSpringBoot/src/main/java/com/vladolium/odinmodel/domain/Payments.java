

package com.vladolium.odinmodel.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.*;
import lombok.*;

@Entity
public class Payments {






@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Getter
@Setter
private Long id; 














@NotNull
@Getter
@Setter
private Double amount; 






@NotNull
@Getter
@Setter
private String checkNumber; 














@NotNull
@DateTimeFormat(pattern = "yyyy-MM-dd") //for database
//@JsonFormat(pattern = "yyyy-MM-dd") //for frontend
@Getter
@Setter
private LocalDate paymentDate; 





















//@JsonFormat(pattern = "yyyy-MM-dd HH:mm") //for frontend
@Getter
@Setter
private Instant paymentTimestamp = Instant.now(); 
































@ManyToOne
@JoinColumn(name="customers_id")
@Getter
@Setter
private Customers customers;












//Code between start and end will not be removed during generation.
//Start of user code for this entity
//End of user code

}





