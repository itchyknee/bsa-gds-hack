package uk.nhsbsa.gds.hack.mvc;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import uk.nhsbsa.gds.hack.data.IOrderRepository;
import uk.nhsbsa.gds.hack.model.Order;

@Controller
public class OrderController {

	@Autowired
	IOrderRepository orderRepo;
	
    @RequestMapping("orders")
    public String list(Model model) {
    	List<Order> orders = orderRepo.findAll();
    	model.addAttribute("orders", orders);
        return "orderList";
    }

    @RequestMapping(value="orders", method=POST)
    public String create(Model model, Order order) {
    	orderRepo.add(order);
    	return "redirect:orders";
    }

}
