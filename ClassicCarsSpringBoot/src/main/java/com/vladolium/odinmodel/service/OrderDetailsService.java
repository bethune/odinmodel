package com.vladolium.odinmodel.service;

import com.vladolium.odinmodel.domain.*;
import java.time.*;
import java.util.*;
import org.springframework.data.domain.*;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.OrderDetails;
import com.vladolium.odinmodel.domain.OrderDetails.*;
import com.vladolium.odinmodel.wrapper.*;

public interface OrderDetailsService {

	// covers create, update and update with IRIC
	OrderDetails createUpdate(OrderDetails orderDetails);
	
	
	
	
	
	OrderDetails readOneById(Long id);
	
	
	
	
	
	
	
	Iterable<OrderDetails> readAll();
	
	Page<OrderDetails> readAllPagination(Pageable page);
	
	Iterable <OrderDetails> readAllByProductsId(Long productsId);
	
	Page<OrderDetails> readAllByProductsId(Long productsId, Pageable page);
	
	
	
	
	
	
	
	
	
	
	
	Iterable <OrderDetails> readAllByProductsProductCode(String productsProductCode);
	
	Page<OrderDetails> readAllByProductsProductCode(String productsProductCode, Pageable page);
	
	
	
	
	
	
	
	Iterable<OrderDetails> search(
		Long productsId,
		
		
		
		
		
		
		
		
		
		
		
		
		
		Long ordersId,
		Double priceEach,
		Integer quantityOrdered,
		Integer orderLineNumber
		
	);
	
	Page<OrderDetails> searchPagination(
		Pageable page,
		Long productsId,
		
		
		
		
		
		
		
		
		
		
		
		
		
		Long ordersId,
		Double priceEach,
		Integer quantityOrdered,
		Integer orderLineNumber
		
	);
	
	
	
	void deleteOneById(Long id);
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this service
//End of user code
}
