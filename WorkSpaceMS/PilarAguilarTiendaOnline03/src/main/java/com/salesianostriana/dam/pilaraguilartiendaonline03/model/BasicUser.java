package com.salesianostriana.dam.pilaraguilartiendaonline03.model;

import java.util.Collection;
import java.util.List;

import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@MappedSuperclass @AllArgsConstructor @SuperBuilder
public class BasicUser implements UserDetails{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long basicUserId;
	
	private String basicUserUName;
	private String basicUserName;
	private String basicUserLastName;
	private String basicUserPassword;
	private String basicUserPasswordCheck;
	private String basicUserDni;
	private String basicUserPhoto;



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String role = "ROLE_";
		if (this instanceof Admin){
			role += "ADMIN";
		}else if(this instanceof Customer){
			role += "USER";
		}
		return List.of(new SimpleGrantedAuthority(role));
	}

	 @Override
	public String getPassword() {
		return basicUserPassword;
	}

	@Override
	public String getUsername() {
		return basicUserUName;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
