package com.salesianostriana.dam.pilaraguilartiendaonline04.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.pilaraguilartiendaonline04.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

	Optional<Customer> findFirstByBasicUserUName(String basicUserUName);
	
	Customer findByBasicUserUName(String basicUserUName);
	
	boolean existsByBasicUserUName(String basicUserUName);
	
	boolean existsByCustomerMail(String customerMail);
	
	 @Query("""
		        SELECT COUNT(order)
		        FROM OrderPedido order
		        WHERE order.customer.basicUserId = :userId 
		        """) //AND order.orderOpen = false
	 public int countOrders(@PathVariable("userId") Long userId);
	 

}
