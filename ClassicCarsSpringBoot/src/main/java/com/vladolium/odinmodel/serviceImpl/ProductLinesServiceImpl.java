package com.vladolium.odinmodel.serviceImpl;

import com.vladolium.odinmodel.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Transactional;
import java.time.*;
import java.util.*;
import com.vladolium.odinmodel.repository.*;
import com.vladolium.odinmodel.repository.ProductLinesRepository;
import com.vladolium.odinmodel.service.ProductLinesService;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.ProductLines;
import com.vladolium.odinmodel.domain.ProductLines.*;
import com.vladolium.odinmodel.wrapperRequest.*;
import com.querydsl.core.BooleanBuilder;

@Service
@Transactional
public class ProductLinesServiceImpl implements ProductLinesService {

	private ProductLinesRepository productLinesRepository;

	@Autowired
	public void setProductLinesRepository(ProductLinesRepository productLinesRepository) {
		this.productLinesRepository = productLinesRepository;
	}

	// covers create & update
	@Override
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
	
	@Override
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
	
	
	@Override
	public void deleteOneById(Long id) {
	    productLinesRepository.deleteById(id);
	}
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code
}
