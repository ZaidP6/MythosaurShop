package com.salesianostriana.dam.pilaraguilartiendaonline04.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Theme {

	@Id @GeneratedValue(generator="theme_seq")
	@SequenceGenerator(name="theme_seq",sequenceName="theme_seq", allocationSize=1, initialValue = 1)
	
	private Long themeId;
	
	private String themeName;
	private String themeDescription;
	private String themePhoto;
	
	
					//PRODUCT
	
	@ManyToMany(mappedBy="themeList", fetch = FetchType.EAGER)
	@Builder.Default
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<Product> productList = new ArrayList<>();
	
}

