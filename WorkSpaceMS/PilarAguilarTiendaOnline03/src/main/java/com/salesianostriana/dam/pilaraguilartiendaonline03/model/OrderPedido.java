
package com.salesianostriana.dam.pilaraguilartiendaonline03.model;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;
	
	private LocalDate orderDate;
	
					//CUSTOMER
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_orderPedido_customer"))	
	private Customer customer;
	
	/*
	 * MÉTODOS HELPER PARA LA ASOCIACIÓN CON CURSO
	 */
	
	public void addToCurso(Customer customer) {
		this.customer = customer;
		customer.getOrders().add(this);
	}
	
	public void removeFromCurso(Customer customer) {
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
	private List<OrderLine> orderLine = new ArrayList<>();

	
			// MÉTODOS HELPER 
	
	public void addOrderLine(OrderLine ol) {
		ol.setOrderPedido(this);
		this.orderLine.add(ol);
	}
	
	public void removeOrderLine(OrderLine ol) {
		this.orderLine.remove(ol);
		ol.setOrderPedido(null);
		
	}

}