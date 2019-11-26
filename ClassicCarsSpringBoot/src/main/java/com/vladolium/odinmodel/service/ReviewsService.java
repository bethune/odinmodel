package com.vladolium.odinmodel.service;

import com.vladolium.odinmodel.domain.*;
import java.time.*;
import java.util.*;
import org.springframework.data.domain.*;
import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Reviews;
import com.vladolium.odinmodel.domain.Reviews.*;
import com.vladolium.odinmodel.wrapper.*;

public interface ReviewsService {

	// covers create, update and update with IRIC
	Reviews createUpdate(Reviews reviews);
	
	
	Reviews readOneById(Long id);
	
	
	
	
	
	
	
	
	Iterable<Reviews> readAll();
	
	Page<Reviews> readAllPagination(Pageable page);
	
	
	
	Iterable<Reviews> search(
		LocalTime reviewTime,
		String reviewText,
		LocalDate reviewDate
		
	);
	
	Page<Reviews> searchPagination(
		Pageable page,
		LocalTime reviewTime,
		String reviewText,
		LocalDate reviewDate
		
	);
	void deleteOneById(Long id);
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this service
//End of user code
}
