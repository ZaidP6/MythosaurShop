package com.salesianostriana.dam.pilaraguilartiendaonline03.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

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
	public SecurityFilterChain securityFilderChain(HttpSecurity http)throws Exception{
		
		http.authorizeHttpRequests((authz) -> authz
	        .requestMatchers("/css/**","/js/**","/webjars/**", "/h2-console/**").permitAll()
	        .requestMatchers("/**/admin/**").hasRole("ADMIN")
	        .anyRequest().authenticated())
	        .formLogin((loginz) -> loginz
	        		.loginPage("/form/logIn")
	        		.defaultSuccessUrl("/")
	        		.permitAll())
	        .logout((logoutz) -> logoutz
	        	.logoutUrl("/logOut")
	        	.logoutSuccessUrl("/").permitAll());
	    
	    
	    
	    http.csrf(csrfz -> csrfz.disable());
    	http.headers(headersz -> headersz
    			.frameOptions(frameOptionsz -> frameOptionsz.disable()));

	    
	    return http.build();
	}
	
	
}