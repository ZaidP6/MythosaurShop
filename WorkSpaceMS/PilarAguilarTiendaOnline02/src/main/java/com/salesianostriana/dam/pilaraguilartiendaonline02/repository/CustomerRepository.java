package com.salesianostriana.dam.pilaraguilartiendaonline02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.pilaraguilartiendaonline02.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}