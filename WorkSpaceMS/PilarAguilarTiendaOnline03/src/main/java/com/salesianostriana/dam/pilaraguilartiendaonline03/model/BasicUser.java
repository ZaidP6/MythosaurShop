package com.salesianostriana.dam.pilaraguilartiendaonline03.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@MappedSuperclass @AllArgsConstructor
public class BasicUser implements UserDetails{
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long basicUserId;
	
	private String basicUserUName;
	private String basicUserName;
	private String basicUserLastName;
	private String basicUserPassword;
	private String basicUserPasswordCheck;
	private String basicUserDni;
	private String basicUserPhoto;
	
	
	public BasicUser(String basicUserUName, String basicUserName, String basicUserLastName, String basicUserPassword,
			String basicUserDni, String basicUserPhoto) {
		super();
		this.basicUserUName = basicUserUName;
		this.basicUserName = basicUserName;
		this.basicUserLastName = basicUserLastName;
		this.basicUserPassword = basicUserPassword;
		this.basicUserDni = basicUserDni;
		this.basicUserPhoto = basicUserPhoto;
	}

	

	public BasicUser(String basicUserUName, String basicUserPassword) {
		super();
		this.basicUserUName = basicUserUName;
		this.basicUserPassword = basicUserPassword;
	}



	public BasicUser(String basicUserUName, String basicUserName, String basicUserLastName, String basicUserPassword,
			String basicUserPasswordCheck) {
		super();
		this.basicUserUName = basicUserUName;
		this.basicUserName = basicUserName;
		this.basicUserLastName = basicUserLastName;
		this.basicUserPassword = basicUserPassword;
		this.basicUserPasswordCheck = basicUserPasswordCheck;
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}


	
	
	
	
	


	
	
}
