
package com.salesianostriana.dam.pilaraguilartiendaonline03.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity @Data @NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true) @AllArgsConstructor
@Builder
public class Customer extends BasicUser{


	private String customerMail;
	private Date customerBirth;
	private Date customerLastSession;
	private String customerPhone;
	private String customerAddress;
	
	
	public Customer(String basicUserUName, String basicUserName, String basicUserLastName, String basicUserPassword,
			String basicUserDni, String basicUserPhoto, String customerMail, Date customerBirth,
			Date customerLastSession, String customerPhone, String customerAddress) {
		super(basicUserUName, basicUserName, basicUserLastName, basicUserPassword, basicUserDni, basicUserPhoto);
		this.customerMail = customerMail;
		this.customerBirth = customerBirth;
		this.customerLastSession = customerLastSession;
		this.customerPhone = customerPhone;
		this.customerAddress = customerAddress;
	}



	public Customer(String basicUserUName, String basicUserPassword) {
		super(basicUserUName, basicUserPassword);
	}



	public Customer(String basicUserUName, String basicUserName, String basicUserLastName, String basicUserPassword,
			String basicUserPasswordCheck) {
		super(basicUserUName, basicUserName, basicUserLastName, basicUserPassword, basicUserPasswordCheck);
	}

	
}
