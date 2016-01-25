package uk.nhsbsa.gds.hack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uk.nhsbsa.gds.hack.govpay.PaymentClient;
import uk.nhsbsa.gds.hack.model.Order;
import uk.nhsbsa.gds.hack.model.Payment;

@Component
public class OrderService implements IOrderService {

	@Autowired
	PaymentClient paymentClient;
	
	public String pay(Order order) {
		
		Payment payment = new Payment();
		//TODO populate initial Payment object
		paymentClient.create(payment);
		
		return null;
	}
}
