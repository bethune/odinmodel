package com.vladolium.odinmodel.services; 

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Payments;
import com.vladolium.odinmodel.model.Payments.*;
import com.vladolium.odinmodel.repositories.*;
import com.vladolium.odinmodel.repositories.PaymentsRepository;
import com.vladolium.odinmodel.interfaces.PaymentsInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Transactional;
import java.time.*;
import java.util.*;
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

	// covers create, update and update with IRIC
	@Override
	public Payments saveOne(Payments payments) {
		return paymentsRepository.save(payments);
	}
	
	


//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code
}
