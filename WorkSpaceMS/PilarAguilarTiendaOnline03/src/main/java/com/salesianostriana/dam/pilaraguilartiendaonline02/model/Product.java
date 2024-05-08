package com.salesianostriana.dam.pilaraguilartiendaonline02.model;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
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
	
	
}
