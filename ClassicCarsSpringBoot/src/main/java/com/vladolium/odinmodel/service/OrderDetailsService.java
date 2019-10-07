package com.vladolium.odinmodel.service;

import com.vladolium.odinmodel.domain.*;
import java.time.*;
import java.util.*;
import org.springframework.data.domain.*;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.OrderDetails;
import com.vladolium.odinmodel.domain.OrderDetails.*;

public interface OrderDetailsService {

	// covers create & update
	OrderDetails createUpdate(OrderDetails orderDetails);
	OrderDetails readOneById(Long id);
	
	
	
	
	
	
	
	
	
	Iterable<OrderDetails> readAll();
	Page<OrderDetails> readAllPagination(Pageable page);
	Iterable<OrderDetails> search(
		
		
		
		
		Long ordersId,
		
		
		
		
		
		
		
		
		
		Long productsId,
		
		Integer quantityOrdered,
		Integer orderLineNumber,
		Double priceEach
		
	);
	
	void deleteOneById(Long id);
	
	
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this service
//End of user code

}
