package com.vladolium.odinmodel.interfaces;

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Gifts.*;

import java.time.*;
import java.util.*;

import org.springframework.data.domain.*;

import com.vladolium.odinmodel.wrappers.*;

public interface GiftsInterface {

	Gifts saveOne(Gifts gifts);
	
	void deleteOneById(Long id);
	
	Gifts readOneById(Long id);

	Iterable<Gifts> readAll();
	
	Page<Gifts> readAllPagination(Pageable page);

	Iterable<Gifts> search(
		Set<Long> customersSet,
		Boolean isExpired,
		String giftName,
		LocalDateTime beginsOn,
		GiftType giftType,
		LocalDateTime expiresOn
	);
	
	Page<Gifts> searchPagination(
		Pageable page,
		Set<Long> customersSet,
		Boolean isExpired,
		String giftName,
		LocalDateTime beginsOn,
		GiftType giftType,
		LocalDateTime expiresOn
	);

	

	Gifts readOneByGiftName(String giftName);

	

//Code between start and end will not be removed during generation.
//Start of user code for this interface
//End of user code
}
