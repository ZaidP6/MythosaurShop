package com.salesianostriana.dam.pilaraguilartiendaonline03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.pilaraguilartiendaonline03.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


	@Query("""
			SELECT p
		     FROM Product p
		     WHERE p.productPvP < :precio
		""")
	public List<Product> buscarPrecioMenor10(double precio);

	

	
   /*
    *public List<Product> findByNameContainsIgnoreCase (String search){
  
        SELECT *
        FROM product
        WHERE search ILIKE '%search%';
         
        return productRepository.findByName(search, productName);
    }
    */

}
