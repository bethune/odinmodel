package com.vladolium.odinmodel.service;

import com.vladolium.odinmodel.domain.*;
import java.time.*;
import java.util.*;
import org.springframework.data.domain.*;

import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Payments;
import com.vladolium.odinmodel.domain.Payments.*;

public interface PaymentsService {


// covers create & update
Payments createUpdate(Payments payments);




Payments readOneById(Long id);














Iterable<Payments> readAll();


Page<Payments> readAllPagination(Pageable page);



Iterable<Payments> search(


	Long customersId,









	Double amount,
	String checkNumber,
	LocalDate paymentDate,
	Instant paymentTimestamp
);




void deleteOneById(Long id);







//Code between start and end will not be removed during generation.
//Start of user code for this service
//End of user code

}
