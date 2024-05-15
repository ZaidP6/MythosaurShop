package com.salesianostriana.dam.pilaraguilartiendaonline03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.pilaraguilartiendaonline03.model.Customer;
import com.salesianostriana.dam.pilaraguilartiendaonline03.model.Product;
import com.salesianostriana.dam.pilaraguilartiendaonline03.service.CustomerService;
import com.salesianostriana.dam.pilaraguilartiendaonline03.service.ProductService;

@Controller
public class MainController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CustomerService customerService;
	    
    @Autowired
    private PasswordEncoder passwordEncoder;

	
	@GetMapping("/")
	public String index(Model model) {
		List<Product> productos = productService.findAll();
        model.addAttribute("products", productos);
		return "index";
	}
	
	@GetMapping("/form/signInSimple")
    public String showForm(Model model) {
        model.addAttribute("customerForm", new Customer());
        return "signInSimple";
    }

    @PostMapping("/form/signInSimple/submit")
    public String submitSignIn(@ModelAttribute("customerForm") Customer customer) {
    	String encodedPassword = passwordEncoder.encode(customer.getBasicUserPassword());
    	customer.setBasicUserPassword(encodedPassword);
        customerService.save(customer);
        return "redirect:/";
    }

    @GetMapping("/form/logIn")
    public String showLogInPage() {

        return "logIn";
    }
	 
	
}
