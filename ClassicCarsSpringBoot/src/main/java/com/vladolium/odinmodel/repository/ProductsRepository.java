package com.vladolium.odinmodel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.*;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Products;
import com.vladolium.odinmodel.domain.Products.*;
import org.springframework.data.querydsl.*;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;








public interface ProductsRepository extends JpaRepository<Products, Long>, QuerydslPredicateExecutor<Products> {









Products findByIdEquals(Long id);

Products findByProductCodeEquals(String productCode);





Iterable <Products> findByProductLinesIdEquals(Long productLinesId);

Page <Products> findByProductLinesIdEquals(Long productLinesId, Pageable page);







//Code between start and end will not be removed during generation.
//Start of user code for this repository
//End of user code
}
