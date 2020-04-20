package com.vladolium.odinmodel.interfaces;

import com.vladolium.odinmodel.model.*;

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


	

	


//Code between start and end will not be removed during generation.
//Start of user code for this interface
//End of user code
}
