package com.vladolium.odinmodel.view;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.data.domain.*;
//import org.springframework.format.annotation.*;
import java.time.*;
import java.util.*;
import java.io.Serializable;
import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Customers;
import com.vladolium.odinmodel.model.Customers.*;
import com.vladolium.odinmodel.service.CustomersService;
import com.vladolium.odinmodel.service.*;

@Named
@ViewScoped
public class CustomersView implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private CustomersService customersService;

	
	
	
	
	public Customers readOneById(Long id) {
		System.out.println("Testni ID u view je ======= " + id);
		return customersService.readOneById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public Customers readOneByCustomerName(String customerName) {
		return customersService.readOneByCustomerName(customerName);
	}
	
	
	
	
	
	
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code
}
