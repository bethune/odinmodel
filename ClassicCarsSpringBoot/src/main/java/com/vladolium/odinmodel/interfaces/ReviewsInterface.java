package com.vladolium.odinmodel.interfaces;

import com.vladolium.odinmodel.model.*;

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


	

	


//Code between start and end will not be removed during generation.
//Start of user code for this interface
//End of user code
}
