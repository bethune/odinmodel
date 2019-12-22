package com.vladolium.odinmodel.view;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.data.domain.*;
//import org.springframework.format.annotation.*;
import java.time.*;
import java.util.*;
import java.io.Serializable;
import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Gifts;
import com.vladolium.odinmodel.model.Gifts.*;
import com.vladolium.odinmodel.service.GiftsService;
import com.vladolium.odinmodel.service.*;

@Named
@ViewScoped
public class GiftsView implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private GiftsService giftsService;

	
	
	
	
	
	public Gifts readOneById(Long id) {
		return giftsService.readOneById(id);
	}
	
	
	
	
	public Gifts readOneByGiftName(String giftName) {
		return giftsService.readOneByGiftName(giftName);
	}
	
	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code
}
