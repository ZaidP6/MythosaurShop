package com.salesianostriana.dam.pilaraguilartiendaonline03.security;

import com.salesianostriana.dam.pilaraguilartiendaonline03.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final CustomerRepository customerRepository;

    @Autowired
    public UserDetailsServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String basicUserUName) throws UsernameNotFoundException {
        return customerRepository.findFirstByBasicUserUName(basicUserUName)
                .orElseThrow(() -> new UsernameNotFoundException("Error al buscar el usuario"));
    }
}