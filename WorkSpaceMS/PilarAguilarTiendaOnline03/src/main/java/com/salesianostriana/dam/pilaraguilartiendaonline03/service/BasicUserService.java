package com.salesianostriana.dam.pilaraguilartiendaonline03.service;

import org.springframework.beans.factory.annotation.Autowired;

//import com.salesianostriana.dam.pilaraguilartiendaonline03.model.BasicUser;
import com.salesianostriana.dam.pilaraguilartiendaonline03.repository.BasicUserRepository;
//import com.salesianostriana.dam.pilaraguilartiendaonline03.service.base.BaseServiceImpl;

public class BasicUserService{ //extends BaseServiceImpl<BasicUser, Long, BasicUserRepository>{

	@Autowired
	private BasicUserRepository basicUserRepository;
	
}
