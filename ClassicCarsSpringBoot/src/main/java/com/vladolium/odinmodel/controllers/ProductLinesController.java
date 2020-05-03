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
//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code
}
