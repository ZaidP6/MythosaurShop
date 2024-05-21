package com.salesianostriana.dam.pilaraguilartiendaonline04.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.pilaraguilartiendaonline04.model.OrderLine;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Long>{

}
