package com.salesianostriana.dam.pilaraguilartiendaonline04.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pilaraguilartiendaonline04.model.Customer;
import com.salesianostriana.dam.pilaraguilartiendaonline04.model.OrderLine;
import com.salesianostriana.dam.pilaraguilartiendaonline04.model.OrderPedido;
import com.salesianostriana.dam.pilaraguilartiendaonline04.model.Product;
import com.salesianostriana.dam.pilaraguilartiendaonline04.repository.OrderRepository;
import com.salesianostriana.dam.pilaraguilartiendaonline04.repository.ProductRepository;

@Service
public class CartService{

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
					
					//NUEVO CARRITO
	
	public OrderPedido newCart(Customer c) {
		OrderPedido carrito = OrderPedido.builder().customer(c).orderFinished(false).build();
		orderRepository.save(carrito);
		return carrito;
	}
	
					//AÑADIR LINEA A LA VENTA EXISTENTE
	
	public void addOrderLine(Long orderId, Long productId, int quantity) {
        Optional<OrderPedido> optionalOrder = orderService.findById(orderId);
        Optional<Product> optionalProduct = productRepository.findById(productId);

        if (optionalOrder.isPresent() && optionalProduct.isPresent()) {
            OrderPedido order = optionalOrder.get(); //orElseThrow???
            Product product = optionalProduct.get();

            OrderLine orderLine = OrderLine.builder()
                    .orderPedido(order)
                    .product(product)
                    .orderLineQuantity(quantity)
                    .orderLinePrice(product.getProductPvP() * quantity)
                    .build();

            order.addOrderLine(orderLine);
            orderService.actualizarVenta(order);
        }
    }
	
					//OBTENER CARRITO ABIERTO
	
	public OrderPedido getCart(Customer c) {
		
		return orderService.findByOpenOrder(c).get(); //.orElseGet(() -> newCart());
		
	}
	
					//AÑADIR PRODUCTO AL CARRITO EXISTENTE O CREA SI NO HAY
	
	public void addToCart(Customer c, Product p, int cantidad) {
		
		Optional<OrderPedido> optionalCart = orderService.findByOpenOrder(c);
		OrderPedido cart = optionalCart.orElseGet(() -> newCart(c));
		addOrderLine(cart.getOrderId(), p.getProductId(), cantidad);
	}
	
}
