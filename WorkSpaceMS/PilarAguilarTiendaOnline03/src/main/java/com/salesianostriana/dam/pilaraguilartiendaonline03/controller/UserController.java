package com.salesianostriana.dam.pilaraguilartiendaonline03.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.pilaraguilartiendaonline03.model.Customer;
import com.salesianostriana.dam.pilaraguilartiendaonline03.service.CustomerService;

@Controller
public class UserController {

    private CustomerService customerService;

    public UserController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/form/signInSimple")
    public String showForm(Model model) {
        model.addAttribute("customerForm", new Customer());
        return "signInSimple";
    }

    @PostMapping("/form/signInSimple")
    public String addCustomer(@ModelAttribute("customerForm") Customer customer, Model model) {
        customerService.save(customer);
        return "redirect:/index";
    }

    @GetMapping("/logIn")
    public String showLogInPage() {
        return "logIn";
    }

    @GetMapping("newCustomer")
	public String nuevoUsuario(Model model) {
		
		model.addAttribute("customer",new Customer());
		
		return "signInSimple";
		
	}
    
    @PostMapping("/newCustomer/submit")
	public String verifyCustomer(@ModelAttribute("usuario")Customer customer) {
	    customerService.save(customer);    
	    return "redirect:/users/";
	}
    
 

}
