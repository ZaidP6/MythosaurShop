package com.salesianostriana.dam.pilaraguilartiendaonline03.security;

import com.salesianostriana.dam.pilaraguilartiendaonline03.model.Admin;
import com.salesianostriana.dam.pilaraguilartiendaonline03.model.Customer;
import com.salesianostriana.dam.pilaraguilartiendaonline03.repository.CustomerRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InitData {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {

        Customer customer = Customer.builder()
                .basicUserUName("user")
                //.password("1234")
                .basicUserPassword(passwordEncoder.encode("1234"))
                .build();

        Admin admin = Admin.builder()
                .basicUserUName("admin")
                .basicUserPassword(passwordEncoder.encode("admin"))
                .build();



    }
}
