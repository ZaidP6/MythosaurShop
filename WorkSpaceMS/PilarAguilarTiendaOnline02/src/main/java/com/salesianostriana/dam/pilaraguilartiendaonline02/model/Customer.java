
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
	
	
	public Customer(String basicUserUName, String basicUserPassword, String basicUserDni, String basicUserName,
			String basicUserLastName) {
		super(basicUserUName, basicUserPassword, basicUserDni, basicUserName, basicUserLastName);
	}
	
	
	
	
	
}
