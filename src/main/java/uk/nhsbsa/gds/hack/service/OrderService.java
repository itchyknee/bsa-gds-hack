package uk.nhsbsa.gds.hack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import uk.nhsbsa.gds.hack.govpay.PaymentClient;
import uk.nhsbsa.gds.hack.model.Order;
import uk.nhsbsa.gds.hack.model.OrderStatus;
import uk.nhsbsa.gds.hack.model.PaymentRequest;
import uk.nhsbsa.gds.hack.model.PaymentResponse;

@Component
public class OrderService implements IOrderService {

	@Autowired
	PaymentClient paymentClient;
	
	public String pay(Order order) {
		
		PaymentRequest payment = new PaymentRequest();
		payment.setAccountId(123);
		payment.setAmount(order.getCost());
		payment.setDescription(order.getDescription());
		payment.setReturnURL("http://localhost:8080/orders/" + order.getId());
		payment.setReference("my-ref");
		PaymentResponse response = paymentClient.create(payment);
		
		order.setPaymentId(response.getPaymentId());
		
		Link nextUrl = response.getLink("next_url");
		return nextUrl.getHref();
	}

	@Override
	public void update(Order order) {
		
		PaymentResponse res = paymentClient.getById(order.getPaymentId());
		order.setStatus(getStatus(res.getStatus()));
	}

	private OrderStatus getStatus(String status) {
		
		if ("SUCCEEDED".equals(status)) {
			return OrderStatus.APPROVED;
		}
		return OrderStatus.REJECTED;
	}
}
