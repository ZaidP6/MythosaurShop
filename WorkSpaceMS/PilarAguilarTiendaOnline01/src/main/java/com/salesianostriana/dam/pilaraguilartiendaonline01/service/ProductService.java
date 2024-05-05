package com.salesianostriana.dam.pilaraguilartiendaonline01.service;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pilaraguilartiendaonline01.model.Product;
import com.salesianostriana.dam.pilaraguilartiendaonline01.repository.ProductRepository;
import com.salesianostriana.dam.pilaraguilartiendaonline01.service.base.BaseServiceImpl;

@Service
public class ProductService 
    extends BaseServiceImpl<Product, Long, ProductRepository>{

}
