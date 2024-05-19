package com.salesianostriana.dam.pilaraguilartiendaonline03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.pilaraguilartiendaonline03.model.OrderLine;
import com.salesianostriana.dam.pilaraguilartiendaonline03.service.OrderLineService;





@Controller
public class OrderController {

 
	
 	@Autowired
    private OrderLineService orderLineService;

    @PostMapping("/addOL")
    public OrderLine addOrderLine(@RequestParam Long orderId, @RequestParam Long productId, @RequestParam int quantity) {
        return orderLineService.addOrderLine(orderId, productId, quantity);
    }
    
    @GetMapping("/delete/{orderLineId}")
    public void deleteOrderLine(@PathVariable Long orderLineId) {
        orderLineService.deleteOrderLine(orderLineId);
    }
	
    
    
 
	/*
	 * @GetMapping("/user/cart")
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
	
	@GetMapping("/addLineaVenta/{id}")
	public String addLineaVenta(@AuthenticationPrincipal Customer cliente, @PathVariable("id") Long id, Model model) {

		return "redirect:/venta";
	}
	 */
	
}
