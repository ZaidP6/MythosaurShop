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
	
	
	
	@GetMapping("/")  //Mostrar productos bbdd
	public String index(Model model) { 
		List<Product> productos = productService.findAll();
        model.addAttribute("products", productos);
		return "admin/indexAdmin";
	}
	
	@GetMapping("/nuevaCat") //muestra formulario vacio
	public String nuevaCategoria(Model model) {
        model.addAttribute("category",new Category());
		return "admin/nuevaCategoria";
	}
	
	//---------------- FUNCIONA --------------------------
	
	@GetMapping("/listCat")
	public String listarCategorias(Model model) {
		List<Category> categorias = categoryService.findAll();
		model.addAttribute("categorias", categoryService.findAll());
		return "admin/gestionCategorias";
	}
	
	
	

	@PostMapping("/nuevaCat/submit")
	public String nuevaCategoriaOk(@ModelAttribute("alumno") Category c) {
		categoryService.save(c);
		return "admin/gestionCategorias";//Podría ser también return "redirect:/list" si tuviera metodo para ello
	}
	
	//EDITAR PRODUCTO Y GUARDAR	
	
	@PostMapping("/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("categoria") Category c) {
		categoryService.edit(c);
		return "redirect:/";
	}
	
	//BORRAR PRODUCTO POR ID
	
	@GetMapping("/borrar/{categoryId}")
	public String borrar(@PathVariable("productId") long id) {
		productService.deleteById(id);
		return "redirect:/";
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