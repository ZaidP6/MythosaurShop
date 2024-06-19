package com.salesianostriana.dam.pilaraguilartiendaonline04.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.salesianostriana.dam.pilaraguilartiendaonline04.model.Category;
import com.salesianostriana.dam.pilaraguilartiendaonline04.model.Customer;
import com.salesianostriana.dam.pilaraguilartiendaonline04.model.OrderPedido;
import com.salesianostriana.dam.pilaraguilartiendaonline04.model.Product;
import com.salesianostriana.dam.pilaraguilartiendaonline04.service.CategoryService;
import com.salesianostriana.dam.pilaraguilartiendaonline04.service.CustomerService;
import com.salesianostriana.dam.pilaraguilartiendaonline04.service.OrderService;
import com.salesianostriana.dam.pilaraguilartiendaonline04.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private OrderService orderService;

	public void llamarCategorias(Model model) {
		List<Category> categorias = categoryService.findAll();
		model.addAttribute("categorias", categorias);
	}

	@GetMapping("/") // Mostrar productos bbdd en indexAdmin
	public String index(Model model) {
		List<Product> productos = productService.findAll();
		model.addAttribute("products", productos);
		llamarCategorias(model);
		return "admin/indexAdmin";
	}

	@GetMapping("/cliente/list")
	public String listarClientes(Model model) {
		model.addAttribute("customers", customerService.findAll());
		llamarCategorias(model);
		return "admin/gestionClientes";
	}

	@GetMapping("/cliente/nuevo")
	public String nuevoCliente(Model model) {
		model.addAttribute("customer", new Customer());
		return "admin/nuevoCliente";
	}

	@PostMapping("/cliente/nuevo/submit")
	public String nuevoClienteOk(@ModelAttribute("customer") Customer c) {
		customerService.save(c);
		return "redirect:/admin/cliente/list";
	}

	@GetMapping("/cliente/editar/{id}")
	public String mostrarFormCliente(@PathVariable("id") long id, Model model) {
		Customer customer = customerService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Cliente con Id:" + id + " no válido"));
		if (customer != null) {
			model.addAttribute("customer", customer);
			return "admin/nuevoCliente";
		} else {
			return "redirect:/admin/cliente/list";
		}
	}

	@PostMapping("/cliente/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("customer") Customer c) {
		customerService.save(c);
		return "redirect:/admin/cliente/list";
	}

	// BORRAR CLIENTE POR ID

	@PostMapping("/cliente/borrar/{userId}")
	public String borrarCliente(@PathVariable("userId") Long userId, RedirectAttributes redirectAttributes) {
		if(customerService.countOrdersPerCustomer(userId) == 0) {
			customerService.deleteById(userId);
			redirectAttributes.addFlashAttribute("mensaje", "Categoría borrada satisfactoriamente");
	        redirectAttributes.addFlashAttribute("mensajeColor", "success");
			return "redirect:/admin/cliente/list";
		}else
			return "redirect:/admin/cliente/list?error";
		
		
	}

	@GetMapping("/orders")
	public String listarPedidosAdmin(Model model) {
		categoryService.llamarCategorias(model);
		List<OrderPedido> totalOrders = orderService.findAll();
		List<OrderPedido> orders = totalOrders;
		orders = orderService.listaPedidosAdmin();
		model.addAttribute("orders", orders);
		return "admin/listaPedidosAdmin";
	}

	@GetMapping("/orders/{orderId}")
	public String verDetallesPedidosAdmin(@PathVariable Long orderId, Model model) {
		OrderPedido order = orderService.findById(orderId).get();
		model.addAttribute("orderAdmin", order);
		categoryService.llamarCategorias(model);
		return "admin/detallePedidoAdmin";
	}
	
	 @GetMapping("/dashboard")
	    public String dashboard(Model model) {
	        Long totalOrders = orderService.getFinishedOrderCount();
	        model.addAttribute("totalOrders", totalOrders);
	        
	        Product popularProduct = productService.getMostPopularProduct();
	        model.addAttribute("popularP", popularProduct);
	        
	        double total = orderService.getTotalAmountToOrder();
	        model.addAttribute("total", total);
	        
	        double avgProductsPerOrder = orderService.getAVGProductsPerOrder();
	        model.addAttribute("AVGProducts", avgProductsPerOrder);

	        double avgAmountPerOrder = orderService.getAVGPricePerOrder();
	        model.addAttribute("AVGAmount", avgAmountPerOrder);


	        return "admin/dashboard";
	    }

}