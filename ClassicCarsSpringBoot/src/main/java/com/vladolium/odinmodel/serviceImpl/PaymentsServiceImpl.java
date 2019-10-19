package com.vladolium.odinmodel.serviceImpl;

import com.vladolium.odinmodel.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Transactional;
import java.time.*;
import java.util.*;
import com.vladolium.odinmodel.repository.*;
import com.vladolium.odinmodel.repository.PaymentsRepository;
import com.vladolium.odinmodel.service.PaymentsService;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Payments;
import com.vladolium.odinmodel.domain.Payments.*;
import com.vladolium.odinmodel.wrapperRequest.*;
import com.querydsl.core.BooleanBuilder;

@Service
@Transactional
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
	public Iterable<Payments> readAllByCustomersId(Long customersId) {
		return paymentsRepository.findByCustomersIdEquals(customersId);
	}
	
	@Override
	public Page<Payments> readAllByCustomersId(Long customersId, Pageable page) {
		return paymentsRepository.findByCustomersIdEquals(customersId, page);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public Iterable<Payments> readAllByCustomersCustomerName(String customersCustomerName) {
		return paymentsRepository.findByCustomersCustomerNameEquals(customersCustomerName);
	}
	
	@Override
	public Page<Payments> readAllByCustomersCustomerName(String customersCustomerName, Pageable page) {
		return paymentsRepository.findByCustomersCustomerNameEquals(customersCustomerName, page);
	}
	
	
	
	@Override
	public Iterable<Payments> search(
		Long customersId,
		
		
		
		
		
		
		
		
		
		
		
		String checkNumber,
		LocalDate paymentDate,
		Double amount,
		Instant paymentTimestamp
		
	) {
		BooleanBuilder where = dynamicWhere(
			customersId,
			
			
			
			
			
			
			
			
			
			
			
			checkNumber,
			paymentDate,
			amount,
			paymentTimestamp
				
		);
		return paymentsRepository.findAll(where);
	}
	
	@Override
	public Page<Payments> searchPagination(
		Pageable page,
		Long customersId,
		
		
		
		
		
		
		
		
		
		
		
		String checkNumber,
		LocalDate paymentDate,
		Double amount,
		Instant paymentTimestamp
		
	) {
		BooleanBuilder where = dynamicWhere(
			customersId,
			
			
			
			
			
			
			
			
			
			
			
			checkNumber,
			paymentDate,
			amount,
			paymentTimestamp
			
		);
		return paymentsRepository.findAll(where, page);
	}
	
	public BooleanBuilder dynamicWhere(
		Long customersId,
		
		
		
		
		
		
		
		
		
		
		
		String checkNumber,
		LocalDate paymentDate,
		Double amount,
		Instant paymentTimestamp
		
	) {
		QPayments qPayments = QPayments.payments;
	
		BooleanBuilder where = new BooleanBuilder();
	
		if (customersId != null) {
			where.and(qPayments.customers.id.eq(customersId));
		}
		
		
		
		
		
		
		
		
		
		
		
		if (checkNumber != null) {
			where.and(qPayments.checkNumber.containsIgnoreCase(checkNumber));
		}
		if (paymentDate != null) {
			where.and(qPayments.paymentDate.eq(paymentDate));
		}
		if (amount != null) {
			where.and(qPayments.amount.eq(amount));
		}
		if (paymentTimestamp != null) {
			where.and(qPayments.paymentTimestamp.eq(paymentTimestamp));
		}
		
	
		return where;
	}
	
	
	
	
	
	@Override
	public void deleteOneById(Long id) {
		Payments currentPayments = paymentsRepository.getOne(id);
		Iterable<Payments> listOfPayments = paymentsRepository.findByCustomersIdEquals(currentPayments.getCustomers().getId());
		Long size = listOfPayments.spliterator().getExactSizeIfKnown();
		if (size == 1) {
		    return;
		} else {
		    paymentsRepository.deleteById(id);
		}
	}
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code
}
