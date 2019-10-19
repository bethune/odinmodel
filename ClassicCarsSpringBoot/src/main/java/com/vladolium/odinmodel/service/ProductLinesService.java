package com.vladolium.odinmodel.service;

import com.vladolium.odinmodel.domain.*;
import java.time.*;
import java.util.*;
import org.springframework.data.domain.*;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.ProductLines;
import com.vladolium.odinmodel.domain.ProductLines.*;
import com.vladolium.odinmodel.wrapperRequest.*;

public interface ProductLinesService {

	// covers create & update
	ProductLines createUpdate(ProductLines productLines);
	
	ProductLines createOneIric(ProductLinesProducts productLinesProducts);
	
	ProductLines readOneById(Long id);
	
	
	
	
	
	
	
	
	Iterable<ProductLines> readAll();
	
	Page<ProductLines> readAllPagination(Pageable page);
	
	
	
	Iterable<ProductLines> search(
		String textDescription,
		byte[] image,
		String productLine
		
	);
	
	Page<ProductLines> searchPagination(
		Pageable page,
		String textDescription,
		byte[] image,
		String productLine
		
	);
	void deleteOneById(Long id);
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this service
//End of user code
}
