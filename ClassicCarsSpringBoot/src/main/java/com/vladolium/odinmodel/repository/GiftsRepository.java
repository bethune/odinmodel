package com.vladolium.odinmodel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.vladolium.odinmodel.domain.Gifts;

import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Gifts;
import com.vladolium.odinmodel.domain.Gifts.*;

@Repository
@Transactional
public interface GiftsRepository extends JpaRepository<Gifts, Long> {








Gifts findByIdEquals(Long id);

Gifts findByGiftNameEquals(String giftName);







//Code between start and end will not be removed during generation.
//Start of user code for this repository
//End of user code
}
