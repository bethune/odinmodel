package com.vladolium.odinmodel.wrapperRequest;

import com.vladolium.odinmodel.domain.Employees;
import com.vladolium.odinmodel.domain.Offices;

public class OfficesEmployees {

    private Offices offices;

    private Employees employees;

    public Offices getOffices() {
	return offices;
    }

    public void setOffices(Offices offices) {
	this.offices = offices;
    }

    public Employees getEmployees() {
	return employees;
    }

    public void setEmployees(Employees employees) {
	this.employees = employees;
    }

}
