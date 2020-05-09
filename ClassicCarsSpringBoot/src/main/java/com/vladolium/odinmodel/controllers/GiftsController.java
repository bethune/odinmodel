package com.vladolium.odinmodel.controllers;

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Gifts.*;

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
@RequestMapping("/api/gifts")
public class GiftsController {

	private GiftsInterface giftsInterface;

	@Autowired
	public void setGiftsInterface(GiftsInterface giftsInterface) {
		this.giftsInterface = giftsInterface;
	}

	@PostMapping("")
	public Gifts saveOne(@RequestBody Gifts gifts) {
		return giftsInterface.saveOne(gifts);
	}

	@DeleteMapping("/{id}")
	public void deleteOneById(@PathVariable Long id) {
		giftsInterface.deleteOneById(id);
	}
	
	@GetMapping("/{id}")
	public Gifts readOneById(@PathVariable Long id) {
		return giftsInterface.readOneById(id);
	}
	
	@PutMapping("/{id}")
	public Gifts updateOneById(@PathVariable Long id, @RequestBody Gifts gifts) {
		
		Gifts current = giftsInterface.readOneById(id);
			
		current.setCustomersSet(gifts.getCustomersSet());
		current.setIsExpired(gifts.getIsExpired());
		current.setExpiresOn(gifts.getExpiresOn());
		current.setGiftName(gifts.getGiftName());
		current.setGiftType(gifts.getGiftType());
		current.setBeginsOn(gifts.getBeginsOn());
				
		return giftsInterface.saveOne(current);
	}


	
//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code
}
