package com.vladolium.odinmodel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.format.annotation.*;
import java.time.*;
import java.util.*;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.ProductLines;
import com.vladolium.odinmodel.domain.ProductLines.*;
import com.vladolium.odinmodel.service.ProductLinesService;
import com.vladolium.odinmodel.service.*;
import com.vladolium.odinmodel.wrapperRequest.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/productLines")
public class ProductLinesController {

	private ProductLinesService productLinesService;

	@Autowired
	public void setProductLinesService(ProductLinesService productLinesService) {
		this.productLinesService = productLinesService;
	}

	@PostMapping("")
	public ProductLines createOne(@RequestBody ProductLines productLines) {
		return productLinesService.createUpdate(productLines);
	}
	@PutMapping("/{id}")
	public ProductLines updateOneById(@PathVariable Long id, @RequestBody ProductLines productLines) {
		ProductLines current = productLinesService.readOneById(id);
		
		
		current.setTextDescription(productLines.getTextDescription());
		
		current.setImage(productLines.getImage());
		
		current.setProductLine(productLines.getProductLine());
					
		return productLinesService.createUpdate(current);
	}
	
	
	
	
	
	
	
	
	@GetMapping("/{id}")
	public ProductLines readOneById(@PathVariable Long id) {
		return productLinesService.readOneById(id);
	}
	
	
	
	
	
	
	
	
	@GetMapping("")
	public Iterable<ProductLines> readAll() {
		return productLinesService.readAll();
	}
	
	@GetMapping("/page={pageNumber}/perPage={perPageNumber}")
	public Page<ProductLines> readAllPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return productLinesService.readAllPagination(page);
	}
	
	private ProductsService productsService;
	
	@Autowired
	public void setProductsService(ProductsService productsService) {
		this.productsService = productsService;
	}
	@GetMapping("/{productLinesId}/products")
	public Iterable<Products> readAllProductsByProductLinesId(@PathVariable Long productLinesId) {
		return productsService.readAllByProductLinesId(productLinesId);
	}
	
	@GetMapping("/{productLinesId}/products/page={pageNumber}/perPage={perPageNumber}")
	public Page<Products> readAllProductsByProductLinesIdPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber,
		@PathVariable Long productLinesId
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return productsService.readAllByProductLinesId(productLinesId, page);
	}
	
	
	
	
	
	
	
	
	@GetMapping("/search")
	public Iterable<ProductLines> search(
		@RequestParam(value = "textDescription", required = false) String textDescription,
		@RequestParam(value = "image", required = false) byte[] image,
		@RequestParam(value = "productLine", required = false) String productLine
		
	) {
		return productLinesService.search(
			textDescription,
			image,
			productLine
			
		);
	}
	
	@GetMapping("/search/page={pageNumber}/perPage={perPageNumber}")
	public Page<ProductLines> searchPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber,
		@RequestParam(value = "textDescription", required = false) String textDescription,
		@RequestParam(value = "image", required = false) byte[] image,
		@RequestParam(value = "productLine", required = false) String productLine
		
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
	
		return productLinesService.searchPagination(
			page,
			textDescription,
			image,
			productLine
			
		);
	}
	@DeleteMapping("/{id}")
	public void deleteOneById(@PathVariable Long id) {
		productLinesService.deleteOneById(id);
	}
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code
}
