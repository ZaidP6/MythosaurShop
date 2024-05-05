
package com.salesianostriana.dam.pilaraguilartiendaonline01.model;

import java.sql.Date;
import jakarta.persistence.Entity;
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
	
}
