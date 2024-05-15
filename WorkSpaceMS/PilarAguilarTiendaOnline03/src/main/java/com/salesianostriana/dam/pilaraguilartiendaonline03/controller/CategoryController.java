package com.salesianostriana.dam.pilaraguilartiendaonline03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.pilaraguilartiendaonline03.service.CategoryService;

@Controller
public class CategoryController {
	
	public CategoryService categoryService;

	@GetMapping("/admin/nuevaCategoria")
	public String nuevaCategoria() {
		
		return "nuevaCategoria";
	}
	
	@PostMapping("/admin/nuevaCategoria/submit")
	public String nuevaCategoriaOk() {
		
		return "gestionCategorias";
	}
	
}
