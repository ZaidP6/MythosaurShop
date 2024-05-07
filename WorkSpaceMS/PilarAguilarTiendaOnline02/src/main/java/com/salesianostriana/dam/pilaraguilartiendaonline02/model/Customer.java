
package com.salesianostriana.dam.pilaraguilartiendaonline02.model;

import java.sql.Date;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor @Entity @Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true) @AllArgsConstructor
public class Customer extends BasicUser{


	private String customerMail;
	private Date customerBirth;
	private Date customerLastSession;
	private String customerPhone;
	private String customerAddress;
	
	public Customer(String basicUserName, String basicUserPassword, String basicUserDni, String basicUserPhoto) {
		super(basicUserName, basicUserPassword, basicUserDni, basicUserPhoto);
		// TODO Auto-generated constructor stub
	}
	
}
