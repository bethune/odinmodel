package com.vladolium.odinmodel.view;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.*;
//import org.springframework.format.annotation.*;
import java.time.*;
import java.util.*;
import java.io.Serializable;
import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Payments;
import com.vladolium.odinmodel.model.Payments.*;
import com.vladolium.odinmodel.service.PaymentsService;
import com.vladolium.odinmodel.service.*;
import com.vladolium.odinmodel.wrapper.*;

@Named
@ViewScoped
public class PaymentsView implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private PaymentsService paymentsService;

	
	private Payments payments;
	
	public Payments createOne() {
		return paymentsService.createUpdate(payments);
	}
	
	
	public Payments updateOneById(Long id) {
		Payments current = paymentsService.readOneById(id);
		current.setCustomers(payments.getCustomers());
		
		
		current.setAmount(payments.getAmount());
		
		current.setPaymentDate(payments.getPaymentDate());
		
		current.setCheckNumber(payments.getCheckNumber());
		
		current.setPaymentTimestamp(payments.getPaymentTimestamp());
					
		return paymentsService.createUpdate(current);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Payments readOneById(Long id) {
		return paymentsService.readOneById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	public Iterable<Payments> readAll() {
		return paymentsService.readAll();
	}
	
	public Page<Payments> readAllPagination(
		Integer pageNumber,
		Integer perPageNumber
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return paymentsService.readAllPagination(page);
	}
	
	
	public Iterable<Payments> search(
		
		
		
		
		Long customersId,
		
		
		
		
		
		
		
		Double amount,
		LocalDate paymentDate,
		String checkNumber,
		Instant paymentTimestamp
		
	) {
		return paymentsService.search(
			
			
			
			
			customersId,
			
			
			
			
			
			
			
			amount,
			paymentDate,
			checkNumber,
			paymentTimestamp
			
		);
	}
	
	public Page<Payments> searchPagination(
		Integer pageNumber,
		Integer perPageNumber,
		
		
		
		
		Long customersId,
		
		
		
		
		
		
		
		Double amount,
		LocalDate paymentDate,
		String checkNumber,
		Instant paymentTimestamp
		
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
	
		return paymentsService.searchPagination(
			page,
			
			
			
			
			customersId,
			
			
			
			
			
			
			
			amount,
			paymentDate,
			checkNumber,
			paymentTimestamp
			
		);
	}
	public void deleteOneById(Long id) {
		paymentsService.deleteOneById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this view
//End of user code
}
