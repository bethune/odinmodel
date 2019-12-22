package com.vladolium.odinmodel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.*;
import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.OrderDetails;
import com.vladolium.odinmodel.model.OrderDetails.*;
import org.springframework.data.querydsl.*;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;




public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long>, QuerydslPredicateExecutor<OrderDetails> {





OrderDetails findByIdEquals(Long id);








Iterable <OrderDetails> findByProductsIdEquals(Long productsId);

Page <OrderDetails> findByProductsIdEquals(Long productsId, Pageable page);




Iterable <OrderDetails> findByProductsProductCodeEquals(String productsProductCode);

Page <OrderDetails> findByProductsProductCodeEquals(String productsProductCode, Pageable page);








//Code between start and end will not be removed during generation.
//Start of user code for this repository
//End of user code
}
