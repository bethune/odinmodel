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
import com.vladolium.odinmodel.wrapperRequest.*;

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
		
		current.setProductVendor(products.getProductVendor());
		
		current.setMsrp(products.getMsrp());
		
		current.setProductName(products.getProductName());
		
		current.setProductScale(products.getProductScale());
		
		current.setProductDescription(products.getProductDescription());
		
		current.setQuantityInStock(products.getQuantityInStock());
		
		
		current.setProductCode(products.getProductCode());
		
		current.setBuyPrice(products.getBuyPrice());
					
		return productsService.createUpdate(current);
	}
	
	
	
	
	
	
	
	
	
	
	@PutMapping("/productCode={productCode}")
	public Products updateOneByProductCode(@PathVariable String productCode, @RequestBody Products products) {
		Products current = productsService.readOneByProductCode(productCode);
		current.setProductLines(products.getProductLines());
				
		current.setProductVendor(products.getProductVendor());
		
		current.setMsrp(products.getMsrp());
		
		current.setProductName(products.getProductName());
		
		current.setProductScale(products.getProductScale());
		
		current.setProductDescription(products.getProductDescription());
		
		current.setQuantityInStock(products.getQuantityInStock());
		
		
		current.setProductCode(products.getProductCode());
		
		current.setBuyPrice(products.getBuyPrice());
		
		return productsService.createUpdate(current);
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
		@RequestParam(value = "productVendor", required = false) String productVendor,
		@RequestParam(value = "msrp", required = false) Double msrp,
		@RequestParam(value = "productName", required = false) String productName,
		@RequestParam(value = "productScale", required = false) String productScale,
		@RequestParam(value = "productDescription", required = false) String productDescription,
		@RequestParam(value = "quantityInStock", required = false) Integer quantityInStock,
		@RequestParam(value = "productCode", required = false) String productCode,
		@RequestParam(value = "buyPrice", required = false) Double buyPrice
		
	) {
		return productsService.search(
			
			
			
			productLinesId,
			productVendor,
			msrp,
			productName,
			productScale,
			productDescription,
			quantityInStock,
			productCode,
			buyPrice
			
		);
	}
	
	@GetMapping("/search/page={pageNumber}/perPage={perPageNumber}")
	public Page<Products> searchPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber,
		
		
		
		@RequestParam(value = "productLinesId", required = false) Long productLinesId,
		@RequestParam(value = "productVendor", required = false) String productVendor,
		@RequestParam(value = "msrp", required = false) Double msrp,
		@RequestParam(value = "productName", required = false) String productName,
		@RequestParam(value = "productScale", required = false) String productScale,
		@RequestParam(value = "productDescription", required = false) String productDescription,
		@RequestParam(value = "quantityInStock", required = false) Integer quantityInStock,
		@RequestParam(value = "productCode", required = false) String productCode,
		@RequestParam(value = "buyPrice", required = false) Double buyPrice
		
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
	
		return productsService.searchPagination(
			page,
			
			
			
			productLinesId,
			productVendor,
			msrp,
			productName,
			productScale,
			productDescription,
			quantityInStock,
			productCode,
			buyPrice
			
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
