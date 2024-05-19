package com.salesianostriana.dam.pilaraguilartiendaonline03.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pilaraguilartiendaonline03.model.OrderLine;
import com.salesianostriana.dam.pilaraguilartiendaonline03.model.OrderPedido;
import com.salesianostriana.dam.pilaraguilartiendaonline03.model.Product;
import com.salesianostriana.dam.pilaraguilartiendaonline03.repository.OrderLineRepository;
import com.salesianostriana.dam.pilaraguilartiendaonline03.repository.OrderRepository;
import com.salesianostriana.dam.pilaraguilartiendaonline03.repository.ProductRepository;

/*
 * import org.springframework.beans.factory.annotation.Autowired;

import com.salesianostriana.dam.pilaraguilartiendaonline03.model.Customer;
import com.salesianostriana.dam.pilaraguilartiendaonline03.model.OrderLine;
import com.salesianostriana.dam.pilaraguilartiendaonline03.model.OrderPedido;
import com.salesianostriana.dam.pilaraguilartiendaonline03.model.Product;
import com.salesianostriana.dam.pilaraguilartiendaonline03.repository.OrderLineRepository;
import com.salesianostriana.dam.pilaraguilartiendaonline03.repository.ProductRepository;

 */
@Service
public class OrderLineService {

	@Autowired
	private OrderLineRepository olRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductRepository productRepository;
	
	private Map<Product, Integer> productoKey = new HashMap<>();

	public List<OrderLine> getLineaVenta() {
		return Collections.unmodifiableList(olRepository.findAll());
	}

	public OrderLine addOrderLine(Long orderId, Long productId, int quantity) {
		// Obtenemos venta por ID
		OrderPedido orderPedido = orderRepository.findById(orderId)
				.orElseThrow(() -> new IllegalArgumentException("Order not found"));

		// Obtenemos producto por ID
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new IllegalArgumentException("Product not found"));

		// Se crea nueva linea
		OrderLine orderLine = OrderLine.builder()
				.orderPedido(orderPedido)
				.product(product)
				.orderLineQuantity(quantity)
				.orderLinePrice(product.getProductPvP() * quantity)
				.build();

		// se añade linea a venta
        orderPedido.addOrderLine(orderLine);

        // se guarda
        olRepository.save(orderLine);

        // Actualiza y guarda la venta
        orderRepository.save(orderPedido);

        return orderLine;
	}
	
	public void deleteOrderLine(Long orderLineId) {
        OrderLine orderLine = olRepository.findById(orderLineId)
                .orElseThrow(() -> new IllegalArgumentException("OrderLine not found"));

        OrderPedido orderPedido = orderLine.getOrderPedido();
        orderPedido.removeOrderLine(orderLine);

        olRepository.delete(orderLine);
        orderRepository.save(orderPedido);
    }
	
	//Avtualizar cantidad de un producto
	
		public OrderLine actualizarOrderLine(Long orderLineId, Long productId, int quantity) {
	        OrderLine orderLine;

	        if (orderLineId != null) {
	            // Si existe el ID, actualizamos la línea de pedido
	            orderLine = olRepository.findById(orderLineId)
	                    .orElseThrow(() -> new IllegalArgumentException("OrderLine not found"));

	            // Actualizamos la cantidad y el precio
	            orderLine.setOrderLineQuantity(quantity);
	            orderLine.setOrderLinePrice(orderLine.getProduct().getProductPvP() * quantity);
	        } else {
	            // Si no existe el ID, creamos una nueva línea de pedido
	            orderLine = new OrderLine();
	            // Aquí deberías establecer el producto y otros campos según tu lógica
	        }

	        return olRepository.save(orderLine);
	    }
		
		public double calcularTotal() {
			Map<Product, Integer> carrito = this.productoKey;
		    double total = 0;

		    for (Map.Entry<Product, Integer> entry : carrito.entrySet()) {
		        Product producto = entry.getKey();
		        int cantidad = entry.getValue();
		        total += producto.getProductPvP() * cantidad;
		    }

		    return total;	
		 }

		

		// Agregar producto al carrito
		public void agregarProducto(Product producto, int cantidad) {

			if (productoKey.containsKey(producto)) {
				if (productoKey.containsKey(producto)) {
					if (productoKey.get(producto) > 1)
						productoKey.replace(producto, productoKey.get(producto) - 1);
					else if (productoKey.get(producto) == 1) {
						productoKey.remove(producto);
					}
				}
			}

		}

		// Eliminar producto del carrito
		public void eliminarProducto(Product producto) {
			this.productoKey.remove(producto);
		}

		// Obtener la cantidad de un producto específico
		public int obtenerCantidad(Product producto) {
			return this.productoKey.getOrDefault(producto, 0);
		}

		// Ver todos los productos en el carrito
		public Map<Product, Integer> verProductosCarrito() {
			return Collections.unmodifiableMap(this.productoKey);
		}
		
		
}
