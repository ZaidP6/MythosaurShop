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
import com.salesianostriana.dam.pilaraguilartiendaonline03.model.Customer;
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
	private CategoryService categoryService;

	@Autowired
	private CustomerService customerService;

	public void llamarCategorias(Model model) {
		List<Category> categorias = categoryService.findAll();
		model.addAttribute("categorias", categorias);
	}

	@GetMapping("/") // Mostrar productos bbdd en indexAdmin
	public String index(Model model) {
		List<Product> productos = productService.findAll();
		model.addAttribute("products", productos);
		llamarCategorias(model);
		return "admin/indexAdmin";
	}

	@GetMapping("/cliente/list")
	public String listarClientes(Model model) {
		model.addAttribute("customers", customerService.findAll());
		llamarCategorias(model);
		return "admin/gestionClientes";
	}

	@GetMapping("/cliente/nuevo")
	public String nuevoCliente(Model model) {
		model.addAttribute("customer", new Customer());
		return "admin/nuevoCliente";
	}

	@PostMapping("/cliente/nuevo/submit")
	public String nuevoClienteOk(@ModelAttribute("customer") Customer c) {
		customerService.save(c);
		return "redirect:/admin/cliente/list";
	}

	@GetMapping("/cliente/editar/{id}")
	public String mostrarFormCliente(@PathVariable("id") long id, Model model) {
		Customer customer = customerService.findById(id).get(); // Esto no le gusta a Luismi asi, buscar otra manera
		if (customer != null) {
			model.addAttribute("customer", customer);
			return "admin/nuevoCliente";
		} else {
			return "redirect:/admin/cliente/list";
		}
	}

	@PostMapping("/cliente/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("customer") Customer c) {
		customerService.save(c);
		return "redirect:/admin/cliente/list";
	}

	// BORRAR CLIENTE POR ID

	@GetMapping("/cliente/borrar/{customerId}")
	public String borrar(@PathVariable("customerId") long id) {
		customerService.deleteById(id);
		return "redirect:/admin/cliente/list";
	}

	// ---------------- FUNCIONA --------------------------

}