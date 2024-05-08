package com.salesianostriana.dam.pilaraguilartiendaonline03.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderLine {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderLineId;
	
	//private Product orderLineProduct;
	private int orderLineQuantity;
	private double orderLinePrice;
	
}

