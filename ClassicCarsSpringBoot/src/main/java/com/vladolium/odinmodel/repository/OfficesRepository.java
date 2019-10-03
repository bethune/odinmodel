package com.vladolium.odinmodel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vladolium.odinmodel.domain.Offices;

public interface OfficesRepository extends JpaRepository<Offices, Long> {










Offices findByIdEquals(Long id);











//Code between start and end will not be removed during generation.
//Start of user code for this repository
//End of user code

}
