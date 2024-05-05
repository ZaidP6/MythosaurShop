
package com.salesianostriana.dam.pilaraguilartiendaonline01.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
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

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

	@Id
	@GeneratedValue
	private long orderId;
	
	
	private LocalDate orderDate;
	
	//one to many de Order a OrderLine
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@OneToMany(
			mappedBy="order", 
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<OrderLine> orderShopList = new ArrayList<>();
	
	//Many to one de Order a USer
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_order_user"))	
	private Customer customer;

}
