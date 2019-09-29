

package com.vladolium.odinmodel.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.*;
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











@NotNull
@DateTimeFormat(pattern = "yyyy-MM-dd") //for database
//@JsonFormat(pattern = "yyyy-MM-dd") //for frontend
@Getter
@Setter
private LocalDate reviewDate; 











@NotNull
@DateTimeFormat(pattern = "HH:mm") //for database
//@JsonFormat(pattern = "HH:mm") //for frontend
@Getter
@Setter
private LocalTime reviewTime; 









































//Code between start and end will not be removed during generation.
//Start of user code for this entity
//End of user code

}





