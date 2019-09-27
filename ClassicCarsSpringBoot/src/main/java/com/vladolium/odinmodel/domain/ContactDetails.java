



package com.vladolium.odinmodel.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

@MappedSuperclass
public abstract class ContactDetails {





























@NotNull
@Getter
@Setter
private String postalCode; 
@NotNull
@Getter
@Setter
private String phone; 
@Getter
@Setter
private String adressLine2; 
@NotNull
@Getter
@Setter
private String state; 
@NotNull
@Getter
@Setter
private String adressLine1; 
@NotNull
@Getter
@Setter
private String country; 
@NotNull
@Getter
@Setter
private String city; 





























//Code between start and end will not be removed during generation.
//Start of user code for this abstract class
//End of user code

}



