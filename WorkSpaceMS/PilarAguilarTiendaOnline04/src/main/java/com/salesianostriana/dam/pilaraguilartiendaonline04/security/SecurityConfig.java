package com.salesianostriana.dam.pilaraguilartiendaonline04.security;

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
public class SecurityConfig {

	private final UserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;

	@Bean
	AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {

		AuthenticationManagerBuilder authBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);

		return authBuilder.authenticationProvider(daoAuthenticationProvider()).build();

	}

	@Bean
	DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder);
		return provider;
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests((authz) -> authz
				.requestMatchers("/css/**", "/js/**", "/webjars/**", "/images/**", "/h2-console/**", "/form/logIn/**",
						"form/signInSimple/**", "/quienesSomos", "/trabajaConNosotros", "/contenidoContacto",
						"/politicaPrivacidad", "/cookies", "/", "/{categoryId}")
				.permitAll().requestMatchers("/admin/**").hasRole("ADMIN").requestMatchers("/user/**").hasRole("USER")
				.anyRequest().authenticated())
				.formLogin((loginz) -> loginz.loginPage("/form/logIn")
						.successHandler((request, response, authentication) -> {

							// Esto no le gusta a Luismi asi, meter en una clase

							Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
							if (authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
								response.sendRedirect("/admin/");
							} else if (authorities.contains(new SimpleGrantedAuthority("ROLE_USER"))) {
								response.sendRedirect("/user/");
							} else {
								response.sendRedirect("/");
							}
						}).permitAll())
				.logout((logoutz) -> logoutz.logoutUrl("/logout").logoutSuccessUrl("/").permitAll());

		http.csrf(csrfz -> csrfz.disable());
		http.headers(headersz -> headersz.frameOptions(frameOptionsz -> frameOptionsz.disable()));

		return http.build();
	}

}