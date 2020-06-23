package com.vladolium.odinmodel.repositories;

import com.vladolium.odinmodel.model.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.domain.*;
import org.springframework.data.querydsl.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface GiftsRepository extends JpaRepository<Gifts, Long>, QuerydslPredicateExecutor<Gifts> {

	Gifts findByGiftNameEquals(String giftName);
	
	Gifts findByIdEquals(Long id);

	

	

//Code between start and end will not be removed during generation.
//Start of user code for this repository
//End of user code
}
