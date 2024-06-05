package com.salesianostriana.dam.pilaraguilartiendaonline04.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.pilaraguilartiendaonline04.model.Customer;
import com.salesianostriana.dam.pilaraguilartiendaonline04.model.OrderPedido;
import com.salesianostriana.dam.pilaraguilartiendaonline04.model.Product;

@Repository
public interface OrderRepository  extends JpaRepository<OrderPedido, Long>{

	@Query
	public boolean productInCart(Customer c, Product p);
	
	public boolean existsByOrderFinishedAndCustomer(boolean orderFinished, Customer c);
	
	public Optional<OrderPedido> findFirstByFinishedAndUser(boolean orderFinished, Customer c);
	
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
