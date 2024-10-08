package com.salesianostriana.dam.pilaraguilartiendaonline04.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
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
@IdClass(OrderLinePK.class)
public class OrderLine {
	

	@Id @GeneratedValue 
	private long orderLineId;
	
	//private Product orderLineProduct;
	private int orderLineQuantity;
	
	
					//ORDER
	
	@ManyToOne @Id
	@JoinColumn(foreignKey = @ForeignKey(name="fk_orderPedido_orderLine"))	
	private OrderPedido orderPedido;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_product_orderLine"))
	Product product;
	
	
	public double obtenerPrecioOrderLine() {
		return product.getProductPvP() * orderLineQuantity;
	}
	
}

