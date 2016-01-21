package uk.nhsbsa.gds.hack.data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import uk.nhsbsa.gds.hack.model.Order;

@Repository
public class OrderRepository implements IOrderRepository {

	Map<String, Order> orders = new LinkedHashMap<String, Order>();
	
	@Override
	public List<Order> findAll() {
		return new ArrayList<Order>(orders.values());
	}

	@Override
	public void add(Order order) {

		order.setId(UUID.randomUUID().toString());
		orders.put(order.getId(), order);
	}

}
