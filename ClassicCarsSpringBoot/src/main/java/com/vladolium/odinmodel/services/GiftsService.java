package com.vladolium.odinmodel.services;

import com.vladolium.odinmodel.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Transactional;

import java.time.*;
import java.util.*;

import com.vladolium.odinmodel.repositories.*;
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
	public Gifts readOneByGiftName(String giftName) {
		return giftsRepository.findByGiftNameEquals(giftName);
	}
	
	



//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code
}
