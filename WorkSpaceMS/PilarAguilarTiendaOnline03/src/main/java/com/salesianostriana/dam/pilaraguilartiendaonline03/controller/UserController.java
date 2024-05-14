package com.salesianostriana.dam.pilaraguilartiendaonline03.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.pilaraguilartiendaonline03.model.Customer;
import com.salesianostriana.dam.pilaraguilartiendaonline03.service.CustomerService;

@Controller
public class UserController {

    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

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
    
   
    @GetMapping("/newCustomer")
	public String nuevoUsuario(Model model) {
		
		model.addAttribute("customer",new Customer());
		
		return "signInSimple";
		
	}
    
    @PostMapping("/newCustomer/submit")
	public String verifyCustomer(@ModelAttribute("usuario")Customer customer) {
	    customerService.save(customer);    
	    return "redirect:/users/";
	}

    @GetMapping("/myProfile")
    public String myProfile() {

        Customer c = (Customer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        System.out.println(c.toString());

        return "perfil";
    }

    @GetMapping("/myProfile2")
    public String myProfile2(@AuthenticationPrincipal Customer c) {

        System.out.println(c.toString());

        return "perfil";
    }
    @GetMapping("/customer/index")
    public String showIndexCustomer() {

        return "/customer/indexCustomer";
    }


}
