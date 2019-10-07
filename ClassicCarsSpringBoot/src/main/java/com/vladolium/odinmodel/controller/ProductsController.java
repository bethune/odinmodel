package com.vladolium.odinmodel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.format.annotation.*;
import java.time.*;
import java.util.*;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Products;
import com.vladolium.odinmodel.domain.Products.*;
import com.vladolium.odinmodel.service.ProductsService;
import com.vladolium.odinmodel.service.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/products")
public class ProductsController {

	private ProductsService productsService;

	@Autowired
	public void setProductsService(ProductsService productsService) {
		this.productsService = productsService;
	}

	@PostMapping("")
	public Products createOne(@RequestBody Products products) {
		return productsService.createUpdate(products);
	}
	
	
	
	
	
	
	
	
	
	@PutMapping("/{id}")
	public Products updateOneById(@PathVariable Long id, @RequestBody Products products) {
		Products current = productsService.readOneById(id);
		current.setProductLines(products.getProductLines());
		
		current.setQuantityInStock(products.getQuantityInStock());
		
		current.setProductCode(products.getProductCode());
		
		current.setProductVendor(products.getProductVendor());
		
		current.setBuyPrice(products.getBuyPrice());
		
		current.setMSRP(products.getMSRP());
		
		current.setProductScale(products.getProductScale());
		
		current.setProductDescription(products.getProductDescription());
		
		current.setProductName(products.getProductName());
		
					
		return productsService.createUpdate(current);
	}
	
	@PutMapping("/{productCode}")
	public Products updateOneByProductCode(@PathVariable String productCode, @RequestBody Products products) {
		Products current = productsService.readOneByProductCode(productCode);
		current.setProductLines(products.getProductLines());
				
		current.setQuantityInStock(products.getQuantityInStock());
		
		current.setProductCode(products.getProductCode());
		
		current.setProductVendor(products.getProductVendor());
		
		current.setBuyPrice(products.getBuyPrice());
		
		current.setMSRP(products.getMSRP());
		
		current.setProductScale(products.getProductScale());
		
		current.setProductDescription(products.getProductDescription());
		
		current.setProductName(products.getProductName());
		
		
		return productsService.createUpdate(current);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/{id}")
	public Products readOneById(@PathVariable Long id) {
		return productsService.readOneById(id);
	}
	
	@GetMapping("/{productCode}")
	public Products readOneByProductCode(@PathVariable String productCode) {
		return productsService.readOneByProductCode(productCode);
	}
	
	
	
	
	
	
	
	
	@GetMapping("")
	public Iterable<Products> readAll() {
		return productsService.readAll();
	}
	@GetMapping("/{pageNumber}/{perPageNumber}")
	public Page<Products> readAllPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return productsService.readAllPagination(page);
	}
	
	
	
	
	
	
	
	
	@GetMapping("/search")
	public Iterable<Products> search(
		
		
		
		@RequestParam(value = "productLinesId", required = false) Long productLinesId,
		
		@RequestParam(value = "quantityInStock", required = false) Integer quantityInStock,
		@RequestParam(value = "productCode", required = false) String productCode,
		@RequestParam(value = "productVendor", required = false) String productVendor,
		@RequestParam(value = "buyPrice", required = false) Double buyPrice,
		@RequestParam(value = "mSRP", required = false) Double mSRP,
		@RequestParam(value = "productScale", required = false) String productScale,
		@RequestParam(value = "productDescription", required = false) String productDescription,
		@RequestParam(value = "productName", required = false) String productName
		
	) {
		return productsService.search(
				
				
				
			
			
			
			productLinesId,
				
			
			quantityInStock,
			productCode,
			productVendor,
			buyPrice,
			mSRP,
			productScale,
			productDescription,
			productName
			
		);
	}
	
	
	
	
	
	
	
	
	
	
	
	@DeleteMapping("/{id}")
	public void deleteOneById(@PathVariable Long id) {
		productsService.deleteOneById(id);
	}
		

//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code

}
