



package com.vladolium.odinmodel.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.*;
import lombok.*;

@MappedSuperclass
public abstract class ContactDetails {





























@NotNull
@Getter
@Setter
private String adressLine1; 
@NotNull
@Getter
@Setter
private String city; 
@NotNull
@Getter
@Setter
private String phone; 
@NotNull
@Getter
@Setter
private String country; 
@NotNull
@Getter
@Setter
private String state; 
@Getter
@Setter
private String adressLine2; 
@NotNull
@Getter
@Setter
private String postalCode; 


































































//Code between start and end will not be removed during generation.
//Start of user code for this abstract class
//End of user code

}



