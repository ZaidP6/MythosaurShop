package com.salesianostriana.dam.pilaraguilartiendaonline04.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.pilaraguilartiendaonline04.model.Product;
import com.salesianostriana.dam.pilaraguilartiendaonline04.repository.ProductRepository;
import com.salesianostriana.dam.pilaraguilartiendaonline04.service.base.BaseServiceImpl;

@Service
public class ProductService extends BaseServiceImpl<Product, Long, ProductRepository> {

	// método que al añadir el producto al carrito, éste se decuenta del stock total
	public void restarStock(Long id, int cantidad) {
		Optional<Product> optionalProducto = this.repository.findById(id);
		Product producto = optionalProducto.get();
		if (optionalProducto.isPresent()) {
			producto.setProductStockQuantity(producto.getProductStockQuantity() - cantidad);

		}
	}

	public List<Product> listarProductosCategoria(String category) {

		return repository.productPerCategory(category);
	}

	public List<Product> searchByKeyword(String keyWord) {
		return repository.findByProductNameContainingIgnoreCase(keyWord);
	}
	
	public int countOrdersPerProduct(@PathVariable("productId") Long productId) {
		return repository.countOrders(productId);
	}
	
	public Product getMostPupularProduct() {
		return repository.findMostPopularProduct();
	}

}
