package com.vladolium.odinmodel.services;

import com.vladolium.odinmodel.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Transactional;

import java.time.*;
import java.util.*;

import com.vladolium.odinmodel.repositories.*;
import com.vladolium.odinmodel.interfaces.*;
import com.vladolium.odinmodel.wrappers.*;

import com.querydsl.core.BooleanBuilder;

@Service
@Transactional
public class ProductLinesService implements ProductLinesInterface {

	private ProductLinesRepository productLinesRepository;

	@Autowired
	public void setProductLinesRepository(ProductLinesRepository productLinesRepository) {
		this.productLinesRepository = productLinesRepository;
	}

	@Override
	public ProductLines saveOne(ProductLines productLines) {
		return productLinesRepository.save(productLines);
	}

	@Override
	public void deleteOneById(Long id) {
	    productLinesRepository.deleteById(id);
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

	
	
	private ProductsRepository productsRepository;
	
	public ProductLines saveOneWhenIricOnManyToOneRelationship(ProductLinesProducts productLinesProducts) {
		
		ProductLines currentProductLines = productLinesRepository.save(productLinesProducts.getProductLines());
		
		Products currentProducts = productLinesProducts.getProducts();
		
		currentProducts.setProductLines(productLinesRepository.getOne(currentProductLines.getId()));
		
		productsRepository.save(currentProducts);
		
		return currentProductLines;
	}



//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code
}
