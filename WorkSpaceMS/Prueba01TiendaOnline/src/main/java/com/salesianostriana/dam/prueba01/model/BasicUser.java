package com.salesianostriana.dam.prueba01.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class BasicUser {
	
	@Id @GeneratedValue
	private int basicUserId;
	
	private String basicUserName;
	private String basicUserPassword;
	private String basicUserPhoto;

}
