package com.salesianostriana.dam.pilaraguilartiendaonline04.controller;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.pilaraguilartiendaonline04.model.Customer;
import com.salesianostriana.dam.pilaraguilartiendaonline04.model.OrderLine;
import com.salesianostriana.dam.pilaraguilartiendaonline04.model.OrderPedido;
import com.salesianostriana.dam.pilaraguilartiendaonline04.model.Product;
import com.salesianostriana.dam.pilaraguilartiendaonline04.service.CartService;
import com.salesianostriana.dam.pilaraguilartiendaonline04.service.CustomerService;

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

	@Autowired
	private CustomerService customerService;

	/*
	 * @Autowired private OrderService orderService;
	 */

	@GetMapping("/user/comprar/{id}")
	public String addOrderLine(@RequestParam Long orderId, @RequestParam Long productId) {
		orderService.findAll();
		cartService.addOrderLine(orderId, productId, 1);
		return "redirect:/user/carrito";

	}

	@PostMapping("/user/comprar/{productId}")
	public String comprarUnProducto(@AuthenticationPrincipal Customer cliente,
			@PathVariable("productId") Long productId, int quantity, Model model) {
		Optional<Product> optionalProduct = productService.findById(productId);
		if (optionalProduct.isPresent()) {
			cartService.addProductToCart(cliente, productId, quantity);
			return "redirect:/user/carrito";
		}
		return "redirect:/user/";
	}

	@GetMapping("/user/carrito")
	public String showCart(@AuthenticationPrincipal Customer customer, Model model) {
		if (customer != null) {
			OrderPedido cart = cartService.getCart(customer);
			if (cart != null && cart.getOrderLines() != null && !cart.getOrderLines().isEmpty()) {
				Map<Product, OrderLine> mapOrderLines = new LinkedHashMap<>();
				for (OrderLine orderLine : cart.getOrderLines()) {
					mapOrderLines.put(orderLine.getProduct(), orderLine);
				}
				model.addAttribute("cart", cart);
				model.addAttribute("mapOrderLines", mapOrderLines);
				return "customer/carrito";
			} else {
				return "customer/carritoVacio";
			}
		}else {
			model.addAttribute("error", "No se podido encontrar el cliente autenticado.");
			return "redirect:/form/logIn";
		}
	}
	
	@GetMapping("/user/delete/cart/{productId}")
	public String deleteProductCart(@AuthenticationPrincipal Customer customer, @PathVariable Long productId) {
	    if (customer != null) {
	        OrderPedido cart = cartService.getCart(customer);
	        Optional<Product> optionalProduct = productService.findById(productId);
	        if (optionalProduct.isPresent()) {
	            Optional<OrderLine> optionalOrderLine = cart.getOrderLines().stream()
	                    .filter(ol -> ol.getProduct().getProductId().equals(productId))
	                    .findFirst();
	            if (optionalOrderLine.isPresent()) {
	                OrderLine orderLine = optionalOrderLine.get();
	                if (orderLine.getOrderLineQuantity() <= 1) {
	                	cart.getOrderLines().remove(orderLine);
	                    
	                } else 
	                    orderLine.setOrderLineQuantity(orderLine.getOrderLineQuantity() - 1);
	                	
	                cart.setOrderTotalAmount(cartService.calcularTotalPedido(cart));
	                cartService.save(cart);
	    	        orderService.actualizarVenta(cart); 
	            }
	            return "redirect:/user/carrito";
	        }
	        return "redirect:/user/carrito";
	    }
	    return "redirect:/form/logIn";
	}

	
	@PostMapping("/user/carrito/submit")
	public String volverAlIndex(@ModelAttribute("customer") Customer c) {
		// TODO: process POST request

		customerService.save(c);
		return "redirect:/admin/cliente/list";
	}

}
