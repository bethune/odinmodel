package com.vladolium.odinmodel.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.inject.Inject;
import javax.annotation.PostConstruct;
import com.vladolium.odinmodel.model.*;
import java.time.*;
import java.util.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.querydsl.*;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import com.querydsl.core.BooleanBuilder;
import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Gifts;
import com.vladolium.odinmodel.model.Gifts.*;
import com.vladolium.odinmodel.repository.*;
import com.vladolium.odinmodel.repository.GiftsRepository;
import com.vladolium.odinmodel.wrapper.*;

@Stateless
public class GiftsService {

 	@PersistenceContext
    private EntityManager em;

	private GiftsRepository giftsRepository;
	
	@PostConstruct
	private void init() {
		RepositoryFactorySupport factory = new JpaRepositoryFactory(em);
		this.giftsRepository = factory.getRepository(GiftsRepository.class);
	}

	// covers create, update and update with IRIC
	public Gifts createUpdate(Gifts gifts) {
		return giftsRepository.save(gifts);
	}
	
	
	
	
	
	
	
	public Gifts readOneById(Long id) {
		return giftsRepository.getOne(id);
	}
	
	
	
	
	public Gifts readOneByGiftName(String giftName) {
		return giftsRepository.findByGiftNameEquals(giftName);
	}
	
	
	
	
	public Iterable<Gifts> readAll() {
		return giftsRepository.findAll();
	}
	
	public Page<Gifts> readAllPagination(Pageable page) {
		return giftsRepository.findAll(page);
	}
	
	
	
	public Iterable<Gifts> search(
		
		
		
		
		Set<Long> customersSet,
		
		
		
		
		
		
		
		Boolean isExpired,
		GiftType giftType,
		String giftName,
		LocalDateTime beginsOn,
		LocalDateTime expiresOn
		
	) {
		BooleanBuilder where = dynamicWhere(
			customersSet,
			isExpired,
			giftType,
			giftName,
			beginsOn,
			expiresOn
				
		);
		return giftsRepository.findAll(where);
	}
	
	public Page<Gifts> searchPagination(
		Pageable page,
		
		
		
		
		Set<Long> customersSet,
		
		
		
		
		
		
		
		Boolean isExpired,
		GiftType giftType,
		String giftName,
		LocalDateTime beginsOn,
		LocalDateTime expiresOn
		
	) {
		BooleanBuilder where = dynamicWhere(
			customersSet,
			isExpired,
			giftType,
			giftName,
			beginsOn,
			expiresOn
			
		);
		return giftsRepository.findAll(where, page);
	}
	
	public BooleanBuilder dynamicWhere(
		
		
		
		
		Set<Long> customersSet,
		
		
		
		
		
		
		
		Boolean isExpired,
		GiftType giftType,
		String giftName,
		LocalDateTime beginsOn,
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
		if (giftType != null) {
			where.and(qGifts.giftType.eq(giftType));
		}
		if (giftName != null) {
			where.and(qGifts.giftName.containsIgnoreCase(giftName));
		}
		if (beginsOn != null) {
			where.and(qGifts.beginsOn.eq(beginsOn));
		}
		if (expiresOn != null) {
			where.and(qGifts.expiresOn.eq(expiresOn));
		}
		
	
		return where;
	}
	
	
	
	
	
	
	public void deleteOneById(Long id) {
	    giftsRepository.deleteById(id);
	}
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this service
//End of user code
}
