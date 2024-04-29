package com.salesianostriana.dam.prueba01.model;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class OrderLine {
	
	private int orderLineProduct;
	private int orderLineQuantity;
	private double orderLinePrice;
}
