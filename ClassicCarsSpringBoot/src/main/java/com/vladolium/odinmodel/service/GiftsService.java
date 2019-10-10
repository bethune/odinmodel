package com.vladolium.odinmodel.service;

import com.vladolium.odinmodel.domain.*;
import java.time.*;
import java.util.*;
import org.springframework.data.domain.*;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Gifts;
import com.vladolium.odinmodel.domain.Gifts.*;

public interface GiftsService {

	// covers create & update
	Gifts createUpdate(Gifts gifts);
	
	
	Gifts readOneById(Long id);
	
	
	
	
	
	
	
	
	
	Gifts readOneByGiftName(String giftName);
	
	
	Iterable<Gifts> readAll();
	
	Page<Gifts> readAllPagination(Pageable page);
	Iterable<Gifts> search(
		Set<Long> customersSet,
		
		
		
		
		
		
		
		
		
		
		
		Boolean isExpired,
		LocalDateTime expiresOn,
		LocalDateTime beginsOn,
		String giftName,
		GiftType giftType
		
	);
	
	Page<Gifts> searchPagination(
		Pageable page,
		Set<Long> customersSet,
		
		
		
		
		
		
		
		
		
		
		
		Boolean isExpired,
		LocalDateTime expiresOn,
		LocalDateTime beginsOn,
		String giftName,
		GiftType giftType
		
	);
	
	
	void deleteOneById(Long id);
	
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this service
//End of user code
}
