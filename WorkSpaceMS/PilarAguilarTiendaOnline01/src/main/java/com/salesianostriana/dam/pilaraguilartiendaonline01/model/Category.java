package com.salesianostriana.dam.pilaraguilartiendaonline01.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Category {
	
	@Id
	private int categoryId;
	private String categoryName;
	private String categoryDescription;
}
