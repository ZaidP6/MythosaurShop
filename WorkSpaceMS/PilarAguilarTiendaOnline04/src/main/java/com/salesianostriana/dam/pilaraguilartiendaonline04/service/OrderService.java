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
