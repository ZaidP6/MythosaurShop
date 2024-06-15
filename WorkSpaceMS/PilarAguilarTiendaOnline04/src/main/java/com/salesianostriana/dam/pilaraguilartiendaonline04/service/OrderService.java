package com.salesianostriana.dam.pilaraguilartiendaonline04.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.salesianostriana.dam.pilaraguilartiendaonline04.model.Customer;
import com.salesianostriana.dam.pilaraguilartiendaonline04.model.OrderPedido;
import com.salesianostriana.dam.pilaraguilartiendaonline04.repository.OrderRepository;
import com.salesianostriana.dam.pilaraguilartiendaonline04.service.base.BaseServiceImpl;

@Service
public class OrderService extends BaseServiceImpl<OrderPedido, Long, OrderRepository> {
		
	public Optional<OrderPedido> findById(Long id) {
		return this.repository.findById(id);
	}

	public List<OrderPedido> findAll() {
		return this.repository.findAll();
	}

	public Optional<OrderPedido> findByOrderOpen(Customer c) {

		return this.repository.findFirstByOrderOpenAndCustomer(c);
	}
	
	
	public OrderPedido actualizarVenta(OrderPedido order) {
		return this.repository.save(order);
	}
	
	public List<OrderPedido> listaPedidosRealizados(Customer c){
		return repository.findByOrderFinishAndCustomer(c);
	}
	
	
}
