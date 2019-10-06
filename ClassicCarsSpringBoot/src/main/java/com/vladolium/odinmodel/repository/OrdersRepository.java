package com.vladolium.odinmodel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.vladolium.odinmodel.domain.Orders;

import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Orders;
import com.vladolium.odinmodel.domain.Orders.*;






@Repository
@Transactional
public interface OrdersRepository extends JpaRepository<Orders, Long> {







Orders findByIdEquals(Long id);




//Code between start and end will not be removed during generation.
//Start of user code for this repository
//End of user code
}
