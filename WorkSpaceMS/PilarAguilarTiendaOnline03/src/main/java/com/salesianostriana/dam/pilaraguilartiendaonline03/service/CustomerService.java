package com.salesianostriana.dam.pilaraguilartiendaonline03.service;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pilaraguilartiendaonline03.model.Customer;
import com.salesianostriana.dam.pilaraguilartiendaonline03.repository.CustomerRepository;
import com.salesianostriana.dam.pilaraguilartiendaonline03.service.base.BaseServiceImpl;

@Service
public class CustomerService extends BaseServiceImpl<Customer, Long, CustomerRepository>{


}
