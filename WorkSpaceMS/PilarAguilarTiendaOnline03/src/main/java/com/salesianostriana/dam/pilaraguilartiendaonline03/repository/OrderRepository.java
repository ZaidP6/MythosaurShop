package com.salesianostriana.dam.pilaraguilartiendaonline03.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.pilaraguilartiendaonline03.model.OrderLine;
import com.salesianostriana.dam.pilaraguilartiendaonline03.model.Product;

public interface OrderRepository {

	
	@Query("""
			SELECT o
			FROM Order o LEFT JOIN o.OrderLine ol
			WHERE ol.product = ?1
			""")
	List<OrderLine> ventasConProducto(Product p);
	
}
