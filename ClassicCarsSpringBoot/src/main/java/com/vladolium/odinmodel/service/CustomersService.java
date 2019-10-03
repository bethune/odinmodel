package com.vladolium.odinmodel.service;

import com.vladolium.odinmodel.domain.*;
import java.time.*;
import java.util.*;
import org.springframework.data.domain.*;

public interface CustomersService {

// covers create & update
Customers createUpdate(Customers customers);





Customers readOneById(Long id);





















Customers readOneByCustomerName(String customerName);









void deleteOneById(Long id);













//Code between start and end will not be removed during generation.
//Start of user code for this service
//End of user code

}
