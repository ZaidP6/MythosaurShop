package com.salesianostriana.dam.pilaraguilartiendaonline01.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Product {

	@Id @GeneratedValue
	private int productId;
	
	private String productName;
	private String productDescription;
	private double productPvP;
	private int productStockQuantity;
	private String productReview;
	
}
