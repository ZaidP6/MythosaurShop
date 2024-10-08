package com.salesianostriana.dam.pilaraguilartiendaonline04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.salesianostriana.dam.pilaraguilartiendaonline04.model.Category;
import com.salesianostriana.dam.pilaraguilartiendaonline04.service.CategoryService;

@Controller
@RequestMapping("/admin/categoria")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	public void llamarCategorias(Model model) {
		categoryService.llamarCategorias(model);
	}

	@GetMapping("/list")
	public String listarCategorias(Model model) {
		model.addAttribute("categorias", categoryService.findAll());
		return "admin/gestionCategorias";
	}

	// BORRAR CATEGORIA POR ID

	@PostMapping("/borrar/{categoryId}")
	public String borrarCategoria(@PathVariable("categoryId") long id, RedirectAttributes redirectAttributes) {
	    if (categoryService.countProductsPerCategory(id) == 0) {
	        categoryService.deleteById(id);
	        redirectAttributes.addFlashAttribute("mensaje", "Categoría borrada satisfactoriamente");
	        redirectAttributes.addFlashAttribute("mensajeColor", "success");
	        return "redirect:/admin/categoria/list";
	    } else {
	        return "redirect:/admin/categoria/list?error";
	    }
	}


	// EDITAR CATEGORIA Y GUARDAR

	@GetMapping("/editar/{id}")
	public String mostrarFormCategoria(@PathVariable("id") long id, Model model) {
		Category category = categoryService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Categoría con Id:" + id + " no válido"));
		if (category != null) {
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

	@GetMapping("/nueva") // muestra formulario vacio
	public String nuevaCategoria(Model model) {
		model.addAttribute("category", new Category());
		return "admin/nuevaCategoria";
	}

	@PostMapping("/nueva/submit")
	public String nuevaCategoriaOk(@ModelAttribute("category") Category c) {
		categoryService.save(c);
		return "redirect:/admin/categoria/list";// Podría ser también return "admin/gestionCategorias";
	}

	// ---------------- FUNCIONA --------------------------

}
