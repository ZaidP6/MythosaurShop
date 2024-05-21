package com.salesianostriana.dam.pilaraguilartiendaonline04.security;

import com.salesianostriana.dam.pilaraguilartiendaonline04.model.Admin;
import com.salesianostriana.dam.pilaraguilartiendaonline04.model.Customer;
import com.salesianostriana.dam.pilaraguilartiendaonline04.repository.AdminRepository;
import com.salesianostriana.dam.pilaraguilartiendaonline04.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private final CustomerRepository customerRepository;
	
	@Autowired
	private final AdminRepository adminRepository;

	public UserDetailsServiceImpl(CustomerRepository customerRepository, AdminRepository adminRepository) {
		this.customerRepository = customerRepository;
		this.adminRepository = adminRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String basicUserUName) throws UsernameNotFoundException {

		Customer customer = customerRepository.findFirstByBasicUserUName(basicUserUName).orElse(null);

		if (customer != null) {
			return customer;
		}
		Admin admin = adminRepository.findFirstByBasicUserUName(basicUserUName)
				.orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

		return admin;
	}
}
