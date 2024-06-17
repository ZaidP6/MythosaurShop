package com.salesianostriana.dam.pilaraguilartiendaonline04.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.pilaraguilartiendaonline04.model.Category;
import com.salesianostriana.dam.pilaraguilartiendaonline04.model.Customer;
import com.salesianostriana.dam.pilaraguilartiendaonline04.model.Product;
import com.salesianostriana.dam.pilaraguilartiendaonline04.service.CategoryService;
import com.salesianostriana.dam.pilaraguilartiendaonline04.service.CustomerService;
import com.salesianostriana.dam.pilaraguilartiendaonline04.service.ProductService;

@Controller
public class MainController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/")
	public String index(Model model) {
		List<Product> productos = productService.findAll();
		List<Category> categorias = categoryService.findAll();
		model.addAttribute("products", productos);
		model.addAttribute("categorias", categorias);
		return "index";
	}

	@GetMapping("/form/signInSimple")
	public String showForm(Model model) {
		model.addAttribute("customerForm", new Customer());
		return "signInSimple";
	}

	@PostMapping("/form/signInSimple/submit")
	public String submitSignIn(@ModelAttribute("customerForm") Customer customer, Model model) {
		if(customerService.existsBasicUserUName(customer.getBasicUserUName())) {
			model.addAttribute("errorBasicUserUName", "El usuario ya existe");
			return "signInSimple";
		}
		if(customerService.existsCustomerMail(customer.getCustomerMail())) {
			model.addAttribute("errorCustomerMail", "El email ya existe");
			return "signInSimple";
		}else {
			customer.setBasicUserPassword(passwordEncoder.encode(customer.getBasicUserPassword()));
			customerService.save(customer);
			return "redirect:/";
		}
	}

	@GetMapping("/form/logIn")
	public String showLogInPage() {

		return "logIn";
	}

}
