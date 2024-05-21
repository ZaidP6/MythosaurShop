package com.salesianostriana.dam.pilaraguilartiendaonline04.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.pilaraguilartiendaonline04.model.OrderPedido;

@Repository
public interface OrderRepository  extends JpaRepository<OrderPedido, Long>{

	
	/*
	 * @Query("""
			SELECT o
			FROM Order o LEFT JOIN o.OrderLine ol
			WHERE ol.product = ?1
			""")
	List<OrderLine> ventasConProducto(Product p);
	 */
	
	//boolean existByFinishedAndCustomer(boolean finished);
	
	
	
}
