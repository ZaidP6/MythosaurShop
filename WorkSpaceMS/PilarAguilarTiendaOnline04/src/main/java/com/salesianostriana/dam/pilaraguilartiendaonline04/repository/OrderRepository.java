package com.salesianostriana.dam.pilaraguilartiendaonline04.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.pilaraguilartiendaonline04.model.Customer;
import com.salesianostriana.dam.pilaraguilartiendaonline04.model.OrderPedido;

@Repository
public interface OrderRepository  extends JpaRepository<OrderPedido, Long>{


	@Query("""
			SELECT o 
			FROM OrderPedido o 
			WHERE o.customer = :customer AND o.orderOpen = true
			""")
	public Optional<OrderPedido> findFirstByOrderOpenAndCustomer(Customer customer);
	
	
	@Query("""
			SELECT o 
			FROM OrderPedido o 
			WHERE o.customer = :customer and o.orderOpen = false
			""")
    public List<OrderPedido> findByOrderFinishedAndCustomer(Customer customer);
	
	
	@Query("""
			SELECT op
			FROM OrderPedido op
			WHERE op.orderOpen = false
			""")
	public List<OrderPedido> findByOrderFinished();
	
	 @Query("""		
	 		SELECT COUNT(order) 
	 		FROM OrderPedido order 
	 		WHERE order.orderOpen = false
	 		""")
	 public Long finishedOrderCount();
	 
	 @Query("""
	 		SELECT SUM(order.orderTotalAmount) 
	 		FROM OrderPedido order 
	 		WHERE order.orderOpen = false
	 		""")
	 public double findTotalAmount();
	
}
