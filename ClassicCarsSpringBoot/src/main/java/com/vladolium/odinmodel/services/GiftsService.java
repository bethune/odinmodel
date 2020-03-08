package com.vladolium.odinmodel.service;

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Gifts;
import com.vladolium.odinmodel.model.Gifts.*;
import com.vladolium.odinmodel.repository.*;
import com.vladolium.odinmodel.repository.GiftsRepository;
import com.vladolium.odinmodel.interfaces.GiftsInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Transactional;
import java.time.*;
import java.util.*;

import com.vladolium.odinmodel.wrapper.*;
import com.querydsl.core.BooleanBuilder;

@Service
@Transactional
public class GiftsService implements GiftsInterface {

	private GiftsRepository giftsRepository;

	@Autowired
	public void setGiftsRepository(GiftsRepository giftsRepository) {
		this.giftsRepository = giftsRepository;
	}


//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code
}
