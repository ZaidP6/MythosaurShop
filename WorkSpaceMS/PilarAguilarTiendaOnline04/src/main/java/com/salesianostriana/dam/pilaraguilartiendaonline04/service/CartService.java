package com.salesianostriana.dam.pilaraguilartiendaonline04.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pilaraguilartiendaonline04.model.Customer;
import com.salesianostriana.dam.pilaraguilartiendaonline04.model.OrderLine;
import com.salesianostriana.dam.pilaraguilartiendaonline04.model.OrderPedido;
import com.salesianostriana.dam.pilaraguilartiendaonline04.model.Product;
import com.salesianostriana.dam.pilaraguilartiendaonline04.repository.OrderRepository;
import com.salesianostriana.dam.pilaraguilartiendaonline04.repository.ProductRepository;
import com.salesianostriana.dam.pilaraguilartiendaonline04.service.base.BaseServiceImpl;

@Service
public class CartService extends BaseServiceImpl<OrderPedido, Long, OrderRepository> {

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductRepository productRepository;

	// NUEVO CARRITO

	public OrderPedido newCart(Customer c) {
		OrderPedido carrito = OrderPedido.builder().customer(c).orderOpen(true).orderDate(LocalDateTime.now()).build();
		orderRepository.save(carrito);
		return carrito;
	}

	// AÑADIR PRODUCTO AL CARRITO EXISTENTE O CREA SI NO HAY

	public void addProductToCart(Customer c, Product p, int cantidad) {

		Optional<OrderPedido> optionalCart = orderService.findByOrderOpen(c);
		OrderPedido cart = optionalCart.orElseGet(() -> newCart(c));
		addOrderLine(cart.getOrderId(), p.getProductId(), cantidad);
	}

	// AÑADIR LINEA A LA VENTA EXISTENTE

	public void addOrderLine(Long orderId, Long productId, int quantity) {
		Optional<OrderPedido> optionalOrder = orderService.findById(orderId);
		Optional<Product> optionalProduct = productRepository.findById(productId);

		//Optional<OrderLine> optionalOrderLine = optionalOrder.get();
		
		if (optionalOrder.isPresent() && optionalProduct.isPresent()) {
			OrderPedido order = optionalOrder.get();
			Product product = optionalProduct.get();

			OrderLine orderLine = OrderLine.builder().orderPedido(order).product(product).orderLineQuantity(quantity)
					.orderLinePrice(product.getProductPvP() * quantity).build();

			order.addOrderLine(orderLine);
			orderService.actualizarVenta(order);
		}
	}

	// OBTENER CARRITO ABIERTO

	public OrderPedido getCart(Customer c) {
		
		 List <OrderPedido> ordersOpen = orderService.findByOrderOpen(c).get();

		return  ordersOpen.stream().findFirst().orElseGet(() -> newCart(c));

	}

	// COMPROBAR SI HAY LINEAS EN CARRITO

	public boolean comprobarSiHayProductos(Customer c) {
		List<Product> optionalProduct = productRepository.findAll();
		if (!optionalProduct.isEmpty()) {
			return true;
		}
		return false;
	}

}
