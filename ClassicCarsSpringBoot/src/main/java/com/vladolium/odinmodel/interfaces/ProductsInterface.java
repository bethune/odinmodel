package com.vladolium.odinmodel.interfaces;

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Products.*;

import java.time.*;
import java.util.*;

import org.springframework.data.domain.*;

import com.vladolium.odinmodel.wrappers.*;

public interface ProductsInterface {

	Products saveOne(Products products);
	
	void deleteOneById(Long id);
	
	Products readOneById(Long id);

	Iterable<Products> readAll();
	
	Page<Products> readAllPagination(Pageable page);

	Iterable<Products> search(
		Long productLinesId,
		Integer quantityInStock,
		String productName,
		Double buyPrice,
		Double msrp,
		String productVendor,
		String productCode,
		String productDescription,
		String productScale
	);
	
	Page<Products> searchPagination(
		Pageable page,
		Long productLinesId,
		Integer quantityInStock,
		String productName,
		Double buyPrice,
		Double msrp,
		String productVendor,
		String productCode,
		String productDescription,
		String productScale
	);

	Iterable<Products> readAllByProductLinesId(Long productLinesId);
	
	Page<Products> readAllByProductLinesId(Long productLinesId, Pageable page);

	Products readOneByProductCode(String productCode);

	

//Code between start and end will not be removed during generation.
//Start of user code for this interface
//End of user code
}
