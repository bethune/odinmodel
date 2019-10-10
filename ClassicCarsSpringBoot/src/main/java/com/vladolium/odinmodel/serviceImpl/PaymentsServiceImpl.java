package com.vladolium.odinmodel.serviceImpl;

import com.vladolium.odinmodel.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;
import java.time.*;
import java.util.*;
import com.vladolium.odinmodel.repository.PaymentsRepository;
import com.vladolium.odinmodel.service.PaymentsService;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Payments;
import com.vladolium.odinmodel.domain.Payments.*;
import com.querydsl.core.BooleanBuilder;

@Service
public class PaymentsServiceImpl implements PaymentsService {

	private PaymentsRepository paymentsRepository;

	@Autowired
	public void setPaymentsRepository(PaymentsRepository paymentsRepository) {
		this.paymentsRepository = paymentsRepository;
	}

	// covers create & update
	@Override
	public Payments createUpdate(Payments payments) {
		return paymentsRepository.save(payments);
	}
	
	
	
	
	@Override
	public Payments readOneById(Long id) {
		return paymentsRepository.getOne(id);
	}
	
	
	
	
	
	
	
	@Override
	public Iterable<Payments> readAll() {
		return paymentsRepository.findAll();
	}
	
	@Override
	public Page<Payments> readAllPagination(Pageable page) {
		return paymentsRepository.findAll(page);
	}
	@Override
	public Iterable<Payments> search(
		Long customersId,
		
		
		
		
		
		
		
		
		
		
		
		LocalDate paymentDate,
		Instant paymentTimestamp,
		Double amount,
		String checkNumber
		
	) {
		BooleanBuilder where = dynamicWhere(
			customersId,
			
			
			
			
			
			
			
			
			
			
			
			paymentDate,
			paymentTimestamp,
			amount,
			checkNumber
				
		);
		return paymentsRepository.findAll(where);
	}
	
	@Override
	public Page<Payments> searchPagination(
		Pageable page,
		Long customersId,
		
		
		
		
		
		
		
		
		
		
		
		LocalDate paymentDate,
		Instant paymentTimestamp,
		Double amount,
		String checkNumber
		
	) {
		BooleanBuilder where = dynamicWhere(
			customersId,
			
			
			
			
			
			
			
			
			
			
			
			paymentDate,
			paymentTimestamp,
			amount,
			checkNumber
			
		);
		return paymentsRepository.findAll(where, page);
	}
	
	public BooleanBuilder dynamicWhere(
		Long customersId,
		
		
		
		
		
		
		
		
		
		
		
		LocalDate paymentDate,
		Instant paymentTimestamp,
		Double amount,
		String checkNumber
		
	) {
		QPayments qPayments = QPayments.payments;
	
		BooleanBuilder where = new BooleanBuilder();
	
		if (customersId != null) {
			where.and(qPayments.customers.id.eq(customersId));
		}
		
		
		
		
		
		
		
		
		
		
		
		if (paymentDate != null) {
			where.and(qPayments.paymentDate.eq(paymentDate));
		}
		if (paymentTimestamp != null) {
			where.and(qPayments.paymentTimestamp.eq(paymentTimestamp));
		}
		if (amount != null) {
			where.and(qPayments.amount.eq(amount));
		}
		if (checkNumber != null) {
			where.and(qPayments.checkNumber.containsIgnoreCase(checkNumber));
		}
		
	
		return where;
	}
	
	
	
	
	
	@Override
	public void deleteOneById(Long id) {
		paymentsRepository.deleteById(id);
	}
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code
}
