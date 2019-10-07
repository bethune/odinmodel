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
import static org.jooq.impl.DSL.*;

@Service
public class ProductsServiceImpl implements ProductsService {

	private final DSLContext jooq;

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
		
		Integer quantityInStock,
		String productCode,
		String productVendor,
		Double buyPrice,
		Double mSRP,
		String productScale,
		String productDescription,
		String productName
		
	) {
		Condition condition = dynamicCondition(
			
			
			
			Long productLinesId,
			
			quantityInStock,
			productCode,
			productVendor,
			buyPrice,
			mSRP,
			productScale,
			productDescription,
			productName
		);
		return productsRepository.findAll(condition);
	}
	public Condition dynamicCondition(
		
		
		
		Long productLinesId,
		
		Integer quantityInStock,
		String productCode,
		String productVendor,
		Double buyPrice,
		Double mSRP,
		String productScale,
		String productDescription,
		String productName
		
	) {
		Condition condition = trueCondition();
	
	
	
	
		if (productLinesId != null) {
			condition.and(products.productLines.id.eq(productLinesId));
		}
			if (quantityInStock != null) {
				where.and(qProducts.quantityInStock.eq(quantityInStock));
			}
			if (productCode != null) {
				where.and(qProducts.productCode.containsIgnoreCase(productCode));
			}
			if (productVendor != null) {
				where.and(qProducts.productVendor.containsIgnoreCase(productVendor));
			}
			if (buyPrice != null) {
				where.and(qProducts.buyPrice.eq(buyPrice));
			}
			if (mSRP != null) {
				where.and(qProducts.mSRP.eq(mSRP));
			}
			if (productScale != null) {
				where.and(qProducts.productScale.containsIgnoreCase(productScale));
			}
			if (productDescription != null) {
				where.and(qProducts.productDescription.eq(productDescription));
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
