package com.salesianostriana.dam.pilaraguilartiendaonline02.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@MappedSuperclass 
public class BasicUser {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long basicUserId;
	
	private String basicUserUName;
	private String basicUserPassword;
	private String basicUserDni;
	private String basicUserName;
	private String basicUserLastName;
	private String basicUserPhoto;
	
	
	public BasicUser(String basicUserUName, String basicUserPassword, String basicUserDni, String basicUserName,
			String basicUserLastName) {
		super();
		this.basicUserUName = basicUserUName;
		this.basicUserPassword = basicUserPassword;
		this.basicUserDni = basicUserDni;
		this.basicUserName = basicUserName;
		this.basicUserLastName = basicUserLastName;
	}
	
	


	
	
}
