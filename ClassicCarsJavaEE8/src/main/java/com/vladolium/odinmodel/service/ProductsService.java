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
import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Products;
import com.vladolium.odinmodel.model.Products.*;
import com.vladolium.odinmodel.repository.*;
import com.vladolium.odinmodel.repository.ProductsRepository;
//import com.vladolium.odinmodel.wrapper.*;

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

	
	
	
	
	
	
	
	public Products readOneById(Long id) {
		return productsRepository.getOne(id);
	}
	
	
	
	
	public Products readOneByProductCode(String productCode) {
		return productsRepository.findByProductCodeEquals(productCode);
	}
	
	
	
	
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this service
//End of user code
}
