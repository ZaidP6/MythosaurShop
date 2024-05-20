package com.salesianostriana.dam.pilaraguilartiendaonline03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


import com.salesianostriana.dam.pilaraguilartiendaonline03.model.OrderLine;
import com.salesianostriana.dam.pilaraguilartiendaonline03.model.OrderPedido;
import com.salesianostriana.dam.pilaraguilartiendaonline03.service.OrderLineService;
import com.salesianostriana.dam.pilaraguilartiendaonline03.service.OrderService;

import ch.qos.logback.core.model.Model;





@Controller
public class OrderController {

 
	
 	@Autowired
    private OrderLineService orderLineService;

 	@Autowired
    private OrderService orderService;
    
    @GetMapping("/delete/{orderLineId}")
    public void deleteOrderLine(@PathVariable Long orderLineId) {
        orderLineService.deleteOrderLine(orderLineId);
    }
	

    @GetMapping("/user/comprar/{id}")
    public String addOrderLine(@RequestParam Long orderId, @RequestParam Long productId, @RequestParam int quantity, Model model) {
        List<OrderLine> lineasDeVenta = orderLineService.listarLineasVenta();
    	orderLineService.addOrderLine(orderId, productId, quantity);
        return "redirect:/user/carrito";
        
    }
    
   
    
    
 
	/*
	 * 
	
	@GetMapping("/user/cart/{id}")
	public String detalleVenta(@AuthenticationPrincipal Customer cliente, @PathVariable("id") long id, Model model) {
		if(orderService.findById(id).isPresent()) {
			List<OrderLine> LineaVentaEncontrada = orderService.findById(id).get().getOrderLines();
			model.addAttribute("venta", LineaVentaEncontrada);	
			model.addAttribute("cliente", cliente);
			return "customer/carrito";
		}else {
			return "redirect:/user/cart";
		}
	}
	
	 @GetMapping("/user/carrito")
	public String showOrderLines(Model model) {
		OrderPedido carrito = orderService.findByOpen();
		if(carrito!=null) {
			model.addAttribute("ventaCompleta", carrito);
			if(model.addAttribute("venta", carrito.getOrderLines())==null) {
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
	
	
	 */
	
}
