package com.salesianostriana.dam.pilaraguilartiendaonline01.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import jakarta.persistence.ForeignKey;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderLine {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderLineId;
	
	private Product orderLineProduct;
	private int orderLineQuantity;
	private double orderLinePrice;
	
	 @ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_orderline_order"))	
	private Order order;
	
	
	 @ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@OneToMany(
			mappedBy="orderLine", 
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	
	private List<Product> productList = new ArrayList<>();
	
}

