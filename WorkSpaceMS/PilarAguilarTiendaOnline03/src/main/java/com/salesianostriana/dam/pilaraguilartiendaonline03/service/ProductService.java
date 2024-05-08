package com.salesianostriana.dam.pilaraguilartiendaonline03.service;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pilaraguilartiendaonline03.model.Product;
import com.salesianostriana.dam.pilaraguilartiendaonline03.repository.ProductRepository;
import com.salesianostriana.dam.pilaraguilartiendaonline03.service.base.BaseServiceImpl;

import jakarta.annotation.PostConstruct;



@Service
public class ProductService 
    extends BaseServiceImpl<Product, Long, ProductRepository>{

	@Autowired
	private ProductRepository productRepository;
	
	
	@PostConstruct
	void ejecutar() {
		
		productRepository.findAll().forEach(new Consumer <Product>() {
		
			public void accept(Product p) {
				System.out.println();
			}
		});	
		
	}
	
	public void agregar (Product p) {
		productRepository.save(p);	
	}
	
	public List<Product> getLista (){
		return productRepository.findAll();
	}
	
	public Product findById(long id) {
		return productRepository.findById(id).orElse(null);
	}
	public void editar (Product p) {
		productRepository.save(p);		
	}
	
	public void delete (long id) {
		productRepository.deleteById(id);
	}
	
    public List<Product> showAllProducts() {
        return productRepository.findAll();
    }
}
