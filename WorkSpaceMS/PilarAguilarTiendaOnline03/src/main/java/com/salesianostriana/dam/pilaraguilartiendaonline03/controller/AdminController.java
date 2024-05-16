package com.salesianostriana.dam.pilaraguilartiendaonline03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.pilaraguilartiendaonline03.model.Category;
import com.salesianostriana.dam.pilaraguilartiendaonline03.model.Product;
import com.salesianostriana.dam.pilaraguilartiendaonline03.service.AdminService;
import com.salesianostriana.dam.pilaraguilartiendaonline03.service.CategoryService;
import com.salesianostriana.dam.pilaraguilartiendaonline03.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	public AdminService adminService;
	
	@Autowired
	public ProductService productService;
	
	@Autowired
	public CategoryService categoryService;
	
	
	
	@GetMapping("/")
	public String index(Model model) { 
		List<Product> productos = productService.findAll();
        model.addAttribute("products", productos);
		return "admin/indexAdmin";
	}
	
	//---------------- FUNCIONA --------------------------
	
	@GetMapping("/nuevaCategoria")
	public String nuevaCategoria(Model model) {
		List<Category> categories = categoryService.findAll();
        model.addAttribute("products", categories);
		return "admin/nuevaCategoria";
	}
	
	@PostMapping("/nuevaCategoria/submit")
	public String nuevaCategoriaOk() {
		
		return "gestionCategorias";
	}
	
	@GetMapping("/nuevoProducto")
	public String nuevoProducto() {
		
		return "nuevoProducto";
	}
	
	@PostMapping("/nuevoProduct/submit")
	public String nuevoProductoOk() {
		
		return "gestionProductos";
	}
	
	
}