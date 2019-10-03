





package com.vladolium.odinmodel.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.*;
import lombok.*;

@Entity
public class Customers extends ContactDetails {



@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Getter
@Setter
private Long id; 



















@NotNull
@Getter
@Setter
private Double creditLimit; 







@NotNull
@Getter
@Setter
private String firstName; 
@NotNull
@Getter
@Setter
private String lastName; 
@NotNull
@Column(unique=true)
@Getter
@Setter
private String customerName; 











































































@ManyToOne
@JoinColumn(name="employees_id")
@Getter
@Setter
private Employees employees;









@OneToMany
@JoinColumn(name="customers_id")
@Getter
@Setter
private List<Reviews> reviewsList;



//Code between start and end will not be removed during generation.
//Start of user code for this inheriting entity
//End of user code

}

