package com.salesianostriana.dam.prueba01.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.prueba01.service.DBService;


@Controller
public class MainController {

	
	@Autowired
	private DBService dbService;
	
	
	public String returnProduct(@RequestParam(name="productName", required=false, defaultValue="Mundo") String nombre, Model model) {
				
		model.addAttribute("productName", nombre);
		//Tomamos la fecha y hora actual del sistema con
		model.addAttribute("today", LocalDate.now());
		// Obtenemos desde el servicio la instancia de un producto
		model.addAttribute("product", dbService.getProduct());
		// Obtenemos desde el servicio un listado con varios productos
		model.addAttribute("lista", dbService.productList());
		// Obtenemos desde el servicio un HashMap con un producto
		model.addAttribute("map", dbService.productList());
		// Obtenemos del servicio la instancia de un producto sin alguno de sus valores		
		model.addAttribute("producto2",dbService.productWishProduct());
		
		model.addAttribute("quantity", dbService.getProduct().getProductStockQuantity());
		
		//Devolvemos el nombre del archivo html que se debe pintar como respuesta a esta petición
		return "index";
		
	}
	
}
