
package com.vladolium.odinmodel.serviceImpl;

import com.vladolium.odinmodel.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;

import java.time.*;
import java.util.*;

import com.vladolium.odinmodel.repository.PaymentsRepository;
import com.vladolium.odinmodel.service.PaymentsService;

@Service
public class PaymentsServiceImpl implements PaymentsService {

	private PaymentsRepository paymentsRepository;

	@Autowired
	public void setPaymentsRepository(PaymentsRepository paymentsRepository) {
		this.paymentsRepository = paymentsRepository;
	}

@Override
public Payments createUpdate(Payments payments) {
	return paymentsRepository.save(payments);
}



@Override
public Payments readOneById(Long id) {
	return paymentsRepository.getOne(id);
}














@Override
public void deleteOneById(Long id) {
	paymentsRepository.deleteById(id);
}






//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code

}
