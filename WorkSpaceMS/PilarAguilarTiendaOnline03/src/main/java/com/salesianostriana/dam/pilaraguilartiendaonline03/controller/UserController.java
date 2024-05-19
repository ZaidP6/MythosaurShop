package com.salesianostriana.dam.pilaraguilartiendaonline03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.pilaraguilartiendaonline03.model.Customer;
import com.salesianostriana.dam.pilaraguilartiendaonline03.model.Product;
import com.salesianostriana.dam.pilaraguilartiendaonline03.service.CustomerService;
import com.salesianostriana.dam.pilaraguilartiendaonline03.service.ProductService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private ProductService productService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/")
	public String index(Model model) {
		List<Product> productos = productService.findAll();
		model.addAttribute("products", productos);
		return "customer/indexCustomer";
	}

	@GetMapping("/newCustomer")
	public String nuevoUsuario(Model model) {

		model.addAttribute("customer", new Customer());

		return "signInSimple";

	}

	@PostMapping("/newCustomer/submit")
	public String verifyCustomer(@ModelAttribute("usuario") Customer customer) {
		customerService.save(customer);
		return "redirect:/users/";
	}

	// ---------------- FUNCIONA ------------------------

	
	
	
	
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

}
