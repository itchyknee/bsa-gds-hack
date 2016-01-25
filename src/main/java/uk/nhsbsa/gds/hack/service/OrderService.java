package uk.nhsbsa.gds.hack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uk.nhsbsa.gds.hack.govpay.PaymentClient;
import uk.nhsbsa.gds.hack.model.Order;

@Component
public class OrderService implements IOrderService {

	@Autowired
	PaymentClient paymentClient;
	
	public void pay(Order order) {
		
		
	}
}
