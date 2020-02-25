package com.vladolium.odinmodel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.*;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Gifts;
import com.vladolium.odinmodel.domain.Gifts.*;
import org.springframework.data.querydsl.*;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;






public interface GiftsRepository extends JpaRepository<Gifts, Long>, QuerydslPredicateExecutor<Gifts> {




Gifts findByGiftNameEquals(String giftName);


Gifts findByIdEquals(Long id);





//Code between start and end will not be removed during generation.
//Start of user code for this repository
//End of user code
}
