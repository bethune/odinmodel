package com.vladolium.odinmodel.config;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class PageNavigation implements Serializable{

	private static final long serialVersionUID = 1L;

	public String goToHome(){
	    return "home?faces-redirect=true";
	}


	public String goToEmployees(){
	    return "employees?faces-redirect=true";
	}

	public String goToPayments(){
	    return "payments?faces-redirect=true";
	}

	public String goToReviews(){
	    return "reviews?faces-redirect=true";
	}

	public String goToGifts(){
	    return "gifts?faces-redirect=true";
	}

	public String goToOffices(){
	    return "offices?faces-redirect=true";
	}

	public String goToOrders(){
	    return "orders?faces-redirect=true";
	}

	public String goToProducts(){
	    return "products?faces-redirect=true";
	}

	public String goToCustomers(){
	    return "customers?faces-redirect=true";
	}

	public String goToProductLines(){
	    return "productLines?faces-redirect=true";
	}

	public String goToOrderDetails(){
	    return "orderDetails?faces-redirect=true";
	}

//Code between start and end will not be removed during generation.
//Start of user code for this view
//End of user code
}
