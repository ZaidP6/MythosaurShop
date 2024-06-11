package com.salesianostriana.dam.pilaraguilartiendaonline04.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.pilaraguilartiendaonline04.model.Customer;
import com.salesianostriana.dam.pilaraguilartiendaonline04.model.OrderLine;
import com.salesianostriana.dam.pilaraguilartiendaonline04.model.OrderPedido;
import com.salesianostriana.dam.pilaraguilartiendaonline04.model.Product;
import com.salesianostriana.dam.pilaraguilartiendaonline04.service.CartService;

//import java.util.List;

//import com.salesianostriana.dam.pilaraguilartiendaonline03.service.OrderService;
//import com.salesianostriana.dam.pilaraguilartiendaonline03.model.OrderLine;
//import com.salesianostriana.dam.pilaraguilartiendaonline03.model.OrderPedido;

import com.salesianostriana.dam.pilaraguilartiendaonline04.service.OrderService;
import com.salesianostriana.dam.pilaraguilartiendaonline04.service.ProductService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private ProductService productService;

	/*
	 * @Autowired private OrderService orderService;
	 */

	@GetMapping("/user/comprar/{id}")
	public String addOrderLine(@RequestParam Long orderId, @RequestParam Long productId, @RequestParam int quantity,
			Model model) {
		orderService.findAll();
		// orderService.addOrderLine(orderId, productId, quantity);
		return "redirect:/user/carrito";

	}

	

	@PostMapping("/user/comprar/{productId}")
	public String comprarUnProducto(@AuthenticationPrincipal Customer cliente, 
	        @PathVariable("productId") Long productId, Model model) {
	    Optional<Product> optionalProduct = productService.findById(productId);
	    if (optionalProduct.isPresent()) {
	        Product productoNuevo = optionalProduct.get();
	        cartService.addProductToCart(cliente, productoNuevo, 1);
	        return "redirect:/user/carrito";
	    }
	    return "redirect:/user/";
	}

			
	
	@GetMapping("/delete/{orderLineId}")
	public void deleteOrderLine(@PathVariable Long orderLineId) {
		// orderService.deleteOrderLine(orderLineId);
	}
	
	@GetMapping("/user/carrito")
	public String showCart(@AuthenticationPrincipal Customer customer, Model model) {
		OrderPedido cart = cartService.getCart(customer);
		if(!cart.getOrderLines().isEmpty()) {
			model.addAttribute("orderLines", cart.getOrderLines());
			return "customer/carrito";
		}else
			return "customer/carritoVacio";
	}
	
}
					// POSIBLE CÓDIGO PARA EL CARRITO ABAJO
	/*
	 * @GetMapping("/user/carrito") public String showOrderLines(Model model) {
	 * OrderPedido carrito = orderService.findByOpen(); if (carrito != null) {
	 * model.addAttribute("ventaCompleta", carrito); if (model.addAttribute("venta",
	 * carrito.getOrderLines()) == null) { return "redirect:/user/"; } return
	 * "customer/carrito"; } return "redirect:/user/"; }
	 * 
	 * @PostMapping("/user/carrito") public String viewCart(@AuthenticationPrincipal
	 * Customer cliente, @PathVariable("id") Long id, Model model) {
	 * model.addAttribute("lista", orderLineService.listarLineasVenta());
	 * orderLineService.listarLineasVenta(); return "customer/carrito"; }
	 */

