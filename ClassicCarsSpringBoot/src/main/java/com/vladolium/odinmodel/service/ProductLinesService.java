package com.vladolium.odinmodel.service;

import com.vladolium.odinmodel.domain.*;
import java.time.*;
import java.util.*;
import org.springframework.data.domain.*;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.ProductLines;
import com.vladolium.odinmodel.domain.ProductLines.*;

public interface ProductLinesService {

	// covers create & update
	ProductLines createUpdate(ProductLines productLines);
	
	
	
	ProductLines readOneById(Long id);
	
	
	
	
	Iterable<ProductLines> readAll();
	Page<ProductLines> readAllPagination(Pageable page);
	
	
	
	void deleteOneById(Long id);
	

//Code between start and end will not be removed during generation.
//Start of user code for this service
//End of user code

}
