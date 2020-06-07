package com.vladolium.odinmodel.services;

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Payments.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.time.*;
import java.util.*;

import com.vladolium.odinmodel.repositories.*;
import com.vladolium.odinmodel.specifications.*;
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
		Specification<Payments> where = dynamicWhere(
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
		Specification<Payments> where = dynamicWhere(
			customersId,
			checkNumber,
			paymentDate,
			amount,
			paymentTimestamp
		);
		return paymentsRepository.findAll(where, page);
	}
	
	public Specification<Payments> dynamicWhere(
		Long customersId,
		String checkNumber,
		LocalDate paymentDate,
		Double amount,
		Instant paymentTimestamp
	) {
		Specification<Payments> where = Specification
			.where(checkNumber == null ? null : PaymentsSpecification.getPaymentsByCheckNumber(checkNumber))
			.and(paymentDate == null ? null : PaymentsSpecification.getPaymentsByPaymentDate(paymentDate))
			.and(amount == null ? null : PaymentsSpecification.getPaymentsByAmount(amount))
			.and(paymentTimestamp == null ? null : PaymentsSpecification.getPaymentsByPaymentTimestamp(paymentTimestamp))
			.and(customersId == null ? null : PaymentsSpecification.getPaymentsByCustomersId(customersId));
	
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
