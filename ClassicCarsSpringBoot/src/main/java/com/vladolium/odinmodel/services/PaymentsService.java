package com.vladolium.odinmodel.services;

import com.vladolium.odinmodel.model.*;

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

	
	
	



//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code
}
