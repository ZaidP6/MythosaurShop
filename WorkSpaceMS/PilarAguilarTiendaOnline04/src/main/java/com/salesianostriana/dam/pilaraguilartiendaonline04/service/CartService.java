package com.salesianostriana.dam.pilaraguilartiendaonline04.service;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pilaraguilartiendaonline04.model.Customer;
import com.salesianostriana.dam.pilaraguilartiendaonline04.model.OrderPedido;
import com.salesianostriana.dam.pilaraguilartiendaonline04.model.Product;

@Service
public class CartService{

	private OrderService orderService;
	
	
	public OrderPedido newCart(Customer c) {
		OrderPedido carrito = OrderPedido.builder().customer(c).orderFinished(false).build();
		return carrito;
	}
	
	public OrderPedido getCart() {
		
		return null;
		
	}
	
	
	public void addToCart(Customer c, Product p, int cantidad) {
		
	}
	
	
	
}
