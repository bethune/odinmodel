package com.vladolium.odinmodel.controllers;

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.ProductLines.*;

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
@RequestMapping("/api/productLines")
public class ProductLinesController {

	private ProductLinesInterface productLinesInterface;

	@Autowired
	public void setProductLinesInterface(ProductLinesInterface productLinesInterface) {
		this.productLinesInterface = productLinesInterface;
	}

	@PostMapping("")
	public ProductLines saveOne(@RequestBody ProductLines productLines) {
		return productLinesInterface.saveOne(productLines);
	}

	@DeleteMapping("/{id}")
	public void deleteOneById(@PathVariable Long id) {
		productLinesInterface.deleteOneById(id);
	}
	
	@GetMapping("/{id}")
	public ProductLines readOneById(@PathVariable Long id) {
		return productLinesInterface.readOneById(id);
	}
	
	@PutMapping("/{id}")
	public ProductLines updateOneById(@PathVariable Long id, @RequestBody ProductLines productLines) {
		
		ProductLines current = productLinesInterface.readOneById(id);
			
		current.setImage(productLines.getImage());
		current.setTextDescription(productLines.getTextDescription());
		current.setProductLine(productLines.getProductLine());
				
		return productLinesInterface.saveOne(current);
	}

	@GetMapping("")
	public Iterable<ProductLines> readAll() {
		return productLinesInterface.readAll();
	}
	
	@GetMapping("/page={pageNumber}/perPage={perPageNumber}")
	public Page<ProductLines> readAllPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return productLinesInterface.readAllPagination(page);
	}

	@GetMapping("/search")
	public Iterable<ProductLines> search(
		byte[] image,
		String textDescription,
		String productLine
	) {
		return productLinesInterface.search(
			image,
			textDescription,
			productLine
		);
	}
	
	@GetMapping("/search/page={pageNumber}/perPage={perPageNumber}")
	public Page<ProductLines> searchPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber,
		byte[] image,
		String textDescription,
		String productLine
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
	
		return productLinesInterface.searchPagination(
			page,
			image,
			textDescription,
			productLine
		);
	}

	private ProductsInterface productsInterface;
	
	@Autowired
	public void setProductsInterface(ProductsInterface productsInterface) {
		this.productsInterface = productsInterface;
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

	

	@PostMapping("/products")
	public ProductLines saveOneWhenIricOnManyToOneRelationship(@RequestBody ProductLinesProducts productLinesProducts) {
		return productLinesInterface.saveOneWhenIricOnManyToOneRelationship(productLinesProducts);
	}

//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code
}
