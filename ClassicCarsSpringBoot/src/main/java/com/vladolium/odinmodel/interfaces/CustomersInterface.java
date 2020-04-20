package com.vladolium.odinmodel.interfaces;

import com.vladolium.odinmodel.model.*;

import java.time.*;
import java.util.*;

import org.springframework.data.domain.*;

import com.vladolium.odinmodel.wrappers.*;

public interface CustomersInterface {

	Customers saveOne(Customers customers);
	
	void deleteOneById(Long id);
	
	Customers readOneById(Long id);

	Iterable<Customers> readAll();
	
	Page<Customers> readAllPagination(Pageable page);


	Customers readOneByCustomerName(String customerName);

	


//Code between start and end will not be removed during generation.
//Start of user code for this interface
//End of user code
}
