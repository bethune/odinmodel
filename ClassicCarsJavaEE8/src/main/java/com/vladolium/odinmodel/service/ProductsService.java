package com.vladolium.odinmodel.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.inject.Inject;
import javax.annotation.PostConstruct;
import com.vladolium.odinmodel.model.*;
import java.time.*;
import java.util.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.querydsl.*;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import com.querydsl.core.BooleanBuilder;
import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Products;
import com.vladolium.odinmodel.model.Products.*;
import com.vladolium.odinmodel.repository.*;
import com.vladolium.odinmodel.repository.ProductsRepository;
import com.vladolium.odinmodel.wrapper.*;

@Stateless
public class ProductsService {

 	@PersistenceContext
    private EntityManager em;

	private ProductsRepository productsRepository;
	
	@PostConstruct
	private void init() {
		RepositoryFactorySupport factory = new JpaRepositoryFactory(em);
		this.productsRepository = factory.getRepository(ProductsRepository.class);
	}

	// covers create, update and update with IRIC
	public Products createUpdate(Products products) {
		return productsRepository.save(products);
	}
	
	
	
	
	
	
	
	
	
	public Products readOneById(Long id) {
		return productsRepository.getOne(id);
	}
	
	
	
	
	public Products readOneByProductCode(String productCode) {
		return productsRepository.findByProductCodeEquals(productCode);
	}
	
	
	
	
	
	
	
	
	public Iterable<Products> readAll() {
		return productsRepository.findAll();
	}
	
	public Page<Products> readAllPagination(Pageable page) {
		return productsRepository.findAll(page);
	}
	
	
	
	
	public Iterable<Products> readAllByProductLinesId(Long productLinesId) {
		return productsRepository.findByProductLinesIdEquals(productLinesId);
	}
	
	public Page<Products> readAllByProductLinesId(Long productLinesId, Pageable page) {
		return productsRepository.findByProductLinesIdEquals(productLinesId, page);
	}
	
	
	
	
	
	public Iterable<Products> search(
		
		
		
		Long productLinesId,
		String productDescription,
		String productCode,
		Double msrp,
		Integer quantityInStock,
		Double buyPrice,
		String productName,
		String productScale,
		String productVendor
		
	) {
		BooleanBuilder where = dynamicWhere(
			
			
			
			productLinesId,
			productDescription,
			productCode,
			msrp,
			quantityInStock,
			buyPrice,
			productName,
			productScale,
			productVendor
				
		);
		return productsRepository.findAll(where);
	}
	
	public Page<Products> searchPagination(
		Pageable page,
		
		
		
		Long productLinesId,
		String productDescription,
		String productCode,
		Double msrp,
		Integer quantityInStock,
		Double buyPrice,
		String productName,
		String productScale,
		String productVendor
		
	) {
		BooleanBuilder where = dynamicWhere(
			
			
			
			productLinesId,
			productDescription,
			productCode,
			msrp,
			quantityInStock,
			buyPrice,
			productName,
			productScale,
			productVendor
			
		);
		return productsRepository.findAll(where, page);
	}
	
	public BooleanBuilder dynamicWhere(
		
		
		
		Long productLinesId,
		String productDescription,
		String productCode,
		Double msrp,
		Integer quantityInStock,
		Double buyPrice,
		String productName,
		String productScale,
		String productVendor
		
	) {
		QProducts qProducts = QProducts.products;
	
		BooleanBuilder where = new BooleanBuilder();
	
		
		
		
		if (productLinesId != null) {
			where.and(qProducts.productLines.id.eq(productLinesId));
		}
		if (productDescription != null) {
			where.and(qProducts.productDescription.eq(productDescription));
		}
		if (productCode != null) {
			where.and(qProducts.productCode.containsIgnoreCase(productCode));
		}
		if (msrp != null) {
			where.and(qProducts.msrp.eq(msrp));
		}
		if (quantityInStock != null) {
			where.and(qProducts.quantityInStock.eq(quantityInStock));
		}
		if (buyPrice != null) {
			where.and(qProducts.buyPrice.eq(buyPrice));
		}
		if (productName != null) {
			where.and(qProducts.productName.containsIgnoreCase(productName));
		}
		if (productScale != null) {
			where.and(qProducts.productScale.containsIgnoreCase(productScale));
		}
		if (productVendor != null) {
			where.and(qProducts.productVendor.containsIgnoreCase(productVendor));
		}
		
	
		return where;
	}
	
	
	
	
	
	
	
	
	public void deleteOneById(Long id) {
	    productsRepository.deleteById(id);
	}
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this service
//End of user code
}
