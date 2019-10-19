package com.vladolium.odinmodel.service;

import com.vladolium.odinmodel.domain.*;
import java.time.*;
import java.util.*;
import org.springframework.data.domain.*;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Reviews;
import com.vladolium.odinmodel.domain.Reviews.*;
import com.vladolium.odinmodel.wrapperRequest.*;

public interface ReviewsService {

	// covers create & update
	Reviews createUpdate(Reviews reviews);
	
	
	
	
	Reviews readOneById(Long id);
	
	
	
	
	
	
	Iterable<Reviews> readAll();
	
	Page<Reviews> readAllPagination(Pageable page);
	
	
	
	Iterable<Reviews> search(
		LocalTime reviewTime,
		LocalDate reviewDate,
		String reviewText
		
	);
	
	Page<Reviews> searchPagination(
		Pageable page,
		LocalTime reviewTime,
		LocalDate reviewDate,
		String reviewText
		
	);
	
	
	void deleteOneById(Long id);
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this service
//End of user code
}
