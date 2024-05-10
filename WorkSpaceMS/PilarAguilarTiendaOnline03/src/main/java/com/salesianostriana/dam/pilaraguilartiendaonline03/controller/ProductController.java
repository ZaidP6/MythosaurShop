package com.salesianostriana.dam.pilaraguilartiendaonline03.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.pilaraguilartiendaonline03.model.OrderLine;
import com.salesianostriana.dam.pilaraguilartiendaonline03.model.Product;
import com.salesianostriana.dam.pilaraguilartiendaonline03.service.ProductService;



@Controller
public class ProductController {


	
	@Autowired
	private ProductService productService;
	
	private OrderLine orderLine;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	/**
	 * Método gestiona listado de productos "/list"que mostrará la lista completa de productos.
	 */
	@GetMapping({"/list"})
	public String listarTodos(Model model) {
		model.addAttribute("lista",productService.findAll());
		return "index";
	}
	
	/**
	 * Método muestra el formulario vacío y pasamos al model un nuevo producto vacío.
	 */
	@GetMapping("/nuevo")
	public String mostrarFormulario(Model model) {
		model.addAttribute("product", new Product());
		return "formulario";
	}
	

	//EDITAR PRODUCTO Y GUARDAR	
	
	@PostMapping("/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("alumno") Product p) {
		productService.edit(p);
		return "redirect:/";
	}
	
	//BORRAR PRODUCTO POR ID
	
	@GetMapping("/borrar/{productId}")
	public String borrar(@PathVariable("productId") long id) {
		productService.deleteById(id);
		return "redirect:/";
	}
	
	
	/**
	 * Método petición post. No se manda a web en el return, ya que no "actualizaría" la tabla con el nuevo elemento
	 * sino que devolvemos o redirigimos de nuevo al controller inicial (listarTodos) 
	 * para que pinte la tabla con el nuevo producto recién agregado.
	 */
	
	
	
					/*
					
					@PostMapping("/nuevo/")
					public String procesarFormulario(@ModelAttribute("product") Product p) {
						productService.agregar(p);
						return "redirect:/list";
					}
					*/
	
	
	/**
	 * Método mostrar el formulario de edición de un producto, con los datos del producto a modificar ya cargados 
	 * en los campos. Para ello, "cogeremos" el id al pinchar en el botón 
	 * de editar del alumno seleccionado y por ello, {id}. 
	 * Este id se detecta como un parámetro al estar entre llaves 
	 * y cambiará dependiendo de en qué producto hayamos pinchado para editar. 
	 * 
	 * PathVariable sirve para configurar variables dentro de una url o ruta
	 * 
	 * @param id del alumno a editar
	 * @param model
	 * @return
	 */
	
	
							/*
							@GetMapping("/editar/{id}")
							public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {
								
								//Buscamos el producto por id y recordemos que el método findById del servicio, 
								//devuelve el objeto buscado o null si no se encuentra.
								 
								Product pEditar = productService.findById(id);
								
								if (pEditar != null) {
									model.addAttribute("product", pEditar);
									return "formulario";
								} else {
									// No existe ningún alumno con el Id proporcionado.
									// Redirigimos hacia el listado.
									return "redirect:/";
								}
							}
							
							*/
	
	
	
	@GetMapping("/")
    public String mostrarProductos(Model model) {
        List<Product> productos = productService.findAll();
        model.addAttribute("products", productos);
        return "index"; 
    }
	
	@PostMapping("/comprar")
    public String comprarProducto(Long productId, Model model) {
		
        // Buscar el producto en la base de datos por el id
        Product product = productService.findById(productId).orElse(null);

        if (product != null) {
            product.setProductStockQuantity(product.getProductStockQuantity()- orderLine.getOrderLineQuantity());
            model.addAttribute("productoComprado", product);
            return "confirmacionCompra";
        } else {
            // Añadir error de compra???
            return "errorCompra";
        }
    }
	
	
	
}
