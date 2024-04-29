package com.salesianostriana.dam.prueba01.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.prueba01.model.Product;



@Service
public class DBService {

	
	public Product getProduct() {
		return new Product(001,"Llavero Deadpool", "Super llavero de Deadpool", 5.36,524,"No hay review, pero puedes ser el primero!");
	}
	
	
	public List<Product> productList(){
		return Arrays.asList(
				new Product(001,"Llavero Deadpool", "Super llavero de Deadpool", 5.36,524,"No hay review, pero puedes ser el primero!"),
				new Product(002,"Funko Deadpool 368", "Funko Pop de Deadpool tumbado", 17.90,1250,"No hay review, pero puedes ser el primero!"),
				new Product(003,"Funko Harry Potter 254", "Funko Pop de Harry Potter con Headwig", 18.90,1350,"No hay review, pero puedes ser el primero!"),
				new Product(004,"Taza Mythosaur Shop", "Nuestra magnífica taza Mythosaur Shop", 7.99,350,"No hay review, pero puedes ser el primero!")
				);
		
	}
	
	public Map<String, Product> productWishProduct(){
		return Collections.singletonMap("funko 254", 
				new Product(002,"Funko Deadpool 368", "Funko Pop de Deadpool tumbado", 17.90,1250,"No hay review, pero puedes ser el primero!"));
		
	}
	
}
