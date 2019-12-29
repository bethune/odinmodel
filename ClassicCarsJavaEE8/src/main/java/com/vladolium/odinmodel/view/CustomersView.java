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
import com.vladolium.odinmodel.model.Customers;
import com.vladolium.odinmodel.model.Customers.*;
import com.vladolium.odinmodel.service.CustomersService;
import com.vladolium.odinmodel.service.*;
import com.vladolium.odinmodel.wrapper.*;

@Named
@ViewScoped
public class CustomersView implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CustomersService customersService;

	private Customers customers;

	public Customers createOne() {
		return customersService.createUpdate(customers);
	}

	public Customers updateOneById(Long id) {
		Customers current = customersService.readOneById(id);
		current.setReviewsList(customers.getReviewsList());
		current.setEmployees(customers.getEmployees());

		current.setLastName(customers.getLastName());

		current.setCreditLimit(customers.getCreditLimit());

		current.setCustomerName(customers.getCustomerName());

		current.setCity(customers.getCity());

		current.setAddressLine1(customers.getAddressLine1());

		current.setAddressLine2(customers.getAddressLine2());

		current.setCountry(customers.getCountry());

		current.setPhone(customers.getPhone());

		current.setFirstName(customers.getFirstName());

		current.setPostalCode(customers.getPostalCode());

		current.setState(customers.getState());

		return customersService.createUpdate(current);
	}

	public Customers updateOneByCustomerName(String customerName) {
		Customers current = customersService.readOneByCustomerName(customerName);
		current.setReviewsList(customers.getReviewsList());
		current.setEmployees(customers.getEmployees());

		current.setLastName(customers.getLastName());

		current.setCreditLimit(customers.getCreditLimit());

		current.setCustomerName(customers.getCustomerName());

		current.setCity(customers.getCity());

		current.setAddressLine1(customers.getAddressLine1());

		current.setAddressLine2(customers.getAddressLine2());

		current.setCountry(customers.getCountry());

		current.setPhone(customers.getPhone());

		current.setFirstName(customers.getFirstName());

		current.setPostalCode(customers.getPostalCode());

		current.setState(customers.getState());

		return customersService.createUpdate(current);
	}

	public Customers readOneById(Long id) {
		return customersService.readOneById(id);
	}

	public Customers readOneByCustomerName(String customerName) {
		return customersService.readOneByCustomerName(customerName);
	}

	public Iterable<Customers> readAll() {
		return customersService.readAll();
	}

	public Page<Customers> readAllPagination(Integer pageNumber, Integer perPageNumber) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return customersService.readAllPagination(page);
	}

	@Inject
	private PaymentsService paymentsService;

	public Iterable<Payments> readAllPaymentsByCustomersId(Long customersId) {
		return paymentsService.readAllByCustomersId(customersId);
	}

	public Page<Payments> readAllPaymentsByCustomersIdPagination(Integer pageNumber, Integer perPageNumber,
			Long customersId) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return paymentsService.readAllByCustomersId(customersId, page);
	}

	public Iterable<Payments> readAllPaymentsByCustomersCustomerName(String customersCustomerName) {
		return paymentsService.readAllByCustomersCustomerName(customersCustomerName);
	}

	public Page<Payments> readAllPaymentsByCustomersCustomerNamePagination(Integer pageNumber, Integer perPageNumber,
			String customersCustomerName) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return paymentsService.readAllByCustomersCustomerName(customersCustomerName, page);
	}

	@Inject
	private OrdersService ordersService;

	public Iterable<Orders> readAllOrdersByCustomersId(Long customersId) {
		return ordersService.readAllByCustomersId(customersId);
	}

	public Page<Orders> readAllOrdersByCustomersIdPagination(Integer pageNumber, Integer perPageNumber,
			Long customersId) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return ordersService.readAllByCustomersId(customersId, page);
	}

	public Iterable<Orders> readAllOrdersByCustomersCustomerName(String customersCustomerName) {
		return ordersService.readAllByCustomersCustomerName(customersCustomerName);
	}

	public Page<Orders> readAllOrdersByCustomersCustomerNamePagination(Integer pageNumber, Integer perPageNumber,
			String customersCustomerName) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return ordersService.readAllByCustomersCustomerName(customersCustomerName, page);
	}

	public Iterable<Customers> search(List<Reviews> reviewsList,

			Long employeesId,

			String addressLine1, String addressLine2, String country, String lastName, Double creditLimit, String phone,
			String customerName, String city, String firstName, String postalCode, String state

	) {
		return customersService.search(reviewsList,

				employeesId,

				addressLine1, addressLine2, country, lastName, creditLimit, phone, customerName, city, firstName,
				postalCode, state

		);
	}

	public Page<Customers> searchPagination(Integer pageNumber, Integer perPageNumber, List<Reviews> reviewsList,

			Long employeesId,

			String addressLine1, String addressLine2, String country, String lastName, Double creditLimit, String phone,
			String customerName, String city, String firstName, String postalCode, String state

	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);

		return customersService.searchPagination(page, reviewsList,

				employeesId,

				addressLine1, addressLine2, country, lastName, creditLimit, phone, customerName, city, firstName,
				postalCode, state

		);
	}

	public void deleteOneById(Long id) {
		customersService.deleteOneById(id);
	}

//Code between start and end will not be removed during generation.
//Start of user code for this view
//End of user code
}
