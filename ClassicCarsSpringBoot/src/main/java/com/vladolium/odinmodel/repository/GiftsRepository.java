package com.vladolium.odinmodel.repository; 

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Gifts;
import com.vladolium.odinmodel.model.Gifts.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.*;

import org.springframework.data.querydsl.*;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;



public interface GiftsRepository extends JpaRepository<Gifts, Long>, QuerydslPredicateExecutor<Gifts> {





	Gifts findByGiftNameEquals(String giftName);
	
	
	Gifts findByIdEquals(Long id);
	
	
	
	

	

	

//Code between start and end will not be removed during generation.
//Start of user code for this repository
//End of user code
}
