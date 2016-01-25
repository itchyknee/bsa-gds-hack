package uk.nhsbsa.gds.hack.mvc;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;
import java.util.UUID;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import uk.nhsbsa.gds.hack.data.IRepository;
import uk.nhsbsa.gds.hack.model.Order;
import uk.nhsbsa.gds.hack.service.IOrderService;

@Controller
public class OrderController {

	/** Logger. */
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	@Qualifier("orderRepository")
	private IRepository<Order, String> orderRepo;
	
	@Autowired
	private IOrderService orderService;
	
    @RequestMapping("/orders/{id}")
    public String get(Model model, @PathVariable String id) {
    	Order order = orderRepo.find(id);
    	orderService.update(order);
        return "redirect:/orders";
    }

    @RequestMapping("/orders")
    public String list(Model model) {
    	List<Order> orders = orderRepo.findAll();
    	model.addAttribute("orders", orders); 
        return "orderList";
    }

    @RequestMapping(value="/orders", method=POST)
    public String create(Model model, Order order) {
    	
    	LOGGER.info("Creating new Order: {}", order);
    	order.setId(UUID.randomUUID().toString());
    	orderRepo.add(order);
    	LOGGER.info("Created new Order: {}", order);
    	return "redirect:/orders";
    }

}
