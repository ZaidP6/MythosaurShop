package com.salesianostriana.dam.pilaraguilartiendaonline03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.pilaraguilartiendaonline03.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
