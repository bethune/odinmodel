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
import com.vladolium.odinmodel.specifications.*;
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
		String productName,
		Integer quantityInStock,
		String productVendor,
		String productDescription,
		Double buyPrice,
		String productScale,
		Double msrp,
		String productCode
	) {
		Specification<Products> where = dynamicWhere(
			productLinesId,
			productName,
			quantityInStock,
			productVendor,
			productDescription,
			buyPrice,
			productScale,
			msrp,
			productCode	
		);
		return productsRepository.findAll(where);
	}
	
	@Override
	public Page<Products> searchPagination(
		Pageable page,
		Long productLinesId,
		String productName,
		Integer quantityInStock,
		String productVendor,
		String productDescription,
		Double buyPrice,
		String productScale,
		Double msrp,
		String productCode
	) {
		Specification<Products> where = dynamicWhere(
			productLinesId,
			productName,
			quantityInStock,
			productVendor,
			productDescription,
			buyPrice,
			productScale,
			msrp,
			productCode
		);
		return productsRepository.findAll(where, page);
	}
	
	public Specification<Products> dynamicWhere(
		Long productLinesId,
		String productName,
		Integer quantityInStock,
		String productVendor,
		String productDescription,
		Double buyPrice,
		String productScale,
		Double msrp,
		String productCode
	) {
		Specification<Products> where = Specification
			.where(productName == null ? null : ProductsSpecification.getProductsByProductName(productName))
			.and(quantityInStock == null ? null : ProductsSpecification.getProductsByQuantityInStock(quantityInStock))
			.and(productVendor == null ? null : ProductsSpecification.getProductsByProductVendor(productVendor))
			.and(productDescription == null ? null : ProductsSpecification.getProductsByProductDescription(productDescription))
			.and(buyPrice == null ? null : ProductsSpecification.getProductsByBuyPrice(buyPrice))
			.and(productScale == null ? null : ProductsSpecification.getProductsByProductScale(productScale))
			.and(msrp == null ? null : ProductsSpecification.getProductsByMsrp(msrp))
			.and(productCode == null ? null : ProductsSpecification.getProductsByProductCode(productCode))
			.and(productLinesId == null ? null : ProductsSpecification.getProductsByProductLinesId(productLinesId));
	
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
