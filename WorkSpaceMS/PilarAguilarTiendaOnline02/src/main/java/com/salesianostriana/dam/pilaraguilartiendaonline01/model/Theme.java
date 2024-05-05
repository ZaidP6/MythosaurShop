package com.salesianostriana.dam.pilaraguilartiendaonline01.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

public class Theme {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long themeId;
	
	private String themeName;
	private String themeDescription;
	private String themePhoto;
	
}

