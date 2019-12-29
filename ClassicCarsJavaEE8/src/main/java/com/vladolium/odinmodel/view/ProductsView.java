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
import com.vladolium.odinmodel.model.Products;
import com.vladolium.odinmodel.model.Products.*;
import com.vladolium.odinmodel.service.ProductsService;
import com.vladolium.odinmodel.service.*;
import com.vladolium.odinmodel.wrapper.*;

@Named
@ViewScoped
public class ProductsView implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private ProductsService productsService;

	
	private Products products;
	
	public Products createOne() {
		return productsService.createUpdate(products);
	}
	
	
	
	
	
	
	
	
	
	public Products updateOneById(Long id) {
		Products current = productsService.readOneById(id);
		current.setProductLines(products.getProductLines());
		
		current.setProductDescription(products.getProductDescription());
		
		current.setProductCode(products.getProductCode());
		
		current.setMsrp(products.getMsrp());
		
		current.setQuantityInStock(products.getQuantityInStock());
		
		current.setBuyPrice(products.getBuyPrice());
		
		current.setProductName(products.getProductName());
		
		
		current.setProductScale(products.getProductScale());
		
		current.setProductVendor(products.getProductVendor());
					
		return productsService.createUpdate(current);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Products updateOneByIdIric(Long id) {
		Products current = productsService.readOneById(id);
		if (current.getProductLines().getId() == products.getProductLines().getId()) {
			current.setProductLines(products.getProductLines());
			
			current.setProductDescription(products.getProductDescription());
			
			current.setProductCode(products.getProductCode());
			
			current.setMsrp(products.getMsrp());
			
			current.setQuantityInStock(products.getQuantityInStock());
			
			current.setBuyPrice(products.getBuyPrice());
			
			current.setProductName(products.getProductName());
			
			
			current.setProductScale(products.getProductScale());
			
			current.setProductVendor(products.getProductVendor());
						
			return productsService.createUpdate(current);
		} else {
		    Iterable<Products> listOfProducts = productsService.readAllByProductLinesId(current.getProductLines().getId());
		    Long size = listOfProducts.spliterator().getExactSizeIfKnown();
		    if (size == 1) {
				return current;
		    } else {
				current.setProductLines(products.getProductLines());
				
				current.setProductDescription(products.getProductDescription());
				
				current.setProductCode(products.getProductCode());
				
				current.setMsrp(products.getMsrp());
				
				current.setQuantityInStock(products.getQuantityInStock());
				
				current.setBuyPrice(products.getBuyPrice());
				
				current.setProductName(products.getProductName());
				
				
				current.setProductScale(products.getProductScale());
				
				current.setProductVendor(products.getProductVendor());
							
				return productsService.createUpdate(current);
		    }
		}
	}
	
	
	
	
	public Products updateOneByProductCode(String productCode) {
		Products current = productsService.readOneByProductCode(productCode);
		current.setProductLines(products.getProductLines());
		
		current.setProductDescription(products.getProductDescription());
		
		current.setProductCode(products.getProductCode());
		
		current.setMsrp(products.getMsrp());
		
		current.setQuantityInStock(products.getQuantityInStock());
		
		current.setBuyPrice(products.getBuyPrice());
		
		current.setProductName(products.getProductName());
		
		
		current.setProductScale(products.getProductScale());
		
		current.setProductVendor(products.getProductVendor());
					
		return productsService.createUpdate(current);		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public Products updateOneByProductCodeIric(String productCode) {
		Products current = productsService.readOneByProductCode(productCode);
		if (current.getProductLines().getId() == products.getProductLines().getId()) {
			current.setProductLines(products.getProductLines());
			
			current.setProductDescription(products.getProductDescription());
			
			current.setProductCode(products.getProductCode());
			
			current.setMsrp(products.getMsrp());
			
			current.setQuantityInStock(products.getQuantityInStock());
			
			current.setBuyPrice(products.getBuyPrice());
			
			current.setProductName(products.getProductName());
			
			
			current.setProductScale(products.getProductScale());
			
			current.setProductVendor(products.getProductVendor());
						
			return productsService.createUpdate(current);
		} else {
		    Iterable<Products> listOfProducts = productsService.readAllByProductLinesId(current.getProductLines().getId());
		    Long size = listOfProducts.spliterator().getExactSizeIfKnown();
		    if (size == 1) {
				return current;
		    } else {
				current.setProductLines(products.getProductLines());
				
				current.setProductDescription(products.getProductDescription());
				
				current.setProductCode(products.getProductCode());
				
				current.setMsrp(products.getMsrp());
				
				current.setQuantityInStock(products.getQuantityInStock());
				
				current.setBuyPrice(products.getBuyPrice());
				
				current.setProductName(products.getProductName());
				
				
				current.setProductScale(products.getProductScale());
				
				current.setProductVendor(products.getProductVendor());
							
				return productsService.createUpdate(current);
		    }
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Products readOneById(Long id) {
		return productsService.readOneById(id);
	}
	
	
	
	
	public Products readOneByProductCode(String productCode) {
		return productsService.readOneByProductCode(productCode);
	}
	
	
	
	
	
	
	
	
	public Iterable<Products> readAll() {
		return productsService.readAll();
	}
	
	public Page<Products> readAllPagination(
		Integer pageNumber,
		Integer perPageNumber
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return productsService.readAllPagination(page);
	}
	
	@Inject
	private OrderDetailsService orderDetailsService;
	
	
	
	
	
	
	
	
	public Iterable<OrderDetails> readAllOrderDetailsByProductsId(Long productsId) {
		return orderDetailsService.readAllByProductsId(productsId);
	}
	
	public Page<OrderDetails> readAllOrderDetailsByProductsIdPagination(
		Integer pageNumber,
		Integer perPageNumber,
		Long productsId
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return orderDetailsService.readAllByProductsId(productsId, page);
	}
	
	
	
	
	public Iterable<OrderDetails> readAllOrderDetailsByProductsProductCode(String productsProductCode) {
		return orderDetailsService.readAllByProductsProductCode(productsProductCode);
	}
	
	public Page<OrderDetails> readAllOrderDetailsByProductsProductCodePagination(
		Integer pageNumber,
		Integer perPageNumber,
		String productsProductCode
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return orderDetailsService.readAllByProductsProductCode(productsProductCode, page);
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
		return productsService.search(
			
			
			
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
	}
	
	public Page<Products> searchPagination(
		Integer pageNumber,
		Integer perPageNumber,
		
		
		
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
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
	
		return productsService.searchPagination(
			page,
			
			
			
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
	}
	
	
	
	
	
	
	
	public void deleteOneById(Long id) {
		productsService.deleteOneById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void deleteOneByIdIric(Long id) {
		Products current = productsService.readOneById(id);
		Iterable<Products> listOfProducts = productsService
			.readAllByProductLinesId(current.getProductLines().getId());
		Long size = listOfProducts.spliterator().getExactSizeIfKnown();
		if (size == 1) {
		    return;
		} else {
		    productsService.deleteOneById(id);
		}
	}
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this view
//End of user code
}
