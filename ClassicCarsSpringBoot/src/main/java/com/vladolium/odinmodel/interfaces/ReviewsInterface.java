package com.vladolium.odinmodel.interfaces;

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Reviews.*;

import java.time.*;
import java.util.*;

import org.springframework.data.domain.*;

import com.vladolium.odinmodel.wrappers.*;

public interface ReviewsInterface {

	Reviews saveOne(Reviews reviews);
	
	void deleteOneById(Long id);
	
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

	

	

	

//Code between start and end will not be removed during generation.
//Start of user code for this interface
//End of user code
}
