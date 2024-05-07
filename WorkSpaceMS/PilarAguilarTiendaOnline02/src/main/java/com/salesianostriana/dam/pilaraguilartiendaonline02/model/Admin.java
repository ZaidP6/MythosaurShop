package com.salesianostriana.dam.pilaraguilartiendaonline02.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor @Entity @Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Admin extends BasicUser {

	public Admin(String basicUserName, String basicUserPassword, String basicUserDni, String basicUserPhoto) {
		super(basicUserName, basicUserPassword, basicUserDni, basicUserPhoto);
		// TODO Auto-generated constructor stub
	}

	
	
	
}
