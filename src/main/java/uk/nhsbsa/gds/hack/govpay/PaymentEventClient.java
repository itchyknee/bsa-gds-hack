package uk.nhsbsa.gds.hack.govpay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

import uk.nhsbsa.gds.hack.model.PaymentEvent;

public class PaymentEventClient {

    @Autowired
    HttpComponentsClientHttpRequestFactory factory;

    public PaymentEvent getById(String paymentId) {
    	return null;
    }
    
}
