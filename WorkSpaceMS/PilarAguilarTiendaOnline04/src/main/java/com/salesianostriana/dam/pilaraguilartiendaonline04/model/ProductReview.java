package com.salesianostriana.dam.pilaraguilartiendaonline04.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity @Builder 
public class ProductReview {
	
	@Id @GeneratedValue
	private Long productReviewId;
	
	private String productReviewTitle;
	private String productReviewBody;
	
					 //PRODUCT
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_productReview_product"))	
	private Product product;
	
	
	/*
	* MÉTODOS HELPER PARA LA ASOCIACIÓN CON PRODUCT
	*/
	
	public void addToProduct(Product product) {
		this.product = product;
		product.getProductReviewList().add(this);
	}
	
	public void removeFromProduct(Product product) {
		product.getProductReviewList().remove(this);
		this.product = null;
	}
}
