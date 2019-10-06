
package com.vladolium.odinmodel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.format.annotation.*;

import java.time.*;
import java.util.*;

import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.service.GiftsService;
import com.vladolium.odinmodel.service.*;

import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Gifts;
import com.vladolium.odinmodel.domain.Gifts.*;

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



@PutMapping("/{id}")
public Gifts updateOneById(@PathVariable Long id, @RequestBody Gifts gifts) {
	Gifts current = giftsService.readOneById(id);
	current.setCustomersSet(gifts.getCustomersSet());

	current.setGiftName(gifts.getGiftName());

	current.setGiftType(gifts.getGiftType());

	current.setIsExpired(gifts.getIsExpired());

	current.setBeginsOn(gifts.getBeginsOn());

	current.setExpiresOn(gifts.getExpiresOn());
	return giftsService.createUpdate(current);
}









@PutMapping("/{giftName}")
public Gifts updateOneByGiftName(@PathVariable String giftName, @RequestBody Gifts gifts) {
	Gifts current = giftsService.readOneByGiftName(giftName);
	current.setCustomersSet(gifts.getCustomersSet());
	current.setGiftName(gifts.getGiftName());

	return giftsService.createUpdate(current);
}








@GetMapping("/{id}")
public Gifts readOneById(@PathVariable Long id) {
	return giftsService.readOneById(id);
}









@GetMapping("/{giftName}")
public Gifts readOneByGiftName(@PathVariable String giftName) {
	return giftsService.readOneByGiftName(giftName);
}








@GetMapping("")
public Iterable<Gifts> readAll() {
	return giftsService.readAll();
}


@GetMapping("/{pageNumber}/{perPageNumber}")
public Page<Gifts> readAllPagination(
	@PathVariable Integer pageNumber,
	@PathVariable Integer perPageNumber
) {
	Pageable page = PageRequest.of(pageNumber, perPageNumber);
	return giftsService.readAllPagination(page);
}










@GetMapping("/search")
public Iterable<Gifts> search(



	@RequestParam(value = "customersSet[]", required = false) Set<Long> customersSet,










	@RequestParam(value = "giftName", required = false) String giftName,
	@RequestParam(value = "giftType", required = false) GiftType giftType,
	@RequestParam(value = "isExpired", required = false) Boolean isExpired,
	@RequestParam(value = "beginsOn", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") LocalDateTime beginsOn,
	@RequestParam(value = "expiresOn", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") LocalDateTime expiresOn
) {
	return giftsService.search(
	customersSet,
	giftName,
	giftType,
	isExpired,
	beginsOn,
	expiresOn
	);
}







@DeleteMapping("/{id}")
public void deleteOneById(@PathVariable Long id) {
	giftsService.deleteOneById(id);
}







	

//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code

}
