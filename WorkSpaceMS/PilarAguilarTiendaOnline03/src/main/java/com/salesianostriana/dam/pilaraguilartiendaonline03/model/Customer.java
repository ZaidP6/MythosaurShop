
package com.salesianostriana.dam.pilaraguilartiendaonline03.model;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuppressWarnings("serial")
@Entity @Data @NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true) @AllArgsConstructor
@SuperBuilder @DiscriminatorValue("USER")
public class Customer extends BasicUser{


	private String customerMail;
	private LocalDate customerBirth;
	private LocalDateTime customerLastSession;
	private String customerPhone;
	private String customerAddress;
	
						//ORDER
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy="customer", fetch = FetchType.EAGER)
	@Builder.Default
	private List<OrderPedido> orders = new ArrayList<>();
}
