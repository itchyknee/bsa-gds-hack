package uk.nhsbsa.gds.hack.govpay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import uk.nhsbsa.gds.hack.model.PaymentRequest;
import uk.nhsbsa.gds.hack.model.PaymentResponse;
import uk.nhsbsa.gds.hack.mvc.OrderController;

@Component
public class PaymentClient {

	/** Logger. */
	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentClient.class);

	private static String URL = "https://publicapi-integration-1.pymnt.uk/v1/";
	
	@Autowired
	RestTemplate rest;
	
	@Autowired
	HttpHeaders httpHeadersPost;
	
	@Autowired
	HttpHeaders httpHeadersGet;
	
    public PaymentResponse getById(Integer paymentId) {

    	LOGGER.info("Retrieving payment info for {}", paymentId);
    	HttpEntity<PaymentRequest> entity = new HttpEntity<PaymentRequest>(httpHeadersGet); 
    	PaymentResponse result = rest.exchange(URL + "payments/" + paymentId,
    			HttpMethod.GET,
    			entity,
    			PaymentResponse.class).getBody();
    	return result;
    }
    
    public PaymentResponse create(PaymentRequest payment) {
    	
    	HttpEntity<PaymentRequest> entity = new HttpEntity<PaymentRequest>(payment, httpHeadersPost); 
    			
    	PaymentResponse result = rest.postForObject(URL + "payments", entity, PaymentResponse.class);
    	return result;
    }
    
}
