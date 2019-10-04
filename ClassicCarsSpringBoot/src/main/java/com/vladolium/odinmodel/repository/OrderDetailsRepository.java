package com.vladolium.odinmodel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.vladolium.odinmodel.domain.OrderDetails;

@Repository
@Transactional
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {







OrderDetails findByIdEquals(Long id);






//Code between start and end will not be removed during generation.
//Start of user code for this repository
//End of user code

}
