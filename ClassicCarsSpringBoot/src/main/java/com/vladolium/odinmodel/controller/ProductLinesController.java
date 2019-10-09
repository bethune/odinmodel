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

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/productLines")
public class ProductLinesController {

	private ProductLinesService productLinesService;

	@Autowired
	public void setProductLinesService(ProductLinesService productLinesService) {
		this.productLinesService = productLinesService;
	}

	
	
	
	@GetMapping("/{id}")
	public ProductLines readOneById(@PathVariable Long id) {
		return productLinesService.readOneById(id);
	}
	
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code

}
