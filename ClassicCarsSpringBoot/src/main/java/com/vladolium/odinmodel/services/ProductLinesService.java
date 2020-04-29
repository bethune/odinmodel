package com.vladolium.odinmodel.services;

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.ProductLines.*;

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

	@Override
	public Iterable<ProductLines> search(
		String textDescription,
		String productLine,
		byte[] image
	) {
		BooleanBuilder where = dynamicWhere(
			textDescription,
			productLine,
			image	
		);
		return productLinesRepository.findAll(where);
	}
	
	@Override
	public Page<ProductLines> searchPagination(
		Pageable page,
		String textDescription,
		String productLine,
		byte[] image
	) {
		BooleanBuilder where = dynamicWhere(
			textDescription,
			productLine,
			image
		);
		return productLinesRepository.findAll(where, page);
	}
	
	public BooleanBuilder dynamicWhere(
		String textDescription,
		String productLine,
		byte[] image
	) {
		QProductLines qProductLines = QProductLines.productLines;
	
		BooleanBuilder where = new BooleanBuilder();
	
		if (textDescription != null) {
			where.and(qProductLines.textDescription.eq(textDescription));
		}
		if (productLine != null) {
			where.and(qProductLines.productLine.containsIgnoreCase(productLine));
		}
		if (image != null) {
			where.and(qProductLines.image.eq(image));
		}
	
		return where;
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
