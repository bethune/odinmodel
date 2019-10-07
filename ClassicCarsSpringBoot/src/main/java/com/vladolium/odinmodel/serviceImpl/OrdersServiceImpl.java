
package com.vladolium.odinmodel.serviceImpl;

import com.vladolium.odinmodel.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;

import java.time.*;
import java.util.*;

import com.vladolium.odinmodel.repository.OrdersRepository;
import com.vladolium.odinmodel.service.OrdersService;

import com.vladolium.odinmodel.domain.*;
import com.vladolium.odinmodel.domain.Orders;
import com.vladolium.odinmodel.domain.Orders.*;

@Service
public class OrdersServiceImpl implements OrdersService {

	private OrdersRepository ordersRepository;

	@Autowired
	public void setOrdersRepository(OrdersRepository ordersRepository) {
		this.ordersRepository = ordersRepository;
	}


// covers create & update
@Override
public Orders createUpdate(Orders orders) {
	return ordersRepository.save(orders);
}








@Override
public Orders readOneById(Long id) {
	return ordersRepository.getOne(id);
}











@Override
public Iterable<Orders> readAll() {
	return ordersRepository.findAll();
}


@Override
public Page<Orders> readAllPagination(Pageable page) {
	return ordersRepository.findAll(page);
}



@Override
public Iterable<Orders> search(


	Long customersId,









	LocalDate requiredDate,
	String comments,
	String status,
	LocalDate shippedDate,
	LocalDate orderDate
	) {
		BooleanBuilder where = dynamicWhere(


	customersId,









	requiredDate,
	comments,
	status,
	shippedDate,
	orderDate
	);

	return ordersRepository.findAll(where);
}





public Condition dynamicCondition(


		Long customersId,









		LocalDate requiredDate,
		Clob comments,
		String status,
		LocalDate shippedDate,
		LocalDate orderDate
	) {
		QOrders qOrders = QOrders.orders;

		BooleanBuilder where = new BooleanBuilder();



		if (customersId != null) {
			where.and(qOrders.customers.id.eq(customersId));
		}









		if (requiredDate != null) {
			where.and(qOrders.requiredDate.eq(requiredDate));
		}
		if (comments != null) {
			where.and(qOrders.comments.eq(comments));
		}
		if (status != null) {
			where.and(qOrders.status.containsIgnoreCase(status));
		}
		if (shippedDate != null) {
			where.and(qOrders.shippedDate.eq(shippedDate));
		}
		if (orderDate != null) {
			where.and(qOrders.orderDate.eq(orderDate));
		}

		return where;
	}








@Override
public void deleteOneById(Long id) {
	ordersRepository.deleteById(id);
}



//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code

}
