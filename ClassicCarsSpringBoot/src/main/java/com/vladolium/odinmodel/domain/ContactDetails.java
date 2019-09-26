



package com.vladolium.odinmodel.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

@MappedSuperclass
@Getter
@Setter
public abstract class ContactDetails {





























@NotNull
private String adressLine1; 
@NotNull
private String country; 
@NotNull
private String state; 
private String adressLine2; 
@NotNull
private String postalCode; 
@NotNull
private String city; 
@NotNull
private String phone; 





























//Code between start and end will not be removed during generation.
//Start of user code for this abstract class
//End of user code

}



