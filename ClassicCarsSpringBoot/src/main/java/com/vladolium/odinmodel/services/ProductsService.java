package com.vladolium.odinmodel.services;

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Products.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.time.*;
import java.util.*;

import com.vladolium.odinmodel.repositories.*;
//import com.vladolium.odinmodel.specifications.*;
import com.vladolium.odinmodel.interfaces.*;
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

	@Override
	public Products saveOne(Products products) {
		return productsRepository.save(products);
	}

	@Override
	public void deleteOneById(Long id) {
	    productsRepository.deleteById(id);
	}
	
	@Override
	public Products readOneById(Long id) {
		return productsRepository.getOne(id);
	}

	@Override
	public Iterable<Products> readAll() {
		return productsRepository.findAll();
	}
	
	@Override
	public Page<Products> readAllPagination(Pageable page) {
		return productsRepository.findAll(page);
	}

	@Override
	public Iterable<Products> search(
		Long productLinesId,
		String productCode,
		Integer quantityInStock,
		String productScale,
		Double buyPrice,
		String productName,
		String productVendor,
		String productDescription,
		Double msrp
	) {
		BooleanBuilder where = dynamicWhere(
			productLinesId,
			productCode,
			quantityInStock,
			productScale,
			buyPrice,
			productName,
			productVendor,
			productDescription,
			msrp	
		);
		return productsRepository.findAll(where);
	}
	
	@Override
	public Page<Products> searchPagination(
		Pageable page,
		Long productLinesId,
		String productCode,
		Integer quantityInStock,
		String productScale,
		Double buyPrice,
		String productName,
		String productVendor,
		String productDescription,
		Double msrp
	) {
		BooleanBuilder where = dynamicWhere(
			productLinesId,
			productCode,
			quantityInStock,
			productScale,
			buyPrice,
			productName,
			productVendor,
			productDescription,
			msrp
		);
		return productsRepository.findAll(where, page);
	}
	
	public BooleanBuilder dynamicWhere(
		Long productLinesId,
		String productCode,
		Integer quantityInStock,
		String productScale,
		Double buyPrice,
		String productName,
		String productVendor,
		String productDescription,
		Double msrp
	) {
		QProducts qProducts = QProducts.products;
	
		BooleanBuilder where = new BooleanBuilder();
	
		if (productLinesId != null) {
			where.and(qProducts.productLines.id.eq(productLinesId));
		}
		if (productCode != null) {
			where.and(qProducts.productCode.containsIgnoreCase(productCode));
		}
		if (quantityInStock != null) {
			where.and(qProducts.quantityInStock.eq(quantityInStock));
		}
		if (productScale != null) {
			where.and(qProducts.productScale.containsIgnoreCase(productScale));
		}
		if (buyPrice != null) {
			where.and(qProducts.buyPrice.eq(buyPrice));
		}
		if (productName != null) {
			where.and(qProducts.productName.containsIgnoreCase(productName));
		}
		if (productVendor != null) {
			where.and(qProducts.productVendor.containsIgnoreCase(productVendor));
		}
		if (productDescription != null) {
			where.and(qProducts.productDescription.eq(productDescription));
		}
		if (msrp != null) {
			where.and(qProducts.msrp.eq(msrp));
		}
	
		return where;
	}


	@Override
	public Iterable<Products> readAllByProductLinesId(Long productLinesId) {
		return productsRepository.findByProductLinesIdEquals(productLinesId);
	}
	
	@Override
	public Page<Products> readAllByProductLinesId(Long productLinesId, Pageable page) {
		return productsRepository.findByProductLinesIdEquals(productLinesId, page);
	}

	@Override
	public Products readOneByProductCode(String productCode) {
		return productsRepository.findByProductCodeEquals(productCode);
	}
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code
}
