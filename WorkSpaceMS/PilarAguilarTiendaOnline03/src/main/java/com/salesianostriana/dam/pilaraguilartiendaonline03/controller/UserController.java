package com.salesianostriana.dam.pilaraguilartiendaonline03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.pilaraguilartiendaonline03.model.Customer;
import com.salesianostriana.dam.pilaraguilartiendaonline03.repository.CustomerRepository;

@Controller
public class UserController {

    private final CustomerRepository customerRepository;

    public UserController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/form/signInSimple")
    public String showForm(Model model) {
        model.addAttribute("customerForm", new Customer());
        return "signInSimple";
    }

    @PostMapping("/form/signInSimple")
    public String addCustomer(@ModelAttribute("customerForm") Customer customer, Model model) {
        customerRepository.save(customer);
        return "redirect:/index";
    }

    @GetMapping("/logIn")
    public String showLogInPage() {
        return "logIn";
    }


}
