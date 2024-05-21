package com.salesianostriana.dam.pilaraguilartiendaonline04.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pilaraguilartiendaonline04.model.Customer;
import com.salesianostriana.dam.pilaraguilartiendaonline04.repository.CustomerRepository;
import com.salesianostriana.dam.pilaraguilartiendaonline04.service.base.BaseServiceImpl;

@Service
public class CustomerService extends BaseServiceImpl<Customer, Long, CustomerRepository> {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer findByBasicUserUName(String basicUserUName) {
		return customerRepository.findByBasicUserUName(basicUserUName);
	}

	@Override
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	// método para actualizar la fecha y hora del último inicio de sesión
	public void updateLastLogin(String basicUserUName) {
		Customer customer = customerRepository.findByBasicUserUName(basicUserUName);
		if (customer != null) {
			customer.setCustomerLastSession(LocalDateTime.now());
			customerRepository.save(customer);
		}
	}

}
