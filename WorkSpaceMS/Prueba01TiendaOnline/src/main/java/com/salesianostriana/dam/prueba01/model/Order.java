package com.salesianostriana.dam.prueba01.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Order {

	@Id
	@GeneratedValue
	private int orderId;
	
	private Date orderDate;
	private List<OrderLine> orderShopList;
	
}
