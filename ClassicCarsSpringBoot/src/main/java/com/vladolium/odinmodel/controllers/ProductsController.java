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
	
						
	
			return productsInterface.saveOne(current);
	
		} else {
	
		    Iterable<Products> listOfProducts = productsInterface.readAllByProductLinesId(current.getProductLines().getId());
	
		    Long size = listOfProducts.spliterator().getExactSizeIfKnown();
	
		    if (size == 1) {
				return current;
		    } else {
	
							
	
				return productsInterface.saveOne(current);
	
		    }
		}
	}
//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code
}
