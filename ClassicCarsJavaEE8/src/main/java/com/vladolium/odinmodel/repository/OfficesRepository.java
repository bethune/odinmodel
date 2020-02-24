package com.vladolium.odinmodel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.*;
import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Offices;
import com.vladolium.odinmodel.model.Offices.*;
import org.springframework.data.querydsl.*;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;





public interface OfficesRepository extends JpaRepository<Offices, Long>, QuerydslPredicateExecutor<Offices> {









Offices findByIdEquals(Long id);







//Code between start and end will not be removed during generation.
//Start of user code for this repository
//End of user code
}