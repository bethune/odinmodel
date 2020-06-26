package com.vladolium.odinmodel.interfaces;

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.OrderDetails.*;

import java.time.*;
import java.util.*;

import org.springframework.data.domain.*;

import com.vladolium.odinmodel.wrappers.*;

public interface OrderDetailsInterface {

	OrderDetails saveOne(OrderDetails orderDetails);
	
	void deleteOneById(Long id);
	
	OrderDetails readOneById(Long id);

	Iterable<OrderDetails> readAll();
	
	Page<OrderDetails> readAllPagination(Pageable page);

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

	Iterable<OrderDetails> readAllByProductsProductCode(String productsProductCode);
	
	Page<OrderDetails> readAllByProductsProductCode(String productsProductCode, Pageable page);
	
	
	Iterable<OrderDetails> readAllByProductsId(Long productsId);
	
	Page<OrderDetails> readAllByProductsId(Long productsId, Pageable page);

	

	

//Code between start and end will not be removed during generation.
//Start of user code for this interface
//End of user code
}
