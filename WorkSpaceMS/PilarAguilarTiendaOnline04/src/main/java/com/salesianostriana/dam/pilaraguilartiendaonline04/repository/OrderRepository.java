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

	
	
	
	
	@Query("""
			SELECT o 
			FROM OrderPedido o 
			WHERE o.customer = :customer AND o.orderFinished = false
			""")
	public Optional<OrderPedido> findFirstByOrderOpenAndCustomer(Customer c);
	
	
	
	
	
}
