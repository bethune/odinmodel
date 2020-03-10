package com.vladolium.odinmodel.interfaces; 

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.wrappers.*;

import java.time.*;
import java.util.*;

import org.springframework.data.domain.*;

public interface ProductLinesInterface {

	// covers create, update and update with IRIC
	ProductLines saveOne(ProductLines productLines);
	
	// covers create with IRIC
	ProductLines saveOneWithIric(ProductLinesProducts productLinesProducts);
	


//Code between start and end will not be removed during generation.
//Start of user code for this interface
//End of user code
}
