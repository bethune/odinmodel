
package com.vladolium.odinmodel.serviceImpl;

import com.vladolium.odinmodel.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;

import java.time.*;
import java.util.*;

import com.vladolium.odinmodel.repository.ProductLinesRepository;
import com.vladolium.odinmodel.service.ProductLinesService;

import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.ProductLines;
import com.vladolium.odinmodel.domain.ProductLines.*;

@Service
public class ProductLinesServiceImpl implements ProductLinesService {

	private ProductLinesRepository productLinesRepository;

	@Autowired
	public void setProductLinesRepository(ProductLinesRepository productLinesRepository) {
		this.productLinesRepository = productLinesRepository;
	}


// covers create & update
@Override
public ProductLines createUpdate(ProductLines productLines) {
	return productLinesRepository.save(productLines);
}






@Override
public ProductLines readOneById(Long id) {
	return productLinesRepository.getOne(id);
}








@Override
public Iterable<ProductLines> readAll() {
	return productLinesRepository.findAll();
}


@Override
public Page<ProductLines> readAllPagination(Pageable page) {
	return productLinesRepository.findAll(page);
}








@Override
public void deleteOneById(Long id) {
	productLinesRepository.deleteById(id);
}


//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code

}
