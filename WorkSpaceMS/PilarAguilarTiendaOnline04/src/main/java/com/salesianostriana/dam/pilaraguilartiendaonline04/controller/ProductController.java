package com.salesianostriana.dam.pilaraguilartiendaonline04.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.pilaraguilartiendaonline04.model.Category;
import com.salesianostriana.dam.pilaraguilartiendaonline04.model.OrderLine;
import com.salesianostriana.dam.pilaraguilartiendaonline04.model.Product;
import com.salesianostriana.dam.pilaraguilartiendaonline04.service.CategoryService;
import com.salesianostriana.dam.pilaraguilartiendaonline04.service.ProductService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;
	private OrderLine orderLine;

	public void llamarCategorias(Model model) {
		List<Category> categorias = categoryService.findAll();
		model.addAttribute("categorias", categorias);
	}

	/**
	 * Método gestiona listado de productos "/list"que mostrará la lista completa de
	 * productos.
	 */
	@GetMapping({ "/list" })
	public String listarTodos(Model model) {
		model.addAttribute("lista", productService.findAll());
		llamarCategorias(model);
		return "/";
	}

	/**
	 * Método muestra el formulario vacío y pasamos al model un nuevo producto
	 * vacío.
	 */
	@GetMapping("/admin/producto/nuevo")
	public String nuevoProducto(Model model) {
		List<Category> categorias = categoryService.findAll();
		model.addAttribute("product", new Product());
		model.addAttribute("categorias", categorias);
		return "admin/nuevoProducto";
	}

	@PostMapping("/admin/producto/nuevo/submit")
	public String nuevoProductoOk(@ModelAttribute("producto") Product p) {
		productService.save(p);
		return "redirect:/admin/producto/list";// Podría ser también return "admin/gestionCategorias";
	}

	// EDITAR PRODUCTO Y GUARDAR

	@GetMapping("/admin/producto/editar/{id}")
	public String mostrarFormProducto(@PathVariable("id") long id, Model model) {
		Product producto = productService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Producto con Id:" + id + " no válido"));
		List<Category> categorias = categoryService.findAll();
		model.addAttribute("product", producto);
		model.addAttribute("categorias", categorias);
		return "admin/nuevoProducto";
	}

	@PostMapping("/admin/producto/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("producto") Product p) {
		productService.save(p);
		return "redirect:/admin/producto/list";
	}

	// BORRAR PRODUCTO POR ID

	@GetMapping("/admin/producto/borrar/{productId}")
	public String borrar(@PathVariable("productId") long id) {
		productService.deleteById(id);
		return "redirect:/admin/producto/list";
	}

	@GetMapping({ "/admin/producto/list" })
	public String listarTodosTabla(Model model) {
		model.addAttribute("products", productService.findAll());
		return "admin/gestionProductos";
	}

	@PostMapping("/user/comprar")
	public String comprarProducto(Long productId, Model model) {

		// Buscar el producto en la base de datos por el id
		Product product = productService.findById(productId)
				.orElseThrow(() -> new IllegalArgumentException("Producto con Id:" + productId + " no válido"));

		if (product != null) {
			product.setProductStockQuantity(product.getProductStockQuantity() - orderLine.getOrderLineQuantity());
			model.addAttribute("productoComprado", product);
			return "confirmacionCompra";
		} else {
			// Añadir error de compra???
			return "errorCompra";
		}
	}

	@GetMapping("/user/{categoryId}")
	public String sacarListaProdCatUser(@PathVariable("categoryId") Long id, Model model) {
		Optional<Category> categoria = categoryService.findById(id);
		if (categoria.isPresent()) {
			model.addAttribute("products", productService.listarProductosCategoria(categoria.get().getCategoryName()));
			llamarCategorias(model);
			return "customer/indexCustomer";
		}
		return "redirect:/";
	}

	@GetMapping("/admin/{categoryId}")
	public String sacarListaProdCatAdmin(@PathVariable("categoryId") Long id, Model model) {
		Optional<Category> categoria = categoryService.findById(id);
		if (categoria.isPresent()) {
			model.addAttribute("products", productService.listarProductosCategoria(categoria.get().getCategoryName()));
			llamarCategorias(model);
			return "admin/indexAdmin";
		}
		return "redirect:/";
	}

	@GetMapping("/{categoryId}")
	public String sacarListaProdCat(@PathVariable("categoryId") Long id, Model model) {
		Optional<Category> categoria = categoryService.findById(id);
		if (categoria.isPresent()) {
			model.addAttribute("products", productService.listarProductosCategoria(categoria.get().getCategoryName()));
			llamarCategorias(model);
			return "index";
		}
		return "redirect:/";
	}

}
