
package com.salesianostriana.dam.pilaraguilartiendaonline01.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor @Entity @Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Customer extends BasicUser{

	
	
	private String customerMail;
	private Date customerBirth;
	private Date customerLastSession;
	private String customerPhone;
	private String customerAddress;
	
	public Customer(String basicUserName, String basicUserPassword, String basicUserPhoto) {
		super(basicUserName, basicUserPassword, basicUserPhoto);
		// TODO Auto-generated constructor stub
	}
	
@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@OneToMany(
			mappedBy="customer", 
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<Order> orderUserList = new ArrayList<>();
	
}
