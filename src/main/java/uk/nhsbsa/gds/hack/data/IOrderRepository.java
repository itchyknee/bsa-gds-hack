package uk.nhsbsa.gds.hack.data;

import java.util.List;

import uk.nhsbsa.gds.hack.model.Order;

public interface IOrderRepository {

	List<Order> findAll();

	void add(Order order);

	
}
