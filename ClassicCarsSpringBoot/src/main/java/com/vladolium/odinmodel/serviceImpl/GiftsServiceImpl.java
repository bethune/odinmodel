
package com.vladolium.odinmodel.serviceImpl;

import com.vladolium.odinmodel.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;

import java.time.*;
import java.util.*;

import com.vladolium.odinmodel.repository.GiftsRepository;
import com.vladolium.odinmodel.service.GiftsService;

@Service
public class GiftsServiceImpl implements GiftsService {

	private GiftsRepository giftsRepository;

	@Autowired
	public void setGiftsRepository(GiftsRepository giftsRepository) {
		this.giftsRepository = giftsRepository;
	}

@Override
public Gifts createUpdate(Gifts gifts) {
	return giftsRepository.save(gifts);
}


@Override
public Gifts readOneById(Long id) {
	return giftsRepository.getOne(id);
}









@Override
public Gifts readOneByGiftName(String giftName) {
	return giftsRepository.findByGiftNameEquals(giftName);
}







@Override
public Iterable<Gifts> readAll() {
	return giftsRepository.findAll();
}


@Override
public Page<Gifts> readAllPagination(Pageable page) {
	return giftsRepository.findAll(page);
}





@Override
public void deleteOneById(Long id) {
	giftsRepository.deleteById(id);
}








//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code

}
