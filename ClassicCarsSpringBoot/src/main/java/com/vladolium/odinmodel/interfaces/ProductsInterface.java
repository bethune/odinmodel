package com.vladolium.odinmodel.interfaces;

import com.vladolium.odinmodel.model.*;

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


	Products readOneByProductCode(String productCode);

	


//Code between start and end will not be removed during generation.
//Start of user code for this interface
//End of user code
}
