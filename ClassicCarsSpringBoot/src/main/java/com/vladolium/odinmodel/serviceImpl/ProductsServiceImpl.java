
package com.vladolium.odinmodel.serviceImpl;

import com.vladolium.odinmodel.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;

import java.time.*;
import java.util.*;

import com.vladolium.odinmodel.repository.ProductsRepository;
import com.vladolium.odinmodel.service.ProductsService;

@Service
public class ProductsServiceImpl implements ProductsService {

	private ProductsRepository productsRepository;

	@Autowired
	public void setProductsRepository(ProductsRepository productsRepository) {
		this.productsRepository = productsRepository;
	}

@Override
public Products createUpdate(Products products) {
	return productsRepository.save(products);
}

//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code

}
