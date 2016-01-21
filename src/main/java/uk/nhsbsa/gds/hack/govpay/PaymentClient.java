package uk.nhsbsa.gds.hack.govpay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

import uk.nhsbsa.gds.hack.model.Order;

public class PaymentClient {

    @Autowired
    HttpComponentsClientHttpRequestFactory factory;

    public Order getById(String paymentId) {
    	return null;
    }
    
}
