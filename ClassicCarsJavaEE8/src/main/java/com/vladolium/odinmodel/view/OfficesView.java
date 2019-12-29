package com.vladolium.odinmodel.view;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.*;
//import org.springframework.format.annotation.*;
import java.time.*;
import java.util.*;
import java.io.Serializable;
import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Offices;
import com.vladolium.odinmodel.model.Offices.*;
import com.vladolium.odinmodel.service.OfficesService;
import com.vladolium.odinmodel.service.*;
import com.vladolium.odinmodel.wrapper.*;

@Named
@ViewScoped
public class OfficesView implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private OfficesService officesService;

	private Offices offices;

	public Offices createOne() {
		return officesService.createUpdate(offices);
	}

	private OfficesEmployees officesEmployees;

	public Offices createOneIric() {
		return officesService.createOneIric(officesEmployees);
	}

	public Offices updateOneById(Long id) {
		Offices current = officesService.readOneById(id);

		current.setAddressLine1(offices.getAddressLine1());

		current.setAddressLine2(offices.getAddressLine2());

		current.setCountry(offices.getCountry());

		current.setPhone(offices.getPhone());

		current.setCity(offices.getCity());

		current.setPostalCode(offices.getPostalCode());

		current.setTerritory(offices.getTerritory());

		current.setState(offices.getState());

		return officesService.createUpdate(current);
	}

	public Offices readOneById(Long id) {
		return officesService.readOneById(id);
	}

	public Iterable<Offices> readAll() {
		return officesService.readAll();
	}

	public Page<Offices> readAllPagination(Integer pageNumber, Integer perPageNumber) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return officesService.readAllPagination(page);
	}

	@Inject
	private EmployeesService employeesService;

	public Iterable<Employees> readAllEmployeesByOfficesId(Long officesId) {
		return employeesService.readAllByOfficesId(officesId);
	}

	public Page<Employees> readAllEmployeesByOfficesIdPagination(Integer pageNumber, Integer perPageNumber,
			Long officesId) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return employeesService.readAllByOfficesId(officesId, page);
	}

	public Iterable<Offices> search(String addressLine1, String addressLine2, String country, String phone, String city,
			String postalCode, String territory, String state

	) {
		return officesService.search(addressLine1, addressLine2, country, phone, city, postalCode, territory, state

		);
	}

	public Page<Offices> searchPagination(Integer pageNumber, Integer perPageNumber, String addressLine1,
			String addressLine2, String country, String phone, String city, String postalCode, String territory,
			String state

	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);

		return officesService.searchPagination(page, addressLine1, addressLine2, country, phone, city, postalCode,
				territory, state

		);
	}

	public void deleteOneById(Long id) {
		officesService.deleteOneById(id);
	}

//Code between start and end will not be removed during generation.
//Start of user code for this view
//End of user code
}
