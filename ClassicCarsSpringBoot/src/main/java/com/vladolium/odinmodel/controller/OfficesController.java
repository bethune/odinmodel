
package com.vladolium.odinmodel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.format.annotation.*;

import java.time.*;
import java.util.*;

import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Offices;
import com.vladolium.odinmodel.domain.Offices.*;
import com.vladolium.odinmodel.service.OfficesService;
import com.vladolium.odinmodel.service.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/offices")
public class OfficesController {

	private OfficesService officesService;

	@Autowired
	public void setOfficesService(OfficesService officesService) {
		this.officesService = officesService;
	}

@PostMapping("")
public Offices createOne(@RequestBody Offices offices) {
	return officesService.createUpdate(offices);
}

//Code between start and end will not be removed during generation.
//Start of user code controller
//End of user code

}
