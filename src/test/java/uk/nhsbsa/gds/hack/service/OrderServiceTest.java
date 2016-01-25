/**
 * 
 */
package uk.nhsbsa.gds.hack.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import uk.nhsbsa.gds.hack.model.Order;
import uk.nhsbsa.gds.hack.model.OrderStatus;

/**
 * @author gary
 *
 */
public class OrderServiceTest {

	private OrderService orderService;
	
	private Random random;
	
	@Before
	public void setUp()
	{
		random = new Random(System.currentTimeMillis());
	}

	/**
	 * Test method for {@link uk.nhsbsa.gds.hack.service.OrderService#pay(uk.nhsbsa.gds.hack.model.Order)}.
	 */
	@Test
	public void testPay() {
		
		Order order = getTestOrder();
		
		orderService.pay(order);
	}
	
	private Order getTestOrder() {
		Order order = new Order();
			
		order.setCost(new BigDecimal(100).setScale(0, RoundingMode.HALF_UP));
		order.setDescription("JUnit test case");
		order.setStatus(OrderStatus.PENDING);
		order.setId(Integer.toString(
				random.nextInt(9999))
		);
			
		return order;
	}
}
