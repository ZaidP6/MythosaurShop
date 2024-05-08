package com.salesianostriana.dam.pilaraguilartiendaonline03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticController {

	@GetMapping("/contenidoContacto")
	public String contenidoContacto() {
		return "contenidoContacto";
	}
	
	@GetMapping("/trabaja")
	public String trabaja() {
		return "trabajaConNosotros";
	}
	
	@GetMapping("/quienesSomos")
	public String quienesSomos() {
		return "quienesSomos";
	}
	
	
}
