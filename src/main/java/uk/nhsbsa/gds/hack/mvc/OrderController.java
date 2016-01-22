package uk.nhsbsa.gds.hack.mvc;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import uk.nhsbsa.gds.hack.data.IRepository;
import uk.nhsbsa.gds.hack.model.Order;
import uk.nhsbsa.gds.hack.model.Payment;

@Controller
public class OrderController {

	/** Logger. */
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	@Qualifier("orderRepository")
	private IRepository<Order, String> orderRepo;
	
    @RequestMapping("/orders")
    public String list(Model model) {
    	List<Order> orders = orderRepo.findAll();
    	model.addAttribute("orders", orders); 
        return "orderList";
    }

    @RequestMapping(value="/orders", method=POST)
    public String create(Model model, Order order) {
    	LOGGER.info("Creating new Order: {}", order);
    	order.setPayment(new Payment());
    	orderRepo.add(order);
    	return "redirect:/orders";
    }

}
