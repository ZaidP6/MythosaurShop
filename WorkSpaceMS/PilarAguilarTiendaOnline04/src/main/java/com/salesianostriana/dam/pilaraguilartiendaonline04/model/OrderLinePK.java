package com.salesianostriana.dam.pilaraguilartiendaonline04.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
public class OrderLinePK implements Serializable{
	

	private static final long serialVersionUID = 1L;

	private OrderPedido order;
	private Long orderLineId;
	

}
