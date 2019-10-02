





package com.vladolium.odinmodel.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.*;
import lombok.*;

@Entity
public class Offices extends ContactDetails {



@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Getter
@Setter
private Long id; 











@NotNull
@Getter
@Setter
private String territory; 















































//Code between start and end will not be removed during generation.
//Start of user code for this inheriting entity
//End of user code

}

