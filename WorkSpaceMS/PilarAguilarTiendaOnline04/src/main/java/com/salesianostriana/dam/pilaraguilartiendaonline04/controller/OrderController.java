package com.salesianostriana.dam.pilaraguilartiendaonline04.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.pilaraguilartiendaonline04.model.Customer;
import com.salesianostriana.dam.pilaraguilartiendaonline04.model.OrderLine;
import com.salesianostriana.dam.pilaraguilartiendaonline04.model.OrderPedido;

//import java.util.List;

//import com.salesianostriana.dam.pilaraguilartiendaonline03.service.OrderService;
//import com.salesianostriana.dam.pilaraguilartiendaonline03.model.OrderLine;
//import com.salesianostriana.dam.pilaraguilartiendaonline03.model.OrderPedido;

import com.salesianostriana.dam.pilaraguilartiendaonline04.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	/*
	 * @Autowired private OrderService orderService;
	 */

	@GetMapping("/delete/{orderLineId}")
	public void deleteOrderLine(@PathVariable Long orderLineId) {
		// orderService.deleteOrderLine(orderLineId);
	}

	@GetMapping("/user/comprar/{id}")
	public String addOrderLine(@RequestParam Long orderId, @RequestParam Long productId, @RequestParam int quantity,
			Model model) {
		orderService.findAll();
		// orderService.addOrderLine(orderId, productId, quantity);
		return "redirect:/user/carrito";

	}

	// POSIBLE CÓDIGO PARA EL CARRITO ABAJO

	@GetMapping("/user/cart/{id}")
	public String detalleVenta(@AuthenticationPrincipal Customer cliente, @PathVariable("id") long id, Model model) {
		if (orderService.findById(id).isPresent()) {
			List<OrderLine> LineaVentaEncontrada = orderService.findById(id).get().getOrderLines();
			model.addAttribute("venta", LineaVentaEncontrada);
			model.addAttribute("cliente", cliente);
			return "customer/carrito";
		} else
			return "redirect:/user/cart";
	}

	@GetMapping("/user/carrito")
	public String showOrderLines(Model model) {
		OrderPedido carrito = orderService.findByOpen();
		if (carrito != null) {
			model.addAttribute("ventaCompleta", carrito);
			if (model.addAttribute("venta", carrito.getOrderLines()) == null) {
				return "redirect:/user/";
			}
			return "customer/carrito";
		}
		return "redirect:/user/";
	}

	@PostMapping("/user/carrito")
	public String viewCart(@AuthenticationPrincipal Customer cliente, @PathVariable("id") Long id, Model model) {
		model.addAttribute("lista", orderLineService.listarLineasVenta());
		orderLineService.listarLineasVenta();
		return "customer/carrito";
	}

}
