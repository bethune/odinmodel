package com.vladolium.odinmodel.serviceImpl;

import com.vladolium.odinmodel.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;
import java.time.*;
import java.util.*;
import com.vladolium.odinmodel.repository.ProductsRepository;
import com.vladolium.odinmodel.service.ProductsService;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Products;
import com.vladolium.odinmodel.domain.Products.*;
import com.querydsl.core.BooleanBuilder;

@Service
public class ProductsServiceImpl implements ProductsService {

	private ProductsRepository productsRepository;

	@Autowired
	public void setProductsRepository(ProductsRepository productsRepository) {
		this.productsRepository = productsRepository;
	}

	// covers create & update
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
	public Iterable<Products> search(
		
		Long productLinesId,
		
		
		Double buyPrice,
		String productCode,
		String productScale,
		String productDescription,
		Double msrp,
		String productName,
		String productVendor,
		Integer quantityInStock
		
	) {
		BooleanBuilder where = dynamicWhere(
			
			productLinesId,
			
			
			buyPrice,
			productCode,
			productScale,
			productDescription,
			msrp,
			productName,
			productVendor,
			quantityInStock
				
		);
		return productsRepository.findAll(where);
	}
	
	public BooleanBuilder dynamicWhere(
		
		Long productLinesId,
		
		
		Double buyPrice,
		String productCode,
		String productScale,
		String productDescription,
		Double msrp,
		String productName,
		String productVendor,
		Integer quantityInStock
		
	) {
		QProducts qProducts = QProducts.products;
	
		BooleanBuilder where = new BooleanBuilder();
	
		
		if (productLinesId != null) {
			where.and(qProducts.productLines.id.eq(productLinesId));
		}
		
		
		if (buyPrice != null) {
			where.and(qProducts.buyPrice.eq(buyPrice));
		}
		if (productCode != null) {
			where.and(qProducts.productCode.containsIgnoreCase(productCode));
		}
		if (productScale != null) {
			where.and(qProducts.productScale.containsIgnoreCase(productScale));
		}
		if (productDescription != null) {
			where.and(qProducts.productDescription.eq(productDescription));
		}
		if (msrp != null) {
			where.and(qProducts.msrp.eq(msrp));
		}
		if (productName != null) {
			where.and(qProducts.productName.containsIgnoreCase(productName));
		}
		if (productVendor != null) {
			where.and(qProducts.productVendor.containsIgnoreCase(productVendor));
		}
		if (quantityInStock != null) {
			where.and(qProducts.quantityInStock.eq(quantityInStock));
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
