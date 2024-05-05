package com.salesianostriana.dam.pilaraguilartiendaonline01.model;

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
	
	private String basicUserName;
	private String basicUserPassword;
	private String basicUserPhoto;
	
	
	public BasicUser(String basicUserName, String basicUserPassword, String basicUserPhoto) {
		super();
		this.basicUserName = basicUserName;
		this.basicUserPassword = basicUserPassword;
		this.basicUserPhoto = basicUserPhoto;
	}

	
	
}
