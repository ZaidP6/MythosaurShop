package com.salesianostriana.dam.pilaraguilartiendaonline03.controller;

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

	
	@GetMapping("/list")
	public String listarCategorias(Model model) {
		model.addAttribute("categorias", categoryService.findAll());
		return "admin/gestionCategorias";
	}
	
	//---------------- FUNCIONA --------------------------
	
	@GetMapping("/nueva") //muestra formulario vacio
	public String nuevaCategoria(Model model) {
        model.addAttribute("category",new Category());
		return "admin/nuevaCategoria";
	}
	
	@PostMapping("/nueva/submit")
	public String nuevaCategoriaOk(@ModelAttribute("category") Category c) {
		categoryService.save(c);
		return "redirect:/list";//Podría ser también return "admin/gestionCategorias";
	}
	
	//EDITAR PRODUCTO Y GUARDAR	
	
		@PostMapping("/editar/submit")
		public String procesarFormularioEdicion(@ModelAttribute("categoria") Category c) {
			categoryService.edit(c);
			return "redirect:/";
		}
		
		//BORRAR PRODUCTO POR ID
		
		@GetMapping("/borrar/{categoryId}")
		public String borrar(@PathVariable("categoryId") long id) {
			categoryService.deleteById(id);
			return "redirect:/";
		}
	
}


