package uk.nhsbsa.gds.hack.govpay;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import uk.nhsbsa.gds.hack.model.PaymentRequest;
import uk.nhsbsa.gds.hack.model.PaymentResponse;

@Component
public class PaymentClient {

	private static String URL = "https://publicapi-integration-1.pymnt.uk/v1/";
	
    @Autowired
    HttpComponentsClientHttpRequestFactory factory;

    public PaymentResponse getById(String paymentId) {
    	
    	RestTemplate rest = new RestTemplate(factory);
    	rest.getForObject("https://", Map.class);
    	return null;
    }
    
    public PaymentResponse create(PaymentRequest payment) {
    	
    	RestTemplate rest = new RestTemplate(factory);
    	PaymentResponse result = rest.postForObject(URL + "payments", payment, PaymentResponse.class);
    	return null;
    }
    
}
