package com.salesianostriana.dam.pilaraguilartiendaonline01.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor @Entity @Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Admin extends BasicUser {

	
	public Admin(String basicUserName, String basicUserPassword, String basicUserPhoto) {
		super(basicUserName, basicUserPassword, basicUserPhoto);
		// TODO Auto-generated constructor stub
	}

	
}
