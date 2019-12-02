package com.vladolium.odinmodel.serviceImpl;

import com.vladolium.odinmodel.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Transactional;
import java.time.*;
import java.util.*;
import com.vladolium.odinmodel.repository.*;
import com.vladolium.odinmodel.repository.ProductsRepository;
import com.vladolium.odinmodel.service.ProductsService;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Products;
import com.vladolium.odinmodel.domain.Products.*;
import com.vladolium.odinmodel.wrapper.*;
import com.querydsl.core.BooleanBuilder;

@Service
@Transactional
public class ProductsServiceImpl implements ProductsService {

	private ProductsRepository productsRepository;

	@Autowired
	public void setProductsRepository(ProductsRepository productsRepository) {
		this.productsRepository = productsRepository;
	}

	// covers create, update and update with IRIC
	@Override
	public Products createUpdate(Products products) {
		return productsRepository.save(products);
	}
	
	
	@Override
	public Products readOneById(Long id) {
		return productsRepository.getOne(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public Products readOneByProductCode(String productCode) {
		return productsRepository.findByProductCodeEquals(productCode);
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
	public Iterable<Products> readAllByProductLinesId(Long productLinesId) {
		return productsRepository.findByProductLinesIdEquals(productLinesId);
	}
	
	@Override
	public Page<Products> readAllByProductLinesId(Long productLinesId, Pageable page) {
		return productsRepository.findByProductLinesIdEquals(productLinesId, page);
	}
	
	
	
	
	
	
	
	
	@Override
	public Iterable<Products> search(
		Long productLinesId,
		
		
		
		String productDescription,
		String productCode,
		Double buyPrice,
		Integer quantityInStock,
		Double msrp,
		String productScale,
		String productVendor,
		String productName
		
	) {
		BooleanBuilder where = dynamicWhere(
			productLinesId,
			
			
			
			productDescription,
			productCode,
			buyPrice,
			quantityInStock,
			msrp,
			productScale,
			productVendor,
			productName
				
		);
		return productsRepository.findAll(where);
	}
	
	@Override
	public Page<Products> searchPagination(
		Pageable page,
		Long productLinesId,
		
		
		
		String productDescription,
		String productCode,
		Double buyPrice,
		Integer quantityInStock,
		Double msrp,
		String productScale,
		String productVendor,
		String productName
		
	) {
		BooleanBuilder where = dynamicWhere(
			productLinesId,
			
			
			
			productDescription,
			productCode,
			buyPrice,
			quantityInStock,
			msrp,
			productScale,
			productVendor,
			productName
			
		);
		return productsRepository.findAll(where, page);
	}
	
	public BooleanBuilder dynamicWhere(
		Long productLinesId,
		
		
		
		String productDescription,
		String productCode,
		Double buyPrice,
		Integer quantityInStock,
		Double msrp,
		String productScale,
		String productVendor,
		String productName
		
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
		if (buyPrice != null) {
			where.and(qProducts.buyPrice.eq(buyPrice));
		}
		if (quantityInStock != null) {
			where.and(qProducts.quantityInStock.eq(quantityInStock));
		}
		if (msrp != null) {
			where.and(qProducts.msrp.eq(msrp));
		}
		if (productScale != null) {
			where.and(qProducts.productScale.containsIgnoreCase(productScale));
		}
		if (productVendor != null) {
			where.and(qProducts.productVendor.containsIgnoreCase(productVendor));
		}
		if (productName != null) {
			where.and(qProducts.productName.containsIgnoreCase(productName));
		}
		
	
		return where;
	}
	
	@Override
	public void deleteOneById(Long id) {
	    productsRepository.deleteById(id);
	}
	
	
	
	
	
	
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code
}
