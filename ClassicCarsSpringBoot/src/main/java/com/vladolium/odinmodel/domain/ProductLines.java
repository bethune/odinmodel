

package com.vladolium.odinmodel.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.*;
import lombok.*;

@Entity
public class ProductLines {






@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Getter
@Setter
private Long id; 

















@Getter
@Setter
private String htmlDescription; 
@NotNull
@Getter
@Setter
private String textDescription; 
@NotNull
@Getter
@Setter
private String productLine; 















































@Lob
@Getter
@Setter
private byte[] image; 

















//Code between start and end will not be removed during generation.
//Start of user code for this entity
//End of user code

}





