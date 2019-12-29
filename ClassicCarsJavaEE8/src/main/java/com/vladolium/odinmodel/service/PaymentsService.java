package com.vladolium.odinmodel.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.inject.Inject;
import javax.annotation.PostConstruct;
import com.vladolium.odinmodel.model.*;
import java.time.*;
import java.util.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.querydsl.*;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import com.querydsl.core.BooleanBuilder;
import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Payments;
import com.vladolium.odinmodel.model.Payments.*;
import com.vladolium.odinmodel.repository.*;
import com.vladolium.odinmodel.repository.PaymentsRepository;
import com.vladolium.odinmodel.wrapper.*;

@Stateless
public class PaymentsService {

 	@PersistenceContext
    private EntityManager em;

	private PaymentsRepository paymentsRepository;
	
	@PostConstruct
	private void init() {
		RepositoryFactorySupport factory = new JpaRepositoryFactory(em);
		this.paymentsRepository = factory.getRepository(PaymentsRepository.class);
	}

	// covers create, update and update with IRIC
	public Payments createUpdate(Payments payments) {
		return paymentsRepository.save(payments);
	}
	
	
	public Payments readOneById(Long id) {
		return paymentsRepository.getOne(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	public Iterable<Payments> readAll() {
		return paymentsRepository.findAll();
	}
	
	public Page<Payments> readAllPagination(Pageable page) {
		return paymentsRepository.findAll(page);
	}
	
	
	
	
	
	public Iterable<Payments> readAllByCustomersId(Long customersId) {
		return paymentsRepository.findByCustomersIdEquals(customersId);
	}
	
	public Page<Payments> readAllByCustomersId(Long customersId, Pageable page) {
		return paymentsRepository.findByCustomersIdEquals(customersId, page);
	}
	
	
	
	
	
	
	
	
	
	
	public Iterable<Payments> readAllByCustomersCustomerName(String customersCustomerName) {
		return paymentsRepository.findByCustomersCustomerNameEquals(customersCustomerName);
	}
	
	public Page<Payments> readAllByCustomersCustomerName(String customersCustomerName, Pageable page) {
		return paymentsRepository.findByCustomersCustomerNameEquals(customersCustomerName, page);
	}
	
	
	
	
	
	
	
	
	
	
	public Iterable<Payments> search(
		
		
		
		
		Long customersId,
		
		
		
		
		
		
		
		Double amount,
		LocalDate paymentDate,
		String checkNumber,
		Instant paymentTimestamp
		
	) {
		BooleanBuilder where = dynamicWhere(
			
			
			
			
			customersId,
			
			
			
			
			
			
			
			amount,
			paymentDate,
			checkNumber,
			paymentTimestamp
				
		);
		return paymentsRepository.findAll(where);
	}
	
	public Page<Payments> searchPagination(
		Pageable page,
		
		
		
		
		Long customersId,
		
		
		
		
		
		
		
		Double amount,
		LocalDate paymentDate,
		String checkNumber,
		Instant paymentTimestamp
		
	) {
		BooleanBuilder where = dynamicWhere(
			
			
			
			
			customersId,
			
			
			
			
			
			
			
			amount,
			paymentDate,
			checkNumber,
			paymentTimestamp
			
		);
		return paymentsRepository.findAll(where, page);
	}
	
	public BooleanBuilder dynamicWhere(
		
		
		
		
		Long customersId,
		
		
		
		
		
		
		
		Double amount,
		LocalDate paymentDate,
		String checkNumber,
		Instant paymentTimestamp
		
	) {
		QPayments qPayments = QPayments.payments;
	
		BooleanBuilder where = new BooleanBuilder();
	
		
		
		
		
		if (customersId != null) {
			where.and(qPayments.customers.id.eq(customersId));
		}
		
		
		
		
		
		
		
		if (amount != null) {
			where.and(qPayments.amount.eq(amount));
		}
		if (paymentDate != null) {
			where.and(qPayments.paymentDate.eq(paymentDate));
		}
		if (checkNumber != null) {
			where.and(qPayments.checkNumber.containsIgnoreCase(checkNumber));
		}
		if (paymentTimestamp != null) {
			where.and(qPayments.paymentTimestamp.eq(paymentTimestamp));
		}
		
	
		return where;
	}
	
	public void deleteOneById(Long id) {
	    paymentsRepository.deleteById(id);
	}
	
	
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this service
//End of user code
}
