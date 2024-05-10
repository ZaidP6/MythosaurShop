package com.salesianostriana.dam.pilaraguilartiendaonline03.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.pilaraguilartiendaonline03.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	Optional<Customer> findFirstByUsername(String customerId);

	List<Customer> findByUsernameContainingIgnoreCase(String customerName);
}
