package com.salesianostriana.dam.pilaraguilartiendaonline03.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class Product {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	
	private String productName;
	
	@Lob  //se usa para aligerar carga
	private String productDescription;
	private double productPvP;
	private int productStockQuantity;
	
	@Lob
	private String productImage;
	private String productImageAlternativeText;
	
	@DateTimeFormat(pattern = "dd-MM-YYYY")
	private LocalDate productDate;
	
	
	
					//CATEGORY
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_product_category"))	
	private Category category;
	
	
	/*
	 * MÉTODOS HELPER PARA LA ASOCIACIÓN CON CATEGORY
	 */
	
	public void addToCategory(Category category) {
		this.category = category;
		category.getProducts().add(this);
	}
	
	public void removeFromCategory(Category category) {
		category.getProducts().remove(this);
		this.category = null;	
	}
	
					//REVIEW
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy="product", fetch = FetchType.EAGER)
	@Builder.Default
	private List<ProductReview> productReviewList = new ArrayList<>();
	
	
					//THEME
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "asociacion",
			joinColumns = @JoinColumn(name="productId"),
			inverseJoinColumns = @JoinColumn(name="themeId")
	)
	@Builder.Default
	private List<Theme> themeList = new ArrayList<>();
	
	// MÉTODOS HELPER PARA LA ASOCIACIÓN CON THEME
	
	public void addAsignatura(Theme t) {
		this.themeList.add(t);
		t.getProductList().add(this);
	}
	
	public void removeAsignatura(Theme t) {
		t.getProductList().remove(this);
		this.themeList.remove(t);
	}
	
	
}
