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
import com.salesianostriana.dam.pilaraguilartiendaonline03.service.CategoryService;

@Controller
@RequestMapping("/admin/categoria")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	public void llamarCategorias (Model model) {
		List<Category> categorias = categoryService.findAll();
		model.addAttribute("categorias", categorias);
	}
	
	@GetMapping("/list")
	public String listarCategorias(Model model) {
		model.addAttribute("categorias", categoryService.findAll());
		return "admin/gestionCategorias";
	}
	
	//BORRAR CATEGORIA POR ID
	
	@GetMapping("/borrar/{categoryId}")
	public String borrar(@PathVariable("categoryId") long id) {
		categoryService.deleteById(id);
		return "redirect:/admin/categoria/list";
	}
	
	//EDITAR CATEGORIA Y GUARDAR
	
	@GetMapping("/editar/{id}")
	public String mostrarFormCategoria(@PathVariable("id") long id, Model model) {
		Category category = categoryService.findById(id).get();  //Esto no le gusta a Luismi asi, buscar otra manera
		if(category!=null) {
			model.addAttribute("category", category);
			return "admin/nuevaCategoria";
		} else {
			return "redirect:/admin/categoria/list";
		}
		
	}
	
	@PostMapping("/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("category") Category c) {
		categoryService.save(c);
		return "redirect:/admin/categoria/list";
	}
		
	@GetMapping("/nueva") //muestra formulario vacio
	public String nuevaCategoria(Model model) {
        model.addAttribute("category",new Category());
		return "admin/nuevaCategoria";
	}
	
	@PostMapping("/nueva/submit")
	public String nuevaCategoriaOk(@ModelAttribute("category") Category c) {
		categoryService.save(c);
		return "redirect:/admin/categoria/list";//Podría ser también return "admin/gestionCategorias";
	}
	
	//---------------- FUNCIONA --------------------------
	
	
	
		
	
	
		
	
}


