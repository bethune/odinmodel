package com.vladolium.odinmodel.view;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.*;
//import org.springframework.format.annotation.*;
import java.time.*;
import java.util.*;
import java.io.Serializable;
import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Gifts;
import com.vladolium.odinmodel.model.Gifts.*;
import com.vladolium.odinmodel.service.GiftsService;
import com.vladolium.odinmodel.service.*;
import com.vladolium.odinmodel.wrapper.*;

@Named
@ViewScoped
public class GiftsView implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private GiftsService giftsService;

	
	private Gifts gifts;
	
	public Gifts createOne() {
		return giftsService.createUpdate(gifts);
	}
	
	
	
	
	
	
	
	public Gifts updateOneById(Long id) {
		Gifts current = giftsService.readOneById(id);
		current.setCustomersSet(gifts.getCustomersSet());
		
		current.setIsExpired(gifts.getIsExpired());
		
		current.setGiftType(gifts.getGiftType());
		
		current.setGiftName(gifts.getGiftName());
		
		current.setBeginsOn(gifts.getBeginsOn());
		
		
		current.setExpiresOn(gifts.getExpiresOn());
					
		return giftsService.createUpdate(current);
	}
	
	
	
	
	
	
	
	
	
	
	
	public Gifts updateOneByGiftName(String giftName) {
		Gifts current = giftsService.readOneByGiftName(giftName);
		current.setCustomersSet(gifts.getCustomersSet());
		
		current.setIsExpired(gifts.getIsExpired());
		
		current.setGiftType(gifts.getGiftType());
		
		current.setGiftName(gifts.getGiftName());
		
		current.setBeginsOn(gifts.getBeginsOn());
		
		
		current.setExpiresOn(gifts.getExpiresOn());
					
		return giftsService.createUpdate(current);		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Gifts readOneById(Long id) {
		return giftsService.readOneById(id);
	}
	
	
	
	
	public Gifts readOneByGiftName(String giftName) {
		return giftsService.readOneByGiftName(giftName);
	}
	
	
	
	
	public Iterable<Gifts> readAll() {
		return giftsService.readAll();
	}
	
	public Page<Gifts> readAllPagination(
		Integer pageNumber,
		Integer perPageNumber
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return giftsService.readAllPagination(page);
	}
	
	
	public Iterable<Gifts> search(
		
		
		
		
		Set<Long> customersSet,
		
		
		
		
		
		
		
		Boolean isExpired,
		GiftType giftType,
		String giftName,
		LocalDateTime beginsOn,
		LocalDateTime expiresOn
		
	) {
		return giftsService.search(
			customersSet,
			isExpired,
			giftType,
			giftName,
			beginsOn,
			expiresOn
			
		);
	}
	
	public Page<Gifts> searchPagination(
		Integer pageNumber,
		Integer perPageNumber,
		
		
		
		
		Set<Long> customersSet,
		
		
		
		
		
		
		
		Boolean isExpired,
		GiftType giftType,
		String giftName,
		LocalDateTime beginsOn,
		LocalDateTime expiresOn
		
	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
	
		return giftsService.searchPagination(
			page,
			customersSet,
			isExpired,
			giftType,
			giftName,
			beginsOn,
			expiresOn
			
		);
	}
	
	
	
	
	
	public void deleteOneById(Long id) {
		giftsService.deleteOneById(id);
	}
	
	
	
	
	
	
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this view
//End of user code
}
