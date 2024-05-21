package com.salesianostriana.dam.pilaraguilartiendaonline04.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.pilaraguilartiendaonline04.model.Category;
import com.salesianostriana.dam.pilaraguilartiendaonline04.service.CategoryService;

@Controller
public class StaticController {

	@Autowired
	private CategoryService categoryService;

	public void llamarCategorias(Model model) {
		List<Category> categorias = categoryService.findAll();
		model.addAttribute("categorias", categorias);
	}

	@GetMapping("/contenidoContacto")
	public String contenidoContacto(Model model) {
		llamarCategorias(model);
		return "contenidoContacto";
	}

	@GetMapping("/trabajaConNosotros")
	public String trabaja(Model model) {
		llamarCategorias(model);
		return "trabajaConNosotros";
	}

	@GetMapping("/quienesSomos")
	public String quienesSomos(Model model) {
		llamarCategorias(model);
		return "quienesSomos";
	}

	@GetMapping("/politicaPrivacidad")
	public String privacidad(Model model) {
		llamarCategorias(model);
		return "politicaPrivacidad";
	}

	@GetMapping("/cookies")
	public String cookies(Model model) {
		llamarCategorias(model);
		return "cookies";
	}

	// ----------------------------------------------------------

	@GetMapping("/user/contenidoContacto")
	public String contenidoContactoC(Model model) {
		llamarCategorias(model);
		return "customer/contenidoContacto";
	}

	@GetMapping("/user/trabajaConNosotros")
	public String trabajaC(Model model) {
		llamarCategorias(model);
		return "customer/trabajaConNosotros";
	}

	@GetMapping("/user/quienesSomos")
	public String quienesSomosC(Model model) {
		llamarCategorias(model);
		return "customer/quienesSomos";
	}

	@GetMapping("/user/politicaPrivacidad")
	public String privacidadC(Model model) {
		llamarCategorias(model);
		return "customer/politicaPrivacidad";
	}

	@GetMapping("/user/cookies")
	public String cookiesC(Model model) {
		llamarCategorias(model);
		return "customer/cookies";
	}

	// ---------------------------------------------------------------

	@GetMapping("/admin/contenidoContacto")
	public String contenidoContactoA(Model model) {
		llamarCategorias(model);
		return "admin/contenidoContacto";
	}

	@GetMapping("/admin/trabajaConNosotros")
	public String trabajaA(Model model) {
		llamarCategorias(model);
		return "admin/trabajaConNosotros";
	}

	@GetMapping("/admin/quienesSomos")
	public String quienesSomosA(Model model) {
		llamarCategorias(model);
		return "admin/quienesSomos";
	}

	@GetMapping("/admin/politicaPrivacidad")
	public String privacidadA(Model model) {
		llamarCategorias(model);
		return "admin/politicaPrivacidad";
	}

	@GetMapping("/admin/cookies")
	public String cookiesA(Model model) {
		llamarCategorias(model);
		return "admin/cookies";
	}

}
