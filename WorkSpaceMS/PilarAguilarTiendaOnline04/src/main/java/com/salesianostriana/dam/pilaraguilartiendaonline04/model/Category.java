
package com.salesianostriana.dam.pilaraguilartiendaonline04.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Category {

	@Id
	@GeneratedValue(generator="category_seq")
	@SequenceGenerator(name="category_seq",sequenceName="category_seq", allocationSize=1, initialValue = 1)
	private Long categoryId;
	private String categoryName;
	private String categoryDescription;

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
	@Builder.Default
	private List<Product> products = new ArrayList<>();

}
