
package com.vladolium.odinmodel.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    private Integer reportsTo;

    public Integer getReportsTo() {
	return reportsTo;
    }

    public void setReportsTo(Integer reportsTo) {
	this.reportsTo = reportsTo;
    }

    @NotNull
    @Size(max = 50)
    private String firstName;

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    @NotNull
    @Size(max = 100)
    private String email;

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    @NotNull
    @Size(max = 50)
    private String jobTitle;

    public String getJobTitle() {
	return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
	this.jobTitle = jobTitle;
    }

    @NotNull
    @Size(max = 10)
    private String extension;

    public String getExtension() {
	return extension;
    }

    public void setExtension(String extension) {
	this.extension = extension;
    }

    @NotNull
    @Size(max = 50)
    private String lastName;

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    @NotNull
    private Boolean isActive;

    public Boolean getIsActive() {
	return isActive;
    }

    public void setIsActive(Boolean isActive) {
	this.isActive = isActive;
    }

    @ManyToOne
    @JoinColumn(name = "offices_id")
    private Offices offices;

    public Offices getOffices() {
	return offices;
    }

    public void setOffices(Offices offices) {
	this.offices = offices;
    }

//Code between start and end will not be removed during generation.
//Start of user code for this entity
//End of user code
}
