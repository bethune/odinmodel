package com.vladolium.odinmodel.view;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.*;
//import org.springframework.format.annotation.*;
import java.time.*;
import java.util.*;
import java.io.Serializable;
import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.ProductLines;
import com.vladolium.odinmodel.model.ProductLines.*;
import com.vladolium.odinmodel.service.ProductLinesService;
import com.vladolium.odinmodel.service.*;
import com.vladolium.odinmodel.wrapper.*;

@Named
@ViewScoped
public class ProductLinesView implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private ProductLinesService productLinesService;

	
	private ProductLines productLines;
	
	public ProductLines createOne() {
		return productLinesService.createUpdate(productLines);
	}
	
	private ProductLinesProducts productLinesProducts;
	
	public ProductLines createOneIric() {
		return productLinesService.createOneIric(productLinesProducts);
	}
	
	
	
	
	public ProductLines updateOneById(Long id) {
		ProductLines current = productLinesService.readOneById(id);
		
		current.setImage(productLines.getImage());
		
		current.setTextDescription(productLines.getTextDescription());
		
		current.setProductLine(productLines.getProductLine());
		
					
		return productLinesService.createUpdate(current);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ProductLines readOneById(Long id) {
		return productLinesService.readOneById(id);
	}
	
	
	
	
	
	public Iterable<ProductLines> readAll() {
		return productLinesService.readAll();
	}
	
	public Page<ProductLines> readAllPagination(
		Integer pageNumber,
		Integer perPageNumber
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return productLinesService.readAllPagination(page);
	}
	
	@Inject
	private ProductsService productsService;
	
	
	
	
	public Iterable<Products> readAllProductsByProductLinesId(Long productLinesId) {
		return productsService.readAllByProductLinesId(productLinesId);
	}
	
	public Page<Products> readAllProductsByProductLinesIdPagination(
		Integer pageNumber,
		Integer perPageNumber,
		Long productLinesId
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return productsService.readAllByProductLinesId(productLinesId, page);
	}
	
	
	
	
	
	public Iterable<ProductLines> search(
		byte[] image,
		String textDescription,
		String productLine
		
	) {
		return productLinesService.search(
			image,
			textDescription,
			productLine
			
		);
	}
	
	public Page<ProductLines> searchPagination(
		Integer pageNumber,
		Integer perPageNumber,
		byte[] image,
		String textDescription,
		String productLine
		
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
	
		return productLinesService.searchPagination(
			page,
			image,
			textDescription,
			productLine
			
		);
	}
	
	
	
	public void deleteOneById(Long id) {
		productLinesService.deleteOneById(id);
	}
	
	
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this view
//End of user code
}
