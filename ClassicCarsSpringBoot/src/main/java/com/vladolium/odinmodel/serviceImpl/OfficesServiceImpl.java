
package com.vladolium.odinmodel.serviceImpl;

import com.vladolium.odinmodel.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;

import java.time.*;
import java.util.*;

import com.vladolium.odinmodel.repository.OfficesRepository;
import com.vladolium.odinmodel.service.OfficesService;

@Service
public class OfficesServiceImpl implements OfficesService {

	private OfficesRepository officesRepository;

	@Autowired
	public void setOfficesRepository(OfficesRepository officesRepository) {
		this.officesRepository = officesRepository;
	}

@Override
public Offices createUpdate(Offices offices) {
	return officesRepository.save(offices);
}


@Override
public Offices readOneById(Long id) {
	return officesRepository.getOne(id);
}





















@Override
public void deleteOneById(Long id) {
	officesRepository.deleteById(id);
}










//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code

}
