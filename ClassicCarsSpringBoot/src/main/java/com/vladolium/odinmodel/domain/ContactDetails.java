



package com.vladolium.odinmodel.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

@MappedSuperclass
@Getter
@Setter
public abstract class ContactDetails {





























@NotNull
private String postalCode; 
@NotNull
private String phone; 
private String adressLine2; 
@NotNull
private String state; 
@NotNull
private String adressLine1; 
@NotNull
private String country; 
@NotNull
private String city; 





























//Code between start and end will not be removed during generation.
//Start of user code for this abstract class
//End of user code

}



