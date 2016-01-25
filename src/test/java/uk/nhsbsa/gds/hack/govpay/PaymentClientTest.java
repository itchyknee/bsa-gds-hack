/**
 * 
 */
package uk.nhsbsa.gds.hack.govpay;

import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import uk.nhsbsa.gds.hack.conf.TestConfiguration;
import uk.nhsbsa.gds.hack.model.Payment;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Test cases to prove PaymentClient.
 * 
 * @author gary
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestConfiguration.class})
public class PaymentClientTest {

	@Autowired
	private PaymentClient paymentClient;
	
	/**
	 * Test method for {@link uk.nhsbsa.gds.hack.govpay.PaymentClient#getById(java.lang.String)}.
	 */
	@Test
	public void testGetById() {
		Payment payment = paymentClient.getById("108");
		assertNotNull(payment);
		
		assertEquals("108", payment.getId());
	}

	/**
	 * Test method for {@link uk.nhsbsa.gds.hack.govpay.PaymentClient#create(uk.nhsbsa.gds.hack.model.Payment)}.
	 */
	@Test
	public void testCreate() {
		Payment payment = new Payment();
		payment.setId("unit1");
		
		Payment paymentCreated = paymentClient.create(payment);
		assertNotNull(paymentCreated);
	}
}
