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
	
	public Admin(String basicUserUName, String basicUserName, String basicUserLastName, String basicUserPassword,
			String basicUserDni, String basicUserPhoto) {
		super(basicUserUName, basicUserName, basicUserLastName, basicUserPassword, basicUserDni, basicUserPhoto);
	}

	public Admin(String basicUserUName, String basicUserPassword) {
		super(basicUserUName, basicUserPassword);
	}


	
	
	
	
}
