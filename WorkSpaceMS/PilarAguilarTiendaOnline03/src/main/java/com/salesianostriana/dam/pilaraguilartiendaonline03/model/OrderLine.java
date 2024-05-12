package com.salesianostriana.dam.pilaraguilartiendaonline03.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
					//ORDER
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_orderPedido_orderLine"))	
	private OrderPedido orderPedido;
	
}
