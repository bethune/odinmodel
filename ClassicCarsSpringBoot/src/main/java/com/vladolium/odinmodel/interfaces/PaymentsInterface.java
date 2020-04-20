package com.vladolium.odinmodel.interfaces;

import com.vladolium.odinmodel.model.*;

import java.time.*;
import java.util.*;

import org.springframework.data.domain.*;

import com.vladolium.odinmodel.wrappers.*;

public interface PaymentsInterface {

	Payments saveOne(Payments payments);
	
	void deleteOneById(Long id);
	
	Payments readOneById(Long id);

	Iterable<Payments> readAll();
	
	Page<Payments> readAllPagination(Pageable page);


	

	


//Code between start and end will not be removed during generation.
//Start of user code for this interface
//End of user code
}
