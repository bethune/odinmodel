package com.vladolium.odinmodel.service;

import com.vladolium.odinmodel.domain.*;
import java.time.*;
import java.util.*;
import org.springframework.data.domain.*;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Products;
import com.vladolium.odinmodel.domain.Products.*;
import com.vladolium.odinmodel.wrapper.*;

public interface ProductsService {

	// covers create, update and update with IRIC
	Products createUpdate(Products products);
	
	
	
	
	
	
	
	
	
	Products readOneById(Long id);
	
	
	
	
	Products readOneByProductCode(String productCode);
	
	
	
	
	
	
	
	
	Iterable<Products> readAll();
	
	Page<Products> readAllPagination(Pageable page);
	
	
	
	
	Iterable <Products> readAllByProductLinesId(Long productLinesId);
	
	Page<Products> readAllByProductLinesId(Long productLinesId, Pageable page);
	
	
	
	
	
	Iterable<Products> search(
		
		
		
		Long productLinesId,
		String productDescription,
		String productCode,
		Double msrp,
		Integer quantityInStock,
		Double buyPrice,
		String productName,
		String productScale,
		String productVendor
		
	);
	
	Page<Products> searchPagination(
		Pageable page,
		
		
		
		Long productLinesId,
		String productDescription,
		String productCode,
		Double msrp,
		Integer quantityInStock,
		Double buyPrice,
		String productName,
		String productScale,
		String productVendor
		
	);
	
	
	
	
	
	
	
	void deleteOneById(Long id);
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this service
//End of user code
}
