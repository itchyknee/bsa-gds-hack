package uk.nhsbsa.gds.hack.mvc;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import uk.nhsbsa.gds.hack.data.IRepository;
import uk.nhsbsa.gds.hack.model.Order;
import uk.nhsbsa.gds.hack.model.OrderStatusTransition;
import uk.nhsbsa.gds.hack.model.PaymentStatus;

/**
 * Controller responsible for handling order transitions.
 * An OrderTransition is responsible for moving an order
 * from one status to another.
 * @author pattu
 *
 */
@Controller
public class OrderTransitionController {

	/** Logger. */
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderTransitionController.class);
	
	private Map<String, PaymentStatus> transitionMap = new HashMap<String, PaymentStatus>();
	
	@Autowired
	@Qualifier("orderRepository")
	private IRepository<Order, String> orderRepo;
	
	public OrderTransitionController() {
		transitionMap.put("pay", PaymentStatus.SUBMITTED);
		transitionMap.put("approve", PaymentStatus.APPROVED);
		transitionMap.put("reject", PaymentStatus.REJECTED);
	}

    @RequestMapping(value="/orders/transition", method=POST)
    public String create(Model model, OrderStatusTransition transition) {
    	
    	//return to base order list
    	LOGGER.info("Creating transition: {}", transition);
    	PaymentStatus newStatus = transitionMap.get(transition.getTarget());
    	if (newStatus != null) {
    		Order order = orderRepo.find(transition.getId());
    		if (order != null) {
    			order.getPayment().setStatus(newStatus);
    		}
    	}
    	return "redirect:/orders";
    }

}
