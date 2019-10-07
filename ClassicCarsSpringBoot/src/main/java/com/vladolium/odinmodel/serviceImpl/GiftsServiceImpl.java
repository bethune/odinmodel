package com.vladolium.odinmodel.serviceImpl;

import com.vladolium.odinmodel.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;
import java.time.*;
import java.util.*;
import com.vladolium.odinmodel.repository.GiftsRepository;
import com.vladolium.odinmodel.service.GiftsService;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Gifts;
import com.vladolium.odinmodel.domain.Gifts.*;
import static org.jooq.impl.DSL.*;

@Service
public class GiftsServiceImpl implements GiftsService {

	private final DSLContext jooq;

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
		
		
		
		
		
		
		
		
		
		
		String giftName,
		GiftType giftType,
		Boolean isExpired,
		LocalDateTime beginsOn,
		LocalDateTime expiresOn
		
	) {
		Condition condition = dynamicCondition(
			
			
			Set<Long> customersSet,
			
			
			
			
			
			
			
			
			
			
			giftName,
			giftType,
			isExpired,
			beginsOn,
			expiresOn
		);
		return giftsRepository.findAll(condition);
	}
	public Condition dynamicCondition(
		
		
		Set<Long> customersSet,
		
		
		
		
		
		
		
		
		
		
		String giftName,
		GiftType giftType,
		Boolean isExpired,
		LocalDateTime beginsOn,
		LocalDateTime expiresOn
		
	) {
		Condition condition = trueCondition();
	
	
	
			if (customersSet != null) {
				where.and(qGifts.customersSet.any().id.in(customersSet));
			}
	
	
	
	
	
	
	
	
	
			if (giftName != null) {
				where.and(qGifts.giftName.containsIgnoreCase(giftName));
			}
			if (giftType != null) {
				where.and(qGifts.giftType.eq(giftType));
			}
			if (isExpired != null) {
				where.and(qGifts.isExpired.eq(isExpired));
			}
			if (beginsOn != null) {
				where.and(qGifts.beginsOn.eq(beginsOn));
			}
			if (expiresOn != null) {
				where.and(qGifts.expiresOn.eq(expiresOn));
			}
	
			return where;
		}
	
	@Override
	public void deleteOneById(Long id) {
		giftsRepository.deleteById(id);
	}
	
	
	
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code

}
