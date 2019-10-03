
package com.vladolium.odinmodel.serviceImpl;

import com.vladolium.odinmodel.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;

import java.time.*;
import java.util.*;

import com.vladolium.odinmodel.repository.CustomersRepository;
import com.vladolium.odinmodel.service.CustomersService;

@Service
public class CustomersServiceImpl implements CustomersService {

	private CustomersRepository customersRepository;

	@Autowired
	public void setCustomersRepository(CustomersRepository customersRepository) {
		this.customersRepository = customersRepository;
	}

@Override
public Customers createUpdate(Customers customers) {
	return customersRepository.save(customers);
}





@Override
public Customers readOneById(Long id) {
	return customersRepository.getOne(id);
}





















@Override
public Customers readOneByCustomerName(String customerName) {
	return customersRepository.findByCustomerNameEquals(customerName);
}




//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code

}
