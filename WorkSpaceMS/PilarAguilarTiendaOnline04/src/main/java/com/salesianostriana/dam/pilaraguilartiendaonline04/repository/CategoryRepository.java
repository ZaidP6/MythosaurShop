package com.salesianostriana.dam.pilaraguilartiendaonline04.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.pilaraguilartiendaonline04.model.Category;


public interface CategoryRepository extends JpaRepository<Category, Long>{

	
	public void listarCategorias();
	
	
	 @Query("""
	            SELECT COUNT(p)
	            FROM Product p
	            WHERE p.category.categoryId = :catId
	            """)
	    public int countProductsPerCategory(@PathVariable("catId") Optional<Category> optional);
	 
	}
