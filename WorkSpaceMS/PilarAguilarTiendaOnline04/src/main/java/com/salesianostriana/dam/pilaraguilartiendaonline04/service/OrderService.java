package com.salesianostriana.dam.pilaraguilartiendaonline04.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pilaraguilartiendaonline04.model.Customer;
import com.salesianostriana.dam.pilaraguilartiendaonline04.model.OrderLine;
import com.salesianostriana.dam.pilaraguilartiendaonline04.model.OrderPedido;
import com.salesianostriana.dam.pilaraguilartiendaonline04.model.Product;
import com.salesianostriana.dam.pilaraguilartiendaonline04.repository.OrderRepository;
import com.salesianostriana.dam.pilaraguilartiendaonline04.service.base.BaseServiceImpl;

@Service
public class OrderService extends BaseServiceImpl<OrderPedido, Long, OrderRepository> {

	@Autowired
	private ProductService productService;

	private Map<Product, Integer> productoKey = new HashMap<>();

	public void comprobarCarrito(Customer cliente) {
		if (productoKey.isEmpty()) {
			// No hay productos en el carrito, no se realiza ninguna acción
			return;
		} else {

			// Crear una nueva venta
			OrderPedido venta = new OrderPedido();
			for (Product p : productoKey.keySet()) {
				int v = productoKey.get(p);

				// Agregar una línea de venta a la venta actual
				venta.addOrderLine(OrderLine.builder().product(p).orderLineQuantity(v).orderLinePrice(p.getProductPvP())
						.orderLinePrice(p.getProductPvP() * v).build());

				// Restar el stock del producto
				productService.restarStock(p.getProductId(), v);

			}
			// Establecer el cliente de la venta
			venta.setCustomer(cliente);

			// Calcular el total de la venta

			// Establecer la fecha y guardar la venta
			venta.setOrderDate(LocalDateTime.now());
			save(venta);

			// Limpiar el carrito
			productoKey.clear();
		}
	}

}
