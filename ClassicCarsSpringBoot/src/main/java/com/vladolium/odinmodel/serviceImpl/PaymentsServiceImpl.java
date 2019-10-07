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
import static org.jooq.impl.DSL.*;

@Service
public class PaymentsServiceImpl implements PaymentsService {

	private final DSLContext jooq;

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
		
		
		
		
		
		
		
		
		
		
		Double amount,
		String checkNumber,
		LocalDate paymentDate,
		Instant paymentTimestamp
		
	) {
		Condition condition = dynamicCondition(
			
			
			Long customersId,
			
			
			
			
			
			
			
			
			
			
			amount,
			checkNumber,
			paymentDate,
			paymentTimestamp
		);
		return paymentsRepository.findAll(condition);
	}
	public Condition dynamicCondition(
		
		
		Long customersId,
		
		
		
		
		
		
		
		
		
		
		Double amount,
		String checkNumber,
		LocalDate paymentDate,
		Instant paymentTimestamp
		
	) {
		Condition condition = trueCondition();
	
	
	
		if (customersId != null) {
			condition.and(payments.customers.id.eq(customersId));
		}
	
	
	
	
	
	
	
	
	
			if (amount != null) {
				where.and(qPayments.amount.eq(amount));
			}
			if (checkNumber != null) {
				where.and(qPayments.checkNumber.containsIgnoreCase(checkNumber));
			}
			if (paymentDate != null) {
				where.and(qPayments.paymentDate.eq(paymentDate));
			}
			if (paymentTimestamp != null) {
				where.and(qPayments.paymentTimestamp.eq(paymentTimestamp));
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
