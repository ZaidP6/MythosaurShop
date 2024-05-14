package com.salesianostriana.dam.pilaraguilartiendaonline03.security;

import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig{

	private final UserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;
	
	@Bean
	public AuthenticationManager 
	authenticationManager(HttpSecurity http) throws Exception {

	AuthenticationManagerBuilder authBuilder =
		http.getSharedObject(AuthenticationManagerBuilder.class);

	return authBuilder
	.authenticationProvider(daoAuthenticationProvider())
	.build();


}
	
	@Bean 
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder);
		return provider;
	}

	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{

		http.authorizeHttpRequests((authz) -> authz
	        .requestMatchers("/css/**","/js/**","/webjars/**", "/h2-console/**", "/form/logIn/**", "form/signInSimple/**", 
	        		"/quienesSomos/", "/trabaja", "/contenidoContacto", "/").permitAll()
						.requestMatchers("/admin/**").hasRole("ADMIN")
						.requestMatchers("/customer/**").hasRole("USER")
						.anyRequest().authenticated())
				.formLogin((loginz) -> loginz
						.loginPage("/form/logIn")
						.successHandler((request, response, authentication) -> {
							Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
							if (authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
								response.sendRedirect("/admin");
							}
							else if (authorities.contains(new SimpleGrantedAuthority("ROLE_USER"))) {
								response.sendRedirect("/customer/index");
							}
							else {
								response.sendRedirect("/");
							}
						})
						.permitAll())
				.logout((logoutz) -> logoutz
						.logoutUrl("/form/logOut")
						.logoutSuccessUrl("/login")
						.permitAll());
				/*
				.requestMatchers("/admin/**").hasRole("ADMIN")
	        .anyRequest().authenticated())
	        .formLogin((loginz) -> loginz
	        		.loginPage("/form/logIn")
	        		.defaultSuccessUrl("/admin")
	        		.permitAll())
	        .logout((logoutz) -> logoutz
	        	.logoutUrl("/form/logOut")
	        	.logoutSuccessUrl("/").permitAll());

				 */


	    http.csrf(csrfz -> csrfz.disable());
    	http.headers(headersz -> headersz
    			.frameOptions(frameOptionsz -> frameOptionsz.disable()));


	    return http.build();
	}


}