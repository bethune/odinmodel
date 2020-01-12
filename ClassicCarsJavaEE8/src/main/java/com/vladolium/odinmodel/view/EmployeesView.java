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
import com.vladolium.odinmodel.model.Employees;
import com.vladolium.odinmodel.model.Employees.*;
import com.vladolium.odinmodel.service.EmployeesService;
import com.vladolium.odinmodel.service.*;
import com.vladolium.odinmodel.wrapper.*;

@Named
@ViewScoped
public class EmployeesView implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EmployeesService employeesService;

	private Employees employees;

	public Employees createOne() {
		return employeesService.createUpdate(employees);
	}

	public Employees updateOneById(Long id) {
		Employees current = employeesService.readOneById(id);
		current.setOffices(employees.getOffices());

		current.setExtension(employees.getExtension());

		current.setFirstName(employees.getFirstName());

		current.setReportsTo(employees.getReportsTo());

		current.setJobTitle(employees.getJobTitle());

		current.setIsActive(employees.getIsActive());

		current.setLastName(employees.getLastName());

		current.setEmail(employees.getEmail());

		return employeesService.createUpdate(current);
	}

	public Employees updateOneByIdIric(Long id) {
		Employees current = employeesService.readOneById(id);
		if (current.getOffices().getId() == employees.getOffices().getId()) {
			current.setOffices(employees.getOffices());

			current.setExtension(employees.getExtension());

			current.setFirstName(employees.getFirstName());

			current.setReportsTo(employees.getReportsTo());

			current.setJobTitle(employees.getJobTitle());

			current.setIsActive(employees.getIsActive());

			current.setLastName(employees.getLastName());

			current.setEmail(employees.getEmail());

			return employeesService.createUpdate(current);
		} else {
			Iterable<Employees> listOfEmployees = employeesService.readAllByOfficesId(current.getOffices().getId());
			Long size = listOfEmployees.spliterator().getExactSizeIfKnown();
			if (size == 1) {
				return current;
			} else {
				current.setOffices(employees.getOffices());

				current.setExtension(employees.getExtension());

				current.setFirstName(employees.getFirstName());

				current.setReportsTo(employees.getReportsTo());

				current.setJobTitle(employees.getJobTitle());

				current.setIsActive(employees.getIsActive());

				current.setLastName(employees.getLastName());

				current.setEmail(employees.getEmail());

				return employeesService.createUpdate(current);
			}
		}
	}

	public Employees readOneById(Long id) {
		return employeesService.readOneById(id);
	}

	private List<Employees> employeesList; 
	public Iterable<Employees> readAll() {
		if (employeesList == null)
			employeesList = (List<Employees>) employeesService.readAll();
		return employeesList;
	}
	
	public List<Employees> getEmployeesList() {
		return employeesList;
	}

	public void setEmployeesList(List<Employees> employeesList) {
		this.employeesList = employeesList;
	}

	private List<Employees> employeesListPage; 
	public List<Employees> readAllPagination(Integer pageNumber, Integer perPageNumber) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		//return employeesService.readAllPagination(page);
		if (employeesListPage == null)
			employeesListPage = employeesService.readAllPagination(page).getContent();
		return employeesListPage;
	}

	public List<Employees> getEmployeesListPage() {
		return employeesListPage;
	}

	public void setEmployeesListPage(List<Employees> employeesListPage) {
		this.employeesListPage = employeesListPage;
	}

	@Inject
	private CustomersService customersService;

	public Iterable<Customers> readAllCustomersByEmployeesId(Long employeesId) {
		return customersService.readAllByEmployeesId(employeesId);
	}

	public Page<Customers> readAllCustomersByEmployeesIdPagination(Integer pageNumber, Integer perPageNumber,
			Long employeesId) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);
		return customersService.readAllByEmployeesId(employeesId, page);
	}

	public Iterable<Employees> search(

			Long officesId,

			String extension, String firstName, Integer reportsTo, String jobTitle, Boolean isActive, String lastName,
			String email

	) {
		return employeesService.search(

				officesId,

				extension, firstName, reportsTo, jobTitle, isActive, lastName, email

		);
	}

	public Page<Employees> searchPagination(Integer pageNumber, Integer perPageNumber,

			Long officesId,

			String extension, String firstName, Integer reportsTo, String jobTitle, Boolean isActive, String lastName,
			String email

	) {
		Pageable page = PageRequest.of(pageNumber, perPageNumber);

		return employeesService.searchPagination(page,

				officesId,

				extension, firstName, reportsTo, jobTitle, isActive, lastName, email

		);
	}

	public void deleteOneById(Long id) {
		employeesService.deleteOneById(id);
	}

	public void deleteOneByIdIric(Long id) {
		Employees current = employeesService.readOneById(id);
		Iterable<Employees> listOfEmployees = employeesService.readAllByOfficesId(current.getOffices().getId());
		Long size = listOfEmployees.spliterator().getExactSizeIfKnown();
		if (size == 1) {
			return;
		} else {
			employeesService.deleteOneById(id);
		}
	}

	

//Code between start and end will not be removed during generation.
//Start of user code for this view
//End of user code
}
