package com.salesianostriana.dam.pilaraguilartiendaonline04.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.pilaraguilartiendaonline04.model.Admin;

import java.util.Optional;


public interface AdminRepository extends JpaRepository<Admin, Long>{

    Optional<Admin> findFirstByBasicUserUName(String basicUserUName);
}
