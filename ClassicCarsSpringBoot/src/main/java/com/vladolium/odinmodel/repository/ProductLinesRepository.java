package com.vladolium.odinmodel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.*;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.ProductLines;
import com.vladolium.odinmodel.domain.ProductLines.*;
import org.springframework.data.querydsl.*;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;




public interface ProductLinesRepository extends JpaRepository<ProductLines, Long>, QuerydslPredicateExecutor<ProductLines> {




ProductLines findByIdEquals(Long id);





//Code between start and end will not be removed during generation.
//Start of user code for this repository
//End of user code
}
