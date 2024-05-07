package com.salesianostriana.dam.pilaraguilartiendaonline02.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor @Entity @Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Admin extends BasicUser implements UserDetails {
	
	public Admin(String basicUserUName, String basicUserPassword, String basicUserDni, String basicUserName,
			String basicUserLastName) {
		super(basicUserUName, basicUserPassword, basicUserDni, basicUserName, basicUserLastName);
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
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String role = "ROLE_";
		role = "ADMIN";
		return List.of(new SimpleGrantedAuthority(role));
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
