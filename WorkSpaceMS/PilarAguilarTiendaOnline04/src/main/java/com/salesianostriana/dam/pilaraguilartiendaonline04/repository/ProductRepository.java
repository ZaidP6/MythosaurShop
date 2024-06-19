package com.salesianostriana.dam.pilaraguilartiendaonline04.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.pilaraguilartiendaonline04.model.Product;

//import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("""
			SELECT p
			FROM Product p
			WHERE p.category.categoryName = :category
			""") 
	public List<Product> productPerCategory(@Param("category") String category);

	public List<Product> findByProductNameContainingIgnoreCase(String search);
	

	 @Query("""
	 		SELECT COUNT(order) 
	 		FROM OrderPedido order JOIN order.orderLines ol 
	 		WHERE ol.product.productId = :productId 
	 		""") //AND op.orderOpen = false
	 public int countOrders(@PathVariable("productId") Long productId);
	 
	 @Query("""
			    SELECT p 
			    FROM OrderPedido o JOIN o.orderLines ol JOIN ol.product p 
			    WHERE o.orderOpen = false 
			    GROUP BY p 
			    ORDER BY SUM(ol.orderLineQuantity) DESC
			    LIMIT 1
			    """)
	public Optional<Product> findMostPopularProduct();

}
