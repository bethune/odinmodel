package com.vladolium.odinmodel.interfaces; 

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.wrappers.*;

import java.time.*;
import java.util.*;

import org.springframework.data.domain.*;

public interface OfficesInterface {

	// covers create, update and update with IRIC
	Offices saveOne(Offices offices);
	
	// covers create with IRIC
	Offices saveOneWithIric(OfficesEmployees officesEmployees);
	


//Code between start and end will not be removed during generation.
//Start of user code for this interface
//End of user code
}
