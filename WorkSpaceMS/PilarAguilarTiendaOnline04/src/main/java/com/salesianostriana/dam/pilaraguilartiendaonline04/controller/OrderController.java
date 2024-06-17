package com.salesianostriana.dam.pilaraguilartiendaonline04.controller;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.salesianostriana.dam.pilaraguilartiendaonline04.model.Customer;
import com.salesianostriana.dam.pilaraguilartiendaonline04.model.OrderLine;
import com.salesianostriana.dam.pilaraguilartiendaonline04.model.OrderPedido;
import com.salesianostriana.dam.pilaraguilartiendaonline04.model.Product;
import com.salesianostriana.dam.pilaraguilartiendaonline04.service.CartService;
import com.salesianostriana.dam.pilaraguilartiendaonline04.service.CategoryService;

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
	private CategoryService categoryService;


	/*
	 * @Autowired private OrderService orderService;
	 */

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
		categoryService.llamarCategorias(model);
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

	
	@GetMapping("/user/order/finished/{orderId}")
	public String finalizarCompra(@AuthenticationPrincipal Customer customer, @PathVariable Long orderId) {
		
		if(customer != null) {
			OrderPedido cart = cartService.getCart(customer);
			Optional<OrderPedido> optionalOrder = cartService.findById(orderId);
			if(optionalOrder.isPresent()) {
				cartService.finalizarCompra(customer, cart);
				return "redirect:/user/orders"; 
			}else
				return "redirect:/user/carrito";
		}
		return "redirect:/form/logIn";
	}
	
	
	@GetMapping({"/user/orders"})
	public String listarPedidos(@AuthenticationPrincipal Customer customer,Model model) {
		
		model.addAttribute("listaPedidos", orderService.listaPedidosRealizados(customer));
		categoryService.llamarCategorias(model);
		return "customer/listaPedidosUser";
		
	}
	
	@GetMapping("/user/order/{orderId}")
	public String verDetallesPedido(@AuthenticationPrincipal Customer customer,@PathVariable Long orderId, Model model) {
		OrderPedido order = orderService.findById(orderId).get();
		model.addAttribute("order", order);
	    categoryService.llamarCategorias(model);
	    return "customer/detallePedido";
	}
	


}
