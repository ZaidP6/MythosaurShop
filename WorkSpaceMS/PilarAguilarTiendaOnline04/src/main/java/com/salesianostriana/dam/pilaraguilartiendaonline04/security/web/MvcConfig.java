package com.salesianostriana.dam.pilaraguilartiendaonline04.security.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(@SuppressWarnings("null") ViewControllerRegistry registry) {
		registry.addViewController("/");
		registry.addViewController("/form/logIn");
	}
}
