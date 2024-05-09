package com.salesianostriana.dam.pilaraguilartiendaonline03.model;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity @Builder
public class Product {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	
	private String productName;
	
	@Lob  //se usa para aligerar carga
	private String productDescription;
	private double productPvP;
	private int productStockQuantity;
	
	private String productImage;
	
	@DateTimeFormat(pattern = "dd-MM-YYYY")
	private LocalDate productDate;
	
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_product_category"))	
	private Category category;
	
	
	/*
	 * MÉTODOS HELPER PARA LA ASOCIACIÓN CON CATEGORY
	 */
	
	public void addToCategory(Category category) {
		this.category = category;
		category.getProducts().add(this);
	}
	
	public void removeFromCategory(Category category) {
		category.getProducts().remove(this);
		this.category = null;	
	}
}
