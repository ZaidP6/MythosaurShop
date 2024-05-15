package com.salesianostriana.dam.pilaraguilartiendaonline03.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.salesianostriana.dam.pilaraguilartiendaonline03.service.AdminService;

@Controller
//@RequestMapping("/admin")
public class AdminController {

	@Autowired
	public AdminService adminService;
	
	@GetMapping("/admin")
	public String index() {

		return "indexAdmin";
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