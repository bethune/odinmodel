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
import com.vladolium.odinmodel.wrapper.*;

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
	
	
	
	
	
	
	
	
	
	
	
	
	
	@PutMapping("/{id}/productLines")
	public Products updateOneByIdIric(@PathVariable Long id, @RequestBody Products products) {
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
	
	
	
	
	@PutMapping("/productCode={productCode}")
	public Products updateOneByProductCode(@PathVariable String productCode, @RequestBody Products products) {
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
	
	
	
	
	
	
	
	
	
	
	
	
	@PutMapping("/productCode={productCode}/productLines")
	public Products updateOneByProductCodeIric(@PathVariable String productCode, @RequestBody Products products) {
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/{id}")
	public Products readOneById(@PathVariable Long id) {
		return productsService.readOneById(id);
	}
	
	
	
	
	@GetMapping("/productCode={productCode}")
	public Products readOneByProductCode(@PathVariable String productCode) {
		return productsService.readOneByProductCode(productCode);
	}
	
	
	
	
	
	
	
	
	@GetMapping("")
	public Iterable<Products> readAll() {
		return productsService.readAll();
	}
	
	@GetMapping("/page={pageNumber}/perPage={perPageNumber}")
	public Page<Products> readAllPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return productsService.readAllPagination(page);
	}
	
	private OrderDetailsService orderDetailsService;
	
	@Autowired
	public void setOrderDetailsService(OrderDetailsService orderDetailsService) {
		this.orderDetailsService = orderDetailsService;
	}
	
	
	
	
	
	
	
	@GetMapping("/{productsId}/orderDetails")
	public Iterable<OrderDetails> readAllOrderDetailsByProductsId(@PathVariable Long productsId) {
		return orderDetailsService.readAllByProductsId(productsId);
	}
	
	@GetMapping("/{productsId}/orderDetails/page={pageNumber}/perPage={perPageNumber}")
	public Page<OrderDetails> readAllOrderDetailsByProductsIdPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber,
		@PathVariable Long productsId
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return orderDetailsService.readAllByProductsId(productsId, page);
	}
	
	
	
	
	@GetMapping("/productCode={productsProductCode}/orderDetails")
	public Iterable<OrderDetails> readAllOrderDetailsByProductsProductCode(@PathVariable String productsProductCode) {
		return orderDetailsService.readAllByProductsProductCode(productsProductCode);
	}
	
	@GetMapping("/productCode={productsProductCode}/orderDetails/page={pageNumber}/perPage={perPageNumber}")
	public Page<OrderDetails> readAllOrderDetailsByProductsProductCodePagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber,
		@PathVariable String productsProductCode
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return orderDetailsService.readAllByProductsProductCode(productsProductCode, page);
	}
	
	
	
	
	
	
	
	
	@GetMapping("/search")
	public Iterable<Products> search(
		
		
		
		@RequestParam(value = "productLinesId", required = false) Long productLinesId,
		@RequestParam(value = "productDescription", required = false) String productDescription,
		@RequestParam(value = "productCode", required = false) String productCode,
		@RequestParam(value = "msrp", required = false) Double msrp,
		@RequestParam(value = "quantityInStock", required = false) Integer quantityInStock,
		@RequestParam(value = "buyPrice", required = false) Double buyPrice,
		@RequestParam(value = "productName", required = false) String productName,
		@RequestParam(value = "productScale", required = false) String productScale,
		@RequestParam(value = "productVendor", required = false) String productVendor
		
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
	
	@GetMapping("/search/page={pageNumber}/perPage={perPageNumber}")
	public Page<Products> searchPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber,
		
		
		
		@RequestParam(value = "productLinesId", required = false) Long productLinesId,
		@RequestParam(value = "productDescription", required = false) String productDescription,
		@RequestParam(value = "productCode", required = false) String productCode,
		@RequestParam(value = "msrp", required = false) Double msrp,
		@RequestParam(value = "quantityInStock", required = false) Integer quantityInStock,
		@RequestParam(value = "buyPrice", required = false) Double buyPrice,
		@RequestParam(value = "productName", required = false) String productName,
		@RequestParam(value = "productScale", required = false) String productScale,
		@RequestParam(value = "productVendor", required = false) String productVendor
		
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
	
	
	
	
	
	
	
	@DeleteMapping("/{id}")
	public void deleteOneById(@PathVariable Long id) {
		productsService.deleteOneById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@DeleteMapping("/{id}/productLines")
	public void deleteOneByIdIric(@PathVariable Long id) {
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
//Start of user code for this controller
//End of user code
}
