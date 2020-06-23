package com.vladolium.odinmodel.services;

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Gifts.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.time.*;
import java.util.*;

import com.vladolium.odinmodel.repositories.*;
//import com.vladolium.odinmodel.specifications.*;
import com.vladolium.odinmodel.interfaces.*;
import com.vladolium.odinmodel.wrappers.*;

import com.querydsl.core.BooleanBuilder;

@Service
@Transactional
public class GiftsService implements GiftsInterface {

	private GiftsRepository giftsRepository;

	@Autowired
	public void setGiftsRepository(GiftsRepository giftsRepository) {
		this.giftsRepository = giftsRepository;
	}

	@Override
	public Gifts saveOne(Gifts gifts) {
		return giftsRepository.save(gifts);
	}

	@Override
	public void deleteOneById(Long id) {
	    giftsRepository.deleteById(id);
	}
	
	@Override
	public Gifts readOneById(Long id) {
		return giftsRepository.getOne(id);
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
		Boolean isExpired,
		String giftName,
		LocalDateTime beginsOn,
		GiftType giftType,
		LocalDateTime expiresOn
	) {
		BooleanBuilder where = dynamicWhere(
			customersSet,
			isExpired,
			giftName,
			beginsOn,
			giftType,
			expiresOn	
		);
		return giftsRepository.findAll(where);
	}
	
	@Override
	public Page<Gifts> searchPagination(
		Pageable page,
		Set<Long> customersSet,
		Boolean isExpired,
		String giftName,
		LocalDateTime beginsOn,
		GiftType giftType,
		LocalDateTime expiresOn
	) {
		BooleanBuilder where = dynamicWhere(
			customersSet,
			isExpired,
			giftName,
			beginsOn,
			giftType,
			expiresOn
		);
		return giftsRepository.findAll(where, page);
	}
	
	public BooleanBuilder dynamicWhere(
		Set<Long> customersSet,
		Boolean isExpired,
		String giftName,
		LocalDateTime beginsOn,
		GiftType giftType,
		LocalDateTime expiresOn
	) {
		QGifts qGifts = QGifts.gifts;
	
		BooleanBuilder where = new BooleanBuilder();
	
		if (customersSet != null) {
			where.and(qGifts.customersSet.any().id.in(customersSet));
		}
		if (isExpired != null) {
			where.and(qGifts.isExpired.eq(isExpired));
		}
		if (giftName != null) {
			where.and(qGifts.giftName.containsIgnoreCase(giftName));
		}
		if (beginsOn != null) {
			where.and(qGifts.beginsOn.eq(beginsOn));
		}
		if (giftType != null) {
			where.and(qGifts.giftType.eq(giftType));
		}
		if (expiresOn != null) {
			where.and(qGifts.expiresOn.eq(expiresOn));
		}
	
		return where;
	}


	

	@Override
	public Gifts readOneByGiftName(String giftName) {
		return giftsRepository.findByGiftNameEquals(giftName);
	}
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code
}
