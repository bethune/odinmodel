package com.vladolium.odinmodel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.format.annotation.*;
import java.time.*;
import java.util.*;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Gifts;
import com.vladolium.odinmodel.domain.Gifts.*;
import com.vladolium.odinmodel.service.GiftsService;
import com.vladolium.odinmodel.service.*;
import com.vladolium.odinmodel.wrapper.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/gifts")
public class GiftsController {

	private GiftsService giftsService;

	@Autowired
	public void setGiftsService(GiftsService giftsService) {
		this.giftsService = giftsService;
	}

	@PostMapping("")
	public Gifts createOne(@RequestBody Gifts gifts) {
		return giftsService.createUpdate(gifts);
	}
	
	
	
	@GetMapping("/{id}")
	public Gifts readOneById(@PathVariable Long id) {
		return giftsService.readOneById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/giftName={giftName}")
	public Gifts readOneByGiftName(@PathVariable String giftName) {
		return giftsService.readOneByGiftName(giftName);
	}
	
	@GetMapping("")
	public Iterable<Gifts> readAll() {
		return giftsService.readAll();
	}
	
	@GetMapping("/page={pageNumber}/perPage={perPageNumber}")
	public Page<Gifts> readAllPagination(
		@PathVariable Integer pageNumber,
		@PathVariable Integer perPageNumber
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return giftsService.readAllPagination(page);
	}
	
	
	
	@DeleteMapping("/{id}")
	public void deleteOneById(@PathVariable Long id) {
		giftsService.deleteOneById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code
}
