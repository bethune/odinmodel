package com.vladolium.odinmodel.controllers;

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Products.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.format.annotation.*;

import java.time.*;
import java.util.*;

import com.vladolium.odinmodel.interfaces.*;
import com.vladolium.odinmodel.wrappers.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/products")
public class ProductsController {

	private ProductsInterface productsInterface;

	@Autowired
	public void setProductsInterface(ProductsInterface productsInterface) {
		this.productsInterface = productsInterface;
	}

	@PostMapping("")
	public Products saveOne(@RequestBody Products products) {
		return productsInterface.saveOne(products);
	}

	@DeleteMapping("/{id}")
	public void deleteOneById(@PathVariable Long id) {
		productsInterface.deleteOneById(id);
	}
	
	@GetMapping("/{id}")
	public Products readOneById(@PathVariable Long id) {
		return productsInterface.readOneById(id);
	}
	
	@PutMapping("/{id}")
	public Products updateOneById(@PathVariable Long id, @RequestBody Products products) {
		
		Products current = productsInterface.readOneById(id);
			
		current.setProductLines(products.getProductLines());
		current.setProductName(products.getProductName());
		current.setQuantityInStock(products.getQuantityInStock());
		current.setProductVendor(products.getProductVendor());
		current.setProductDescription(products.getProductDescription());
		current.setBuyPrice(products.getBuyPrice());
		current.setProductScale(products.getProductScale());
		current.setMsrp(products.getMsrp());
		current.setProductCode(products.getProductCode());
				
		return productsInterface.saveOne(current);
	}

	@GetMapping("")
	public Iterable<Products> readAll() {
		return productsInterface.readAll();
	}
	
	@GetMapping("/page={pageNumber}/perPage={perPageNumber}")
	public Page<Products> readAllPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return productsInterface.readAllPagination(page);
	}

	@GetMapping("/search")
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
		return productsInterface.search(
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
	}
	
	@GetMapping("/search/page={pageNumber}/perPage={perPageNumber}")
	public Page<Products> searchPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber,
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
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
	
		return productsInterface.searchPagination(
			page,
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
	}

	private ProductLinesInterface productLinesInterface;
	
	@Autowired
	public void setProductLinesInterface(ProductLinesInterface productLinesInterface) {
		this.productLinesInterface = productLinesInterface;
	}
	
	
	
	@GetMapping("/{productLinesId}/products")
	public Iterable<Products> readAllProductsByProductLinesId(@PathVariable Long productLinesId) {
		return productsInterface.readAllByProductLinesId(productLinesId);
	}
	
	@GetMapping("/{productLinesId}/products/page={pageNumber}/perPage={perPageNumber}")
	public Page<Products> readAllProductsByProductLinesIdPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber,
		@PathVariable Long productLinesId
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return productsInterface.readAllByProductLinesId(productLinesId, page);
	}

	@GetMapping("/{productCode}")
	public Products readOneByProductCode(@PathVariable String productCode) {
		return productsInterface.readOneByProductCode(productCode);
	}
	
	@PutMapping("/{productCode}")
	public Products updateOneByProductCode(@PathVariable String productCode, @RequestBody Products products) {
		
		Products current = productsInterface.readOneByProductCode(productCode);
			
		current.setProductLines(products.getProductLines());
		current.setProductName(products.getProductName());
		current.setQuantityInStock(products.getQuantityInStock());
		current.setProductVendor(products.getProductVendor());
		current.setProductDescription(products.getProductDescription());
		current.setBuyPrice(products.getBuyPrice());
		current.setProductScale(products.getProductScale());
		current.setMsrp(products.getMsrp());
		current.setProductCode(products.getProductCode());
				
		return productsInterface.saveOne(current);
	}

	@DeleteMapping("/{id}/productLines")
	public void deleteOneByIdWhenIricOnManyToOneRelationship(@PathVariable Long id) {
		
		Products current = productsInterface.readOneById(id);
	
		Iterable<Products> listOfProducts = productsInterface
			.readAllByProductLinesId(current.getProductLines().getId());
	
		Long size = listOfProducts.spliterator().getExactSizeIfKnown();
	
		if (size == 1) {
		    return;
		} else {
		    productsInterface.deleteOneById(id);
		}
	}
	
	@PutMapping("/{id}/productLines")
	public Products updateOneByIdWhenIricOnManyToOneRelationship(@PathVariable Long id, @RequestBody Products products) {
	
		Products current = productsInterface.readOneById(id);
	
		if (current.getProductLines().getId() == products.getProductLines().getId()) {
	
			current.setProductLines(products.getProductLines());
			current.setProductName(products.getProductName());
			current.setQuantityInStock(products.getQuantityInStock());
			current.setProductVendor(products.getProductVendor());
			current.setProductDescription(products.getProductDescription());
			current.setBuyPrice(products.getBuyPrice());
			current.setProductScale(products.getProductScale());
			current.setMsrp(products.getMsrp());
			current.setProductCode(products.getProductCode());			
	
			return productsInterface.saveOne(current);
	
		} else {
	
		    Iterable<Products> listOfProducts = productsInterface.readAllByProductLinesId(current.getProductLines().getId());
	
		    Long size = listOfProducts.spliterator().getExactSizeIfKnown();
	
		    if (size == 1) {
				return current;
		    } else {
	
				current.setProductLines(products.getProductLines());
				current.setProductName(products.getProductName());
				current.setQuantityInStock(products.getQuantityInStock());
				current.setProductVendor(products.getProductVendor());
				current.setProductDescription(products.getProductDescription());
				current.setBuyPrice(products.getBuyPrice());
				current.setProductScale(products.getProductScale());
				current.setMsrp(products.getMsrp());
				current.setProductCode(products.getProductCode());			
	
				return productsInterface.saveOne(current);
	
		    }
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@PutMapping("/{productCode}/productLines")
	public Products updateOneByProductCodeWhenIricOnManyToOneRelationship(@PathVariable String productCode, @RequestBody Products products) {
	
		Products current = productsInterface.readOneByProductCode(productCode);
	
		if (current.getProductLines().getId() == products.getProductLines().getId()) {
	
			current.setProductLines(products.getProductLines());
			current.setProductName(products.getProductName());
			current.setQuantityInStock(products.getQuantityInStock());
			current.setProductVendor(products.getProductVendor());
			current.setProductDescription(products.getProductDescription());
			current.setBuyPrice(products.getBuyPrice());
			current.setProductScale(products.getProductScale());
			current.setMsrp(products.getMsrp());
			current.setProductCode(products.getProductCode());			
	
			return productsInterface.saveOne(current);
	
		} else {
	
		    Iterable<Products> listOfProducts = productsInterface.readAllByProductLinesId(current.getProductLines().getId());
	
		    Long size = listOfProducts.spliterator().getExactSizeIfKnown();
	
		    if (size == 1) {
				return current;
		    } else {
	
				current.setProductLines(products.getProductLines());
				current.setProductName(products.getProductName());
				current.setQuantityInStock(products.getQuantityInStock());
				current.setProductVendor(products.getProductVendor());
				current.setProductDescription(products.getProductDescription());
				current.setBuyPrice(products.getBuyPrice());
				current.setProductScale(products.getProductScale());
				current.setMsrp(products.getMsrp());
				current.setProductCode(products.getProductCode());			
	
				return productsInterface.saveOne(current);
	
		    }
		}
	}

//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code
}
