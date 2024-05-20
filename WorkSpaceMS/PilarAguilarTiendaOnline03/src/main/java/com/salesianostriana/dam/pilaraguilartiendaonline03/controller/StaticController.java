package com.salesianostriana.dam.pilaraguilartiendaonline03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticController {

	@GetMapping("/contenidoContacto")
	public String contenidoContacto() {
		return "contenidoContacto";
	}
	
	@GetMapping("/trabajaConNosotros")
	public String trabaja() {
		return "trabajaConNosotros";
	}
	
	@GetMapping("/quienesSomos")
	public String quienesSomos() {
		return "quienesSomos";
	}
	
	@GetMapping("/politicaPrivacidad")
	public String privacidad() {
		return "politicaPrivacidad";
	}
	
	@GetMapping("/cookies")
	public String cookies() {
		return "cookies";
	}
	
	//----------------------------------------------------------
	
	@GetMapping("/user/contenidoContacto")
	public String contenidoContactoC() {
		return "customer/contenidoContacto";
	}
	
	@GetMapping("/user/trabajaConNosotros")
	public String trabajaC() {
		return "customer/trabajaConNosotros";
	}
	
	@GetMapping("/user/quienesSomos")
	public String quienesSomosC() {
		return "customer/quienesSomos";
	}
	
	@GetMapping("/user/politicaPrivacidad")
	public String privacidadC() {
		return "customer/politicaPrivacidad";
	}
	
	@GetMapping("/user/cookies")
	public String cookiesC() {
		return "customer/cookies";
	}
	
	
	//---------------------------------------------------------------
	
	@GetMapping("/admin/contenidoContacto")
	public String contenidoContactoA() {
		return "admin/contenidoContacto";
	}
	
	@GetMapping("/admin/trabajaConNosotros")
	public String trabajaA() {
		return "admin/trabajaConNosotros";
	}
	
	@GetMapping("/admin/quienesSomos")
	public String quienesSomosA() {
		return "admin/quienesSomos";
	}
	
	@GetMapping("/admin/politicaPrivacidad")
	public String privacidadA() {
		return "admin/politicaPrivacidad";
	}
	
	@GetMapping("/admin/cookies")
	public String cookiesA() {
		return "admin/cookies";
	}
	
}
