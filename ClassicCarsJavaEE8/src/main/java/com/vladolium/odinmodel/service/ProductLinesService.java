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
import com.vladolium.odinmodel.model.ProductLines;
import com.vladolium.odinmodel.model.ProductLines.*;
import com.vladolium.odinmodel.repository.*;
import com.vladolium.odinmodel.repository.ProductLinesRepository;
import com.vladolium.odinmodel.wrapper.*;

@Stateless
public class ProductLinesService {

 	@PersistenceContext
    private EntityManager em;

	private ProductLinesRepository productLinesRepository;
	
	@PostConstruct
	private void init() {
		RepositoryFactorySupport factory = new JpaRepositoryFactory(em);
		this.productLinesRepository = factory.getRepository(ProductLinesRepository.class);
	}

	// covers create, update and update with IRIC
	public ProductLines createUpdate(ProductLines productLines) {
		return productLinesRepository.save(productLines);
	}
	
	private ProductsRepository productsRepository;
	
	public ProductLines createOneIric(ProductLinesProducts productLinesProducts) {
		ProductLines currentProductLines = productLinesRepository.save(productLinesProducts.getProductLines());
		Products currentProducts = productLinesProducts.getProducts();
		currentProducts.setProductLines(productLinesRepository.getOne(currentProductLines.getId()));
		productsRepository.save(currentProducts);
		return currentProductLines;
	}
	
	
	
	
	public ProductLines readOneById(Long id) {
		return productLinesRepository.getOne(id);
	}
	
	
	
	
	
	public Iterable<ProductLines> readAll() {
		return productLinesRepository.findAll();
	}
	
	public Page<ProductLines> readAllPagination(Pageable page) {
		return productLinesRepository.findAll(page);
	}
	
	
	
	public Iterable<ProductLines> search(
		byte[] image,
		String textDescription,
		String productLine
		
	) {
		BooleanBuilder where = dynamicWhere(
			image,
			textDescription,
			productLine
				
		);
		return productLinesRepository.findAll(where);
	}
	
	public Page<ProductLines> searchPagination(
		Pageable page,
		byte[] image,
		String textDescription,
		String productLine
		
	) {
		BooleanBuilder where = dynamicWhere(
			image,
			textDescription,
			productLine
			
		);
		return productLinesRepository.findAll(where, page);
	}
	
	public BooleanBuilder dynamicWhere(
		byte[] image,
		String textDescription,
		String productLine
		
	) {
		QProductLines qProductLines = QProductLines.productLines;
	
		BooleanBuilder where = new BooleanBuilder();
	
		if (image != null) {
			where.and(qProductLines.image.eq(image));
		}
		if (textDescription != null) {
			where.and(qProductLines.textDescription.eq(textDescription));
		}
		if (productLine != null) {
			where.and(qProductLines.productLine.containsIgnoreCase(productLine));
		}
		
	
		return where;
	}
	
	
	
	
	public void deleteOneById(Long id) {
	    productLinesRepository.deleteById(id);
	}
	

//Code between start and end will not be removed during generation.
//Start of user code for this service
//End of user code
}
