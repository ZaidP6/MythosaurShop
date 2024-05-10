package com.salesianostriana.dam.pilaraguilartiendaonline03.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pilaraguilartiendaonline03.model.Customer;
import com.salesianostriana.dam.pilaraguilartiendaonline03.repository.CustomerRepository;
import com.salesianostriana.dam.pilaraguilartiendaonline03.service.base.BaseServiceImpl;

@Service
public class CustomerService extends BaseServiceImpl<Customer, Long, CustomerRepository>{

	@Autowired
	private CustomerRepository customerRepository;
	
	public void agregar (Customer c) {
		customerRepository.save(c);	
	}
	
	public Customer findById(long id) {
		return customerRepository.findById(id).orElse(null);
	}
	
	
	public void editar (Customer c) {
		customerRepository.save(c);		
	}
	
	public void deleteById (long id) {
		customerRepository.deleteById(id);
	}
	
	public void delete (Customer c) {
		customerRepository.delete(c);
	}
	
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
	
	/*
	 * public List<Customer> showAllProducts() {
        return customerRepository.findAll();
    }
	 */
}
