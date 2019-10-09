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

	
	
	
	@Override
	public ProductLines readOneById(Long id) {
		return productLinesRepository.getOne(id);
	}
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code

}
