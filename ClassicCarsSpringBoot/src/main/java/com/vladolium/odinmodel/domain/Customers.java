
package com.vladolium.odinmodel.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

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
    @Column(unique = true)
    @Getter
    @Setter
    private String customerName;
    @NotNull
    @Getter
    @Setter
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "employees_id")
    @Getter
    @Setter
    private Employees employees;

    @OneToMany
    @JoinColumn(name = "customers_id")
    @Getter
    @Setter
    private List<Reviews> reviewsList;

//Code between start and end will not be removed during generation.
//Start of user code for this inheriting entity
//End of user code

}
