package com.salesianostriana.dam.pilaraguilartiendaonline03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pilaraguilartiendaonline03.model.Customer;
import com.salesianostriana.dam.pilaraguilartiendaonline03.repository.CustomerRepository;
import com.salesianostriana.dam.pilaraguilartiendaonline03.service.base.BaseServiceImpl;

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

}
