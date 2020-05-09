package com.vladolium.odinmodel.services;

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Payments.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Transactional;

import java.time.*;
import java.util.*;

import com.vladolium.odinmodel.repositories.*;
import com.vladolium.odinmodel.interfaces.*;
import com.vladolium.odinmodel.wrappers.*;

import com.querydsl.core.BooleanBuilder;

@Service
@Transactional
public class PaymentsService implements PaymentsInterface {

	private PaymentsRepository paymentsRepository;

	@Autowired
	public void setPaymentsRepository(PaymentsRepository paymentsRepository) {
		this.paymentsRepository = paymentsRepository;
	}

	@Override
	public Payments saveOne(Payments payments) {
		return paymentsRepository.save(payments);
	}

	@Override
	public void deleteOneById(Long id) {
	    paymentsRepository.deleteById(id);
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
	public Iterable<Payments> readAllByCustomersCustomerName(String customersCustomerName) {
		return paymentsRepository.findByCustomersCustomerNameEquals(customersCustomerName);
	}
	
	@Override
	public Page<Payments> readAllByCustomersCustomerName(String customersCustomerName, Pageable page) {
		return paymentsRepository.findByCustomersCustomerNameEquals(customersCustomerName, page);
	}
	
	
	
	
	
	
	
	
	
	@Override
	public Iterable<Payments> readAllByCustomersId(Long customersId) {
		return paymentsRepository.findByCustomersIdEquals(customersId);
	}
	
	@Override
	public Page<Payments> readAllByCustomersId(Long customersId, Pageable page) {
		return paymentsRepository.findByCustomersIdEquals(customersId, page);
	}

	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code
}
