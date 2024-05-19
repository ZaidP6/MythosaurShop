package com.salesianostriana.dam.pilaraguilartiendaonline03.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.salesianostriana.dam.pilaraguilartiendaonline03.model.OrderLine;
import com.salesianostriana.dam.pilaraguilartiendaonline03.model.OrderPedido;
import com.salesianostriana.dam.pilaraguilartiendaonline03.repository.OrderRepository;
import com.salesianostriana.dam.pilaraguilartiendaonline03.service.base.BaseServiceImpl;

public class OrderService extends BaseServiceImpl<OrderPedido, Long, OrderRepository>{

	
	@Autowired
	private OrderRepository orderRepository;
	
	//METODO PARA AÑADIR UNA LINEA DE VENTA
	public void addOrderLine(OrderPedido venta, OrderLine orderLine) {
		if(venta.getOrderLine().contains(orderLine)) {
			orderLine.setOrderLineQuantity(orderLine.getOrderLineQuantity()+1);
		}else {
			venta.addOrderLine(orderLine);
		}
	}
	
	
}
