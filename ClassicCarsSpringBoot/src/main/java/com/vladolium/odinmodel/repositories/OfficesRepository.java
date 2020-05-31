package com.vladolium.odinmodel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.vladolium.odinmodel.model.Offices;

public interface OfficesRepository extends JpaRepository<Offices, Long>, JpaSpecificationExecutor<Offices> {

	Offices findByIdEquals(Long id);

	

	

//Code between start and end will not be removed during generation.
//Start of user code for this repository
//End of user code
}
