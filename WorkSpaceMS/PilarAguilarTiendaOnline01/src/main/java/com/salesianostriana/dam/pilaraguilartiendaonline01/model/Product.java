package com.salesianostriana.dam.pilaraguilartiendaonline01.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import jakarta.persistence.ForeignKey;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Product {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	
	private String productName;
	private String productDescription;
	private double productPvP;
	private int productStockQuantity;
	
	private String productImage;
	
	@DateTimeFormat(pattern = "dd-MM-YYYY")
	private LocalDate productDate;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_product_orderline"))	
	private OrderLine orderLine;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_product_category"))	
	private Category category;
	
	@Builder.Default
	private List<Theme> themes = new ArrayList<>();

}
