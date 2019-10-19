package com.vladolium.odinmodel.serviceImpl;

import com.vladolium.odinmodel.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Transactional;
import java.time.*;
import java.util.*;
import com.vladolium.odinmodel.repository.*;
import com.vladolium.odinmodel.repository.GiftsRepository;
import com.vladolium.odinmodel.service.GiftsService;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Gifts;
import com.vladolium.odinmodel.domain.Gifts.*;
import com.vladolium.odinmodel.wrapperRequest.*;
import com.querydsl.core.BooleanBuilder;

@Service
@Transactional
public class GiftsServiceImpl implements GiftsService {

	private GiftsRepository giftsRepository;

	@Autowired
	public void setGiftsRepository(GiftsRepository giftsRepository) {
		this.giftsRepository = giftsRepository;
	}

	// covers create & update
	@Override
	public Gifts createUpdate(Gifts gifts) {
		return giftsRepository.save(gifts);
	}
	
	
	
	
	
	@Override
	public Gifts readOneById(Long id) {
		return giftsRepository.getOne(id);
	}
	
	
	
	
	
	
	@Override
	public Gifts readOneByGiftName(String giftName) {
		return giftsRepository.findByGiftNameEquals(giftName);
	}
	
	
	
	
	@Override
	public Iterable<Gifts> readAll() {
		return giftsRepository.findAll();
	}
	
	@Override
	public Page<Gifts> readAllPagination(Pageable page) {
		return giftsRepository.findAll(page);
	}
	
	
	
	@Override
	public Iterable<Gifts> search(
		Set<Long> customersSet,
		
		
		
		
		
		
		
		
		
		
		
		LocalDateTime beginsOn,
		GiftType giftType,
		String giftName,
		LocalDateTime expiresOn,
		Boolean isExpired
		
	) {
		BooleanBuilder where = dynamicWhere(
			customersSet,
			beginsOn,
			giftType,
			giftName,
			expiresOn,
			isExpired
				
		);
		return giftsRepository.findAll(where);
	}
	
	@Override
	public Page<Gifts> searchPagination(
		Pageable page,
		Set<Long> customersSet,
		
		
		
		
		
		
		
		
		
		
		
		LocalDateTime beginsOn,
		GiftType giftType,
		String giftName,
		LocalDateTime expiresOn,
		Boolean isExpired
		
	) {
		BooleanBuilder where = dynamicWhere(
			customersSet,
			beginsOn,
			giftType,
			giftName,
			expiresOn,
			isExpired
			
		);
		return giftsRepository.findAll(where, page);
	}
	
	public BooleanBuilder dynamicWhere(
		Set<Long> customersSet,
		
		
		
		
		
		
		
		
		
		
		
		LocalDateTime beginsOn,
		GiftType giftType,
		String giftName,
		LocalDateTime expiresOn,
		Boolean isExpired
		
	) {
		QGifts qGifts = QGifts.gifts;
	
		BooleanBuilder where = new BooleanBuilder();
	
		if (customersSet != null) {
			where.and(qGifts.customersSet.any().id.in(customersSet));
		}
		
		
		
		
		
		
		
		
		
		
		
		if (beginsOn != null) {
			where.and(qGifts.beginsOn.eq(beginsOn));
		}
		if (giftType != null) {
			where.and(qGifts.giftType.eq(giftType));
		}
		if (giftName != null) {
			where.and(qGifts.giftName.containsIgnoreCase(giftName));
		}
		if (expiresOn != null) {
			where.and(qGifts.expiresOn.eq(expiresOn));
		}
		if (isExpired != null) {
			where.and(qGifts.isExpired.eq(isExpired));
		}
		
	
		return where;
	}
	
	
	
	
	@Override
	public void deleteOneById(Long id) {
	}
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code
}
