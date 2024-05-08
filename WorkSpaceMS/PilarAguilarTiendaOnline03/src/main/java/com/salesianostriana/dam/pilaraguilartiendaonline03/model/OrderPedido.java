
package com.salesianostriana.dam.pilaraguilartiendaonline03.model;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
public class OrderPedido {

	@Id
	@GeneratedValue
	private long orderId;
	
	private LocalDate orderDate;

}
