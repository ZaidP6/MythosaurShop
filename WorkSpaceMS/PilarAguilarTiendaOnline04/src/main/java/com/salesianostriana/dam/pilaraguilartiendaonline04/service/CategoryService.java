package com.salesianostriana.dam.pilaraguilartiendaonline04.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.pilaraguilartiendaonline04.model.Category;
import com.salesianostriana.dam.pilaraguilartiendaonline04.repository.CategoryRepository;
import com.salesianostriana.dam.pilaraguilartiendaonline04.service.base.BaseServiceImpl;

@Service
public class CategoryService extends BaseServiceImpl<Category, Long, CategoryRepository>{
	
	public void llamarCategorias(Model model) {
		List<Category> categorias = findAll();
		model.addAttribute("categorias", categorias);
	}

	
	 public int countProductsPerCategory(@PathVariable("catId") Long catId) {
		 
		return repository.countProducts(catId);
		 
	 }
}
