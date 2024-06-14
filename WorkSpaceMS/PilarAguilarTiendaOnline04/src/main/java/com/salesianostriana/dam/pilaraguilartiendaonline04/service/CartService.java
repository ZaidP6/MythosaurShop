package com.salesianostriana.dam.pilaraguilartiendaonline04.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
		OrderPedido carrito = OrderPedido.builder()
				.customer(c)
				.orderOpen(true)
				.orderDate(LocalDateTime.now())
				.orderLines(new ArrayList<>())
				.build();
		orderRepository.save(carrito);
		return carrito;
	}

	// AÑADIR PRODUCTO AL CARRITO EXISTENTE O CREA SI NO HAY

	public void addProductToCart(Customer c, Long productId, int quantity) {
		Optional<Product> optionalProduct = productRepository.findById(productId);
		
		if(!optionalProduct.isPresent()) {
			throw new IllegalArgumentException("Producto no encontrado");
		}
		
		Product product = optionalProduct.get();
		Optional<OrderPedido> optionalCart = orderService.findByOrderOpen(c);
		OrderPedido cart = optionalCart.orElseGet(() -> newCart(c));
		
		Optional<OrderLine> optionalOrderLine = cart.getOrderLines()
				.stream()
				.filter(line -> line.getProduct()
						.getProductId()
						.equals(productId))
						.findFirst();
		
		if(!optionalOrderLine.isPresent()) {
			addOrderLine(cart.getOrderId(), product.getProductId(), quantity);
		}else {
			OrderLine orderLine = optionalOrderLine.get();
			orderLine.setOrderLineQuantity(orderLine.getOrderLineQuantity()+quantity);
			cart.setOrderTotalAmount(calcularTotalPedido(cart));
	        orderService.actualizarVenta(cart);
		}
		
		
		
	}

	// AÑADIR LINEA A LA VENTA EXISTENTE

	public void addOrderLine(Long orderId, Long productId, int quantity) {
		Optional<OrderPedido> optionalOrder = orderService.findById(orderId);
		Optional<Product> optionalProduct = productRepository.findById(productId);
		
		if (optionalOrder.isPresent() && optionalProduct.isPresent()) {
			OrderPedido order = optionalOrder.get();
			Product product = optionalProduct.get();

			OrderLine orderLine = OrderLine.builder()
					.orderPedido(order)
					.product(product)
					.orderLineQuantity(quantity)
					.build();
			
			order.addOrderLine(orderLine);
			order.setOrderTotalAmount(calcularTotalPedido(order));
			orderService.actualizarVenta(order);
		}else
			throw new IllegalArgumentException("Pedido o producto no encontrado");
	}

	// OBTENER CARRITO ABIERTO

	public OrderPedido getCart(Customer c) {
		
		 Optional<OrderPedido> optionalOrderOpen = orderService.findByOrderOpen(c);

		 return optionalOrderOpen.orElseGet(() -> newCart(c));

	}
	
	//CALCULAR PRECIO TOTAL DEL PEDIDO EN EL CARRITO
	
	public double calcularTotalPedido(OrderPedido order) {
        return order.getOrderLines()
                .stream()
                .mapToDouble(OrderLine::obtenerPrecioOrderLine)
                .sum();
    }
	
	public void finalizarCompra(Customer c, OrderPedido order) {
		
		OrderPedido carrito = this.getCart(c);
		carrito.setOrderOpen(false);
		carrito.setOrderDate(LocalDateTime.now());
		carrito.getOrderTotalAmount();
		orderService.actualizarVenta(order);	
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
