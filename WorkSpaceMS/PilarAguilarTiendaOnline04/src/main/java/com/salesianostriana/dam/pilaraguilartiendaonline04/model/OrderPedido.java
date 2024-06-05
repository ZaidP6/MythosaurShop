
package com.salesianostriana.dam.pilaraguilartiendaonline04.model;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ForeignKey;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderPedido {

	@Id
	@GeneratedValue
	private long orderId;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime orderDate;
	
	private double orderTotalAmount;
	
					//CUSTOMER
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_orderPedido_customer"))	
	private Customer customer;
	
	/*
	 * MÉTODOS HELPER PARA LA ASOCIACIÓN CON CUSTOMER
	 */
	
	public void addToCustomer(Customer customer) {
		this.customer = customer;
		customer.getOrders().add(this);
	}
	
	public void removeFromCustomer(Customer customer) {
		customer.getOrders().remove(this);
		this.customer = null;	
	}
	
					//ORDERLINE
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@OneToMany(
			mappedBy="orderPedido", 
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<OrderLine> orderLines = new ArrayList<>();

	
			// MÉTODOS HELPER 
	
	public void addOrderLine(OrderLine ol) {
		ol.setOrderPedido(this);
		this.orderLines.add(ol);
	}
	
	public void removeOrderLine(OrderLine ol) {
		this.orderLines.remove(ol);
		ol.setOrderPedido(null);
		
	}
	
	 public double calcularTotal() {
	        return orderLines.stream().mapToDouble(OrderLine::obtenerPrecioOrderLine).sum();
	    }

}
