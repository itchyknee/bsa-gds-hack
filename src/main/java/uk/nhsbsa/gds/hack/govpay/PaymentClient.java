package uk.nhsbsa.gds.hack.govpay;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import uk.nhsbsa.gds.hack.model.PaymentRequest;
import uk.nhsbsa.gds.hack.model.PaymentResponse;

@Component
public class PaymentClient {

	private static String URL = "https://publicapi-integration-1.pymnt.uk/v1/";
	
	@Autowired
	RestTemplate rest;
	
	@Autowired
	HttpHeaders httpHeadersPost;
	
    public PaymentResponse getById(String paymentId) {
    	
    	rest.getForObject(URL + "payments/" + paymentId, Map.class);
    	return null;
    }
    
    public PaymentResponse create(PaymentRequest payment) {
    	
    	HttpEntity<PaymentRequest> entity = new HttpEntity<PaymentRequest>(payment, httpHeadersPost); 
    			
    	PaymentResponse result = rest.postForObject(URL + "payments", entity, PaymentResponse.class);
    	return result;
    }
    
}
