package uk.nhsbsa.gds.hack.service;

import uk.nhsbsa.gds.hack.model.Order;

public interface IOrderService {

	public String pay(Order order);

	public void update(Order order);
}
