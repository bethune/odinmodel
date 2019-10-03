
package com.vladolium.odinmodel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.format.annotation.*;

import java.time.*;
import java.util.*;

import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.service.ProductLinesService;
import com.vladolium.odinmodel.service.*;

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
	current.setImage(productLines.getImage());

	current.setTextDescription(productLines.getTextDescription());

	current.setProductLine(productLines.getProductLine());

	return productLinesService.createUpdate(current);
}














//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code

}
