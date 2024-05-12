package com.salesianostriana.dam.pilaraguilartiendaonline03.service;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pilaraguilartiendaonline03.model.Product;
import com.salesianostriana.dam.pilaraguilartiendaonline03.repository.ProductRepository;
import com.salesianostriana.dam.pilaraguilartiendaonline03.service.base.BaseServiceImpl;



@Service
public class ProductService 
    extends BaseServiceImpl<Product, Long, ProductRepository>{

}
