package com.vladolium.odinmodel.service;

import com.vladolium.odinmodel.domain.*;
import java.time.*;
import java.util.*;
import org.springframework.data.domain.*;

public interface ProductsService {

// covers create & update
Products createUpdate(Products products);











Products readOneById(Long id);



Products readOneByProductCode(String productCode);




















void deleteOneById(Long id);



//Code between start and end will not be removed during generation.
//Start of user code for this service
//End of user code

}
