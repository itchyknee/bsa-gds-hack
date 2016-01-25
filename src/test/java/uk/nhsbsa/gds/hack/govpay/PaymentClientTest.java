/**
 * 
 */
package uk.nhsbsa.gds.hack.govpay;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import uk.nhsbsa.gds.hack.conf.TestConfiguration;
import uk.nhsbsa.gds.hack.model.PaymentRequest;
import uk.nhsbsa.gds.hack.model.PaymentResponse;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Test cases to prove PaymentClient.
 * 
 * Make sure the VM args for Java 1.7 "-Dhttps.protocols=TLSv1.1,TLSv1.2"
 * Can also override the default API token with the VM arg "-DbearerToken=[your API key]"
 * 
 * @author gary
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestConfiguration.class})
public class PaymentClientTest {

	@Autowired
	private PaymentClient paymentClient;
 	
	private Random random;
	
	@Before
	public void setUp()
	{
		random = new Random(System.currentTimeMillis());
	}
	
	/**
	 * Test method for {@link uk.nhsbsa.gds.hack.govpay.PaymentClient#getById(java.lang.String)}.
	 */
	@Test
	public void testGetById() {
		PaymentResponse paymentResponse = paymentClient.getById(108);
		assertNotNull(paymentResponse);
	}

	/**
	 * Test method for {@link uk.nhsbsa.gds.hack.govpay.PaymentClient#create(uk.nhsbsa.gds.hack.model.Payment)}.
	 */
	@Test
	public void testCreate() {
		PaymentRequest paymentRequest = getTestPaymentRequest();
		PaymentResponse paymentResponse = paymentClient.create(paymentRequest);
		assertNotNull(paymentResponse);
		assertNotNull(paymentResponse.getLink("next_url"));
	}
	
	private PaymentRequest getTestPaymentRequest() {
		PaymentRequest paymentRequest = new PaymentRequest();
		paymentRequest.setAmount(new BigDecimal(100).setScale(0, RoundingMode.HALF_UP));
		paymentRequest.setAccountId(123);
		paymentRequest.setDescription("Unit test");
		paymentRequest.setReference("TEST"+random.nextInt(9999));
		paymentRequest.setReturnURL("http://unittest.org.uk/something");
			
		return paymentRequest;
	}
}
