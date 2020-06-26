package com.vladolium.odinmodel.interfaces;

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.ProductLines.*;

import java.time.*;
import java.util.*;

import org.springframework.data.domain.*;

import com.vladolium.odinmodel.wrappers.*;

public interface ProductLinesInterface {

	ProductLines saveOne(ProductLines productLines);
	
	void deleteOneById(Long id);
	
	ProductLines readOneById(Long id);

	Iterable<ProductLines> readAll();
	
	Page<ProductLines> readAllPagination(Pageable page);

	Iterable<ProductLines> search(
		byte[] image,
		String textDescription,
		String productLine
	);
	
	Page<ProductLines> searchPagination(
		Pageable page,
		byte[] image,
		String textDescription,
		String productLine
	);

	

	

	ProductLines saveOneWhenIricOnManyToOneRelationship(ProductLinesProducts productLinesProducts);

//Code between start and end will not be removed during generation.
//Start of user code for this interface
//End of user code
}
