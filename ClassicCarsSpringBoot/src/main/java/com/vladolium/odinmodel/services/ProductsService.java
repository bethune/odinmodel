package com.vladolium.odinmodel.services; 

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Products;
import com.vladolium.odinmodel.model.Products.*;
import com.vladolium.odinmodel.repositories.*;
import com.vladolium.odinmodel.repositories.ProductsRepository;
import com.vladolium.odinmodel.interfaces.ProductsInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Transactional;
import java.time.*;
import java.util.*;
import com.vladolium.odinmodel.wrappers.*;
import com.querydsl.core.BooleanBuilder;

@Service
@Transactional
public class ProductsService implements ProductsInterface {

	private ProductsRepository productsRepository;

	@Autowired
	public void setProductsRepository(ProductsRepository productsRepository) {
		this.productsRepository = productsRepository;
	}

	// covers create, update and update with IRIC
	@Override
	public Products saveOne(Products products) {
		return productsRepository.save(products);
	}
	
	


//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code
}
