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
	 public long finishedOrderCount();
	 
	 @Query("""
	 		SELECT CASE WHEN SUM(order.orderTotalAmount) > 0 
	 					THEN  SUM(order.orderTotalAmount) 
	 					ELSE 0 
	 					END
	 		FROM OrderPedido order 
	 		WHERE order.orderOpen = false
	 		""")
	 public double findTotalAmount();
	 
	 @Query("""
	 		SELECT CASE WHEN AVG(ol.orderLineQuantity) > 0
	 					THEN AVG(ol.orderLineQuantity)
	 					ELSE 0
	 					END
	 		FROM OrderPedido order JOIN order.orderLines ol
	 		WHERE order.orderOpen = false
	 		""")
	 public double findAVGProductsPerOrder();
	 
	 @Query("""
	 		SELECT CASE WHEN AVG(order.orderTotalAmount) > 0
	 					THEN AVG(order.orderTotalAmount)
	 					ELSE 0
	 					END
	 		FROM OrderPedido order
	 		WHERE order.orderOpen = false
	 		""")
	 public double findAVGPricePerOrder();
	
}
