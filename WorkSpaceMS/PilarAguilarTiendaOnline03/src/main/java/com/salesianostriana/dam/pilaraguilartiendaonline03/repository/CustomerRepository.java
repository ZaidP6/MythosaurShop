package com.salesianostriana.dam.pilaraguilartiendaonline03.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.salesianostriana.dam.pilaraguilartiendaonline03.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

	Optional<Customer> findFirstByBasicUserUName(String basicUserUName);
	
	Customer findByBasicUserUName(String basicUserUName);

	//List<Customer> findByUsernameContainingIgnoreCase(String basicUserName);
}
