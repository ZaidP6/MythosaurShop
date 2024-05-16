package com.salesianostriana.dam.pilaraguilartiendaonline03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.pilaraguilartiendaonline03.model.Category;
import com.salesianostriana.dam.pilaraguilartiendaonline03.model.Product;
import com.salesianostriana.dam.pilaraguilartiendaonline03.service.AdminService;
import com.salesianostriana.dam.pilaraguilartiendaonline03.service.CategoryService;
import com.salesianostriana.dam.pilaraguilartiendaonline03.service.CustomerService;
import com.salesianostriana.dam.pilaraguilartiendaonline03.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CustomerService customerService;
	
	
	
	@GetMapping("/")  //Mostrar productos bbdd en indexAdmin
	public String index(Model model) { 
		List<Product> productos = productService.findAll();
        model.addAttribute("products", productos);
		return "admin/indexAdmin";
	}
	
	//---------------- FUNCIONA --------------------------
	
	
	@GetMapping("/customer/list")
	public String listarClientes(Model model) {
		model.addAttribute("clientes", customerService.findAll());
		return "admin/gestionClientes";
	}
	
	//BORRAR CLIENTE POR ID
	
		@GetMapping("/customer/borrar/{customerId}")
		public String borrar(@PathVariable("customerId") long id) {
			customerService.deleteById(id);
			return "redirect:/admin/customer/list";
		}
		
	
	
}