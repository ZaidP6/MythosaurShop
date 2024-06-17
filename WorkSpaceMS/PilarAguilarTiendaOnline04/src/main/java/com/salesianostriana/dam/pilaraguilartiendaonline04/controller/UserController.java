package com.salesianostriana.dam.pilaraguilartiendaonline04.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.pilaraguilartiendaonline04.model.Category;
import com.salesianostriana.dam.pilaraguilartiendaonline04.model.Customer;
import com.salesianostriana.dam.pilaraguilartiendaonline04.model.Product;
import com.salesianostriana.dam.pilaraguilartiendaonline04.service.CategoryService;
import com.salesianostriana.dam.pilaraguilartiendaonline04.service.CustomerService;
import com.salesianostriana.dam.pilaraguilartiendaonline04.service.ProductService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@Autowired 
	private PasswordEncoder passwordEncoder;
	 

	public void llamarCategorias(Model model) {
		List<Category> categorias = categoryService.findAll();
		model.addAttribute("categorias", categorias);
	}

	@GetMapping("/")
	public String index(Model model) {
		List<Product> productos = productService.findAll();
		model.addAttribute("products", productos);
		llamarCategorias(model);
		return "customer/indexCustomer";
	}

	@GetMapping("/newCustomer")
	public String nuevoUsuario(Model model) {
		model.addAttribute("customer", new Customer());
		return "signInSimple";
	}

	// Verifica si el nombre de usuario ya existe pero lo sigue admitiendo
	@PostMapping("/newCustomer/submit")
	public String verifyCustomer(@ModelAttribute("customer") Customer customer, Model model) {

		if (customerService.findByBasicUserUName(customer.getUsername()) != null) {
			model.addAttribute("error", "El nombre de usuario ya existe.");
			return "signInSimple";
		}

		// Guarda el nuevo usuario si el username no existe
		customerService.save(customer);
		return "redirect:/user/";
	}
	
	@GetMapping("/profile")
	public String showProfile(@AuthenticationPrincipal Customer customer, Model model) {
		model.addAttribute("customer", customer);
		return "customer/userProfile";
	}
	
	@PostMapping("/profile/edit/submit")
	public String showEditProfile(@ModelAttribute("customer") Customer customer) {
	customer.setBasicUserPassword(passwordEncoder.encode(customer.getBasicUserPassword()));
	Customer editCustomer = customerService.edit(customer);
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	authentication = new UsernamePasswordAuthenticationToken(editCustomer, authentication.getCredentials(), authentication.getAuthorities());
	SecurityContextHolder.getContext().setAuthentication(authentication);
	return "redirect:/user/profile";
	}

	// ---------------- FUNCIONA ------------------------

}
