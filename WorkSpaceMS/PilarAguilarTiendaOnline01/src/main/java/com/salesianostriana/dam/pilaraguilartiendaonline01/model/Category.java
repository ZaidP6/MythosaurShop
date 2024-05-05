
package com.salesianostriana.dam.pilaraguilartiendaonline01.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Category {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryId;
	private String categoryName;
	private String categoryDescription;
	
	
	@OneToMany(
			mappedBy="category", 
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<Product> productList = new ArrayList<>();
	
	

}
