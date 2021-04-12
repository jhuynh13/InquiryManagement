package github.com.jhuynh13.SalesManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

	@Autowired
	private CustomerService service;
	
	@RequestMapping("/")
	public String viewHome(Model model) {
		
		List<Customers> listCustomers = service.listAll();
		model.addAttribute("listCustomers", listCustomers);
		
		return "index";
	}
	
	@RequestMapping("/new")
	public String showForm(Model model) {
		Customers customers = new Customers();
		model.addAttribute("customers", customers);
		
		return "new_customer";
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customers") Customers customers) {
		service.save(customers);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEdit(@PathVariable(name= "id") int id) {
		ModelAndView view = new ModelAndView ("edit_customer");
		
		Customers customers = service.get(id);
		view.addObject("customers", customers);
		
		return view;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable(name= "id") int id) {
	
		service.delete(id);
		
		return "redirect:/";
	}
}
