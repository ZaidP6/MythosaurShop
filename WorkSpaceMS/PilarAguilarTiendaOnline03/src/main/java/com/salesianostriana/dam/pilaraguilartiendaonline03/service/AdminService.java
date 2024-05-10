package com.salesianostriana.dam.pilaraguilartiendaonline03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pilaraguilartiendaonline03.model.Admin;
import com.salesianostriana.dam.pilaraguilartiendaonline03.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	public void agregar (Admin a) {
		adminRepository.save(a);	
	}
	
	public Admin findById(long id) {
		return adminRepository.findById(id).orElse(null);
	}
	
	
	public void editar (Admin a) {
		adminRepository.save(a);		
	}
	
	public void deleteById (long id) {
		adminRepository.deleteById(id);
	}
	
	public void delete (Admin a) {
		adminRepository.delete(a);
	}
	
	public List<Admin> findAll() {
		return adminRepository.findAll();
	}
	
}
