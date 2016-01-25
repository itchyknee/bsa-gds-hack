package uk.nhsbsa.gds.hack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uk.nhsbsa.gds.hack.govpay.PaymentClient;
import uk.nhsbsa.gds.hack.model.Order;
import uk.nhsbsa.gds.hack.model.PaymentRequest;

@Component
public class OrderService implements IOrderService {

	@Autowired
	PaymentClient paymentClient;
	
	public String pay(Order order) {
		
		PaymentRequest payment = new PaymentRequest();
		
		//TODO populate initial Payment object
		payment.setAccountId(123);
		payment.setAmount(order.getCost());
		payment.setDescription(order.getDescription());
		payment.setReturnURL("http://localhost:8080/orders");
		payment.setReference("my-ref");
		paymentClient.create(payment);
		
		return null;
	}
}
