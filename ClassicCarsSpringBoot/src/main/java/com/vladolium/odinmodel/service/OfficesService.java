package com.vladolium.odinmodel.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vladolium.odinmodel.domain.Offices;
import com.vladolium.odinmodel.wrapperRequest.OfficesEmployees;

public interface OfficesService {

    // covers create & update
    Offices createUpdate(Offices offices);

    Offices createIric(OfficesEmployees officesEmployees);

    Offices readOneById(Long id);

    Iterable<Offices> readAll();

    Page<Offices> readAllPagination(Pageable page);

    Iterable<Offices> search(String postalCode, String addressLine1, String country, String territory, String phone,
	    String city, String addressLine2, String state

    );

    Page<Offices> searchPagination(Pageable page, String postalCode, String addressLine1, String country,
	    String territory, String phone, String city, String addressLine2, String state

    );

    void deleteOneById(Long id);

//Code between start and end will not be removed during generation.
//Start of user code for this service
//End of user code
}
