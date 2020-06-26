package com.vladolium.odinmodel.services;

import com.vladolium.odinmodel.model.*;
import com.vladolium.odinmodel.model.Marks.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.time.*;
import java.util.*;

import com.vladolium.odinmodel.repositories.*;
//import com.vladolium.odinmodel.specifications.*;
import com.vladolium.odinmodel.interfaces.*;
import com.vladolium.odinmodel.wrappers.*;

import com.querydsl.core.BooleanBuilder;

@Service
@Transactional
public class MarksService implements MarksInterface {

	private MarksRepository marksRepository;

	@Autowired
	public void setMarksRepository(MarksRepository marksRepository) {
		this.marksRepository = marksRepository;
	}

	@Override
	public Marks saveOne(Marks marks) {
		return marksRepository.save(marks);
	}

	@Override
	public void deleteOneById(Long id) {
	    marksRepository.deleteById(id);
	}
	
	@Override
	public Marks readOneById(Long id) {
		return marksRepository.getOne(id);
	}

	@Override
	public Iterable<Marks> readAll() {
		return marksRepository.findAll();
	}
	
	@Override
	public Page<Marks> readAllPagination(Pageable page) {
		return marksRepository.findAll(page);
	}

	@Override
	public Iterable<Marks> search(
		Long employeesId,
		
		
		
		
		
		
		
		
		
		
		Long customersId,
		MarkType markType,
		String comment
	) {
		BooleanBuilder where = dynamicWhere(
			employeesId,
			
			
			
			
			
			
			
			
			
			
			customersId,
			markType,
			comment	
		);
		return marksRepository.findAll(where);
	}
	
	@Override
	public Page<Marks> searchPagination(
		Pageable page,
		Long employeesId,
		
		
		
		
		
		
		
		
		
		
		Long customersId,
		MarkType markType,
		String comment
	) {
		BooleanBuilder where = dynamicWhere(
			employeesId,
			
			
			
			
			
			
			
			
			
			
			customersId,
			markType,
			comment
		);
		return marksRepository.findAll(where, page);
	}
	
	public BooleanBuilder dynamicWhere(
		Long employeesId,
		
		
		
		
		
		
		
		
		
		
		Long customersId,
		MarkType markType,
		String comment
	) {
		QMarks qMarks = QMarks.marks;
	
		BooleanBuilder where = new BooleanBuilder();
	
		if (employeesId != null) {
			where.and(qMarks.employees.id.eq(employeesId));
		}
		
		
		
		
		
		
		
		
		
		
		if (customersId != null) {
			where.and(qMarks.customers.id.eq(customersId));
		}
		if (markType != null) {
			where.and(qMarks.markType.eq(markType));
		}
		if (comment != null) {
			where.and(qMarks.comment.containsIgnoreCase(comment));
		}
	
		return where;
	}


	@Override
	public Iterable<Marks> readAllByEmployeesId(Long employeesId) {
		return marksRepository.findByEmployeesIdEquals(employeesId);
	}
	
	@Override
	public Page<Marks> readAllByEmployeesId(Long employeesId, Pageable page) {
		return marksRepository.findByEmployeesIdEquals(employeesId, page);
	}
	
	
	
	
	
	
	
	
	
	
	@Override
	public Iterable<Marks> readAllByCustomersId(Long customersId) {
		return marksRepository.findByCustomersIdEquals(customersId);
	}
	
	@Override
	public Page<Marks> readAllByCustomersId(Long customersId, Pageable page) {
		return marksRepository.findByCustomersIdEquals(customersId, page);
	}
	
	
	
	@Override
	public Iterable<Marks> readAllByCustomersCustomerName(String customersCustomerName) {
		return marksRepository.findByCustomersCustomerNameEquals(customersCustomerName);
	}
	
	@Override
	public Page<Marks> readAllByCustomersCustomerName(String customersCustomerName, Pageable page) {
		return marksRepository.findByCustomersCustomerNameEquals(customersCustomerName, page);
	}

	
	
	

//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code
}
