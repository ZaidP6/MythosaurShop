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
	
	

	/*
	 * //listar las líneas del carrito public List<OrderLine> listarLineasVenta() {
	 * return Collections.unmodifiableList(olRepository.findAll()); }
	 */

	// método para añadir una línea al carrito y por tanto, actualizar dicha compra
	/*
	 * public OrderLine addOrderLine(Long orderId, Long productId, int quantity) {
	 * // Obtenemos venta por ID OrderPedido orderPedido =
	 * orderRepository.findById(orderId) .orElseThrow(() -> new
	 * IllegalArgumentException("Venta no encontrada"));
	 * 
	 * // Obtenemos producto por ID Product product =
	 * productRepository.findById(productId) .orElseThrow(() -> new
	 * IllegalArgumentException("Producto no encontrado"));
	 * 
	 * // Se crea nueva linea OrderLine orderLine = OrderLine.builder()
	 * .orderPedido(orderPedido) .product(product) .orderLineQuantity(quantity)
	 * .orderLinePrice(product.getProductPvP() * quantity) .build();
	 * 
	 * // se añade linea a venta orderPedido.addOrderLine(orderLine);
	 * 
	 * // se guarda orderRepository.save(orderLine);
	 * 
	 * // Actualiza y guarda la venta orderRepository.save(orderPedido);
	 * 
	 * return orderLine; }
	 */

	// método para borrar una linea del carrito
	/*
	 * public void deleteOrderLine(Long orderLineId) { OrderLine orderLine =
	 * olRepository.findById(orderLineId) .orElseThrow(() -> new
	 * IllegalArgumentException("Línea de venta no encontrada"));
	 * 
	 * OrderPedido orderPedido = orderLine.getOrderPedido();
	 * orderPedido.removeOrderLine(orderLine);
	 * 
	 * olRepository.delete(orderLine); orderRepository.save(orderPedido); }
	 */

	// Avtualizar cantidad de un producto

	/*
	 * public OrderLine actualizarOrderLine(Long orderLineId, Long productId, int
	 * quantity) { OrderLine orderLine;
	 * 
	 * if (orderLineId != null) { // Si existe el ID, actualizamos la línea de
	 * pedido orderLine = olRepository.findById(orderLineId) .orElseThrow(() -> new
	 * IllegalArgumentException("Línea de venta no encontrada"));
	 * 
	 * // Actualizamos la cantidad y el precio
	 * orderLine.setOrderLineQuantity(quantity);
	 * orderLine.setOrderLinePrice(orderLine.getProduct().getProductPvP() *
	 * quantity); } else { // Si no existe el ID, creamos una nueva línea de pedido
	 * vacía orderLine = new OrderLine(); }
	 * 
	 * return olRepository.save(orderLine); }
	 */

	// método para calcular el total completo
	/*
	 * public double calcularTotal() { //Nuestro map con producto y cantidad
	 * Map<Product, Integer> carrito = this.productoKey; double total = 0.0;
	 * 
	 * //otro map para albergar cada linea completa for (Map.Entry<Product, Integer>
	 * entry : carrito.entrySet()) { Product producto = entry.getKey(); int cantidad
	 * = entry.getValue(); total += producto.getProductPvP() * cantidad; } return
	 * total; }
	 */

	// Agregar producto al carrito
	/*
	 * public void agregarProducto(Product producto, int cantidad) {
	 * 
	 * if (productoKey.containsKey(producto)) { if
	 * (productoKey.containsKey(producto)) { if (productoKey.get(producto) > 1)
	 * productoKey.replace(producto, productoKey.get(producto) - 1); else if
	 * (productoKey.get(producto) == 1) { productoKey.remove(producto); } } }
	 * 
	 * }
	 */

	/*
	 * // Eliminar producto del carrito public void eliminarProducto(Product
	 * producto) { this.productoKey.remove(producto); }
	 * 
	 * // Obtener la cantidad de un producto específico public int
	 * obtenerCantidad(Product producto) { return
	 * this.productoKey.getOrDefault(producto, 0); }
	 * 
	 * // Ver todos los productos en el carrito public Map<Product, Integer>
	 * verProductosCarrito() { return Collections.unmodifiableMap(this.productoKey);
	 * }
	 */

}
