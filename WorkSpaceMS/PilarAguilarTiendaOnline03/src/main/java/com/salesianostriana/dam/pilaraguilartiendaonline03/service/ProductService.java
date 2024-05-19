package com.salesianostriana.dam.pilaraguilartiendaonline03.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pilaraguilartiendaonline03.model.Product;
import com.salesianostriana.dam.pilaraguilartiendaonline03.repository.ProductRepository;
import com.salesianostriana.dam.pilaraguilartiendaonline03.service.base.BaseServiceImpl;



@Service
public class ProductService 
    extends BaseServiceImpl<Product, Long, ProductRepository>{

	
	public void restarStock(Long id, int cantidad) {
		Optional<Product> optionalProducto = this.repository.findById(id);
		Product producto = optionalProducto.get();
		if (optionalProducto.isPresent()) {
			producto.setProductStockQuantity(producto.getProductStockQuantity() - cantidad);
			
		}
	}
	
}
