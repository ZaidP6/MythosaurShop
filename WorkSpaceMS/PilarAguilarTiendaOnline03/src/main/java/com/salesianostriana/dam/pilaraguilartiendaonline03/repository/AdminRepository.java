package com.salesianostriana.dam.pilaraguilartiendaonline03.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.pilaraguilartiendaonline03.model.Admin;
import com.salesianostriana.dam.pilaraguilartiendaonline03.model.Customer;

public interface AdminRepository extends JpaRepository<Admin, Long>{

	Optional<Customer> findFirstByUsername(String customerId);

	List<Customer> findByUsernameContainingIgnoreCase(String customerName);
}
