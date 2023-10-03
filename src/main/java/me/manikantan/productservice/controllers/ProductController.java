package me.manikantan.productservice.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.manikantan.productservice.dtos.ProductDTO;
import me.manikantan.productservice.models.Product;
import me.manikantan.productservice.services.FakeStoreProductService;
import me.manikantan.productservice.services.ProductService;

@RestController
@RequestMapping("/ECommerceWeb/products")
public class ProductController {
	
	private ProductService productService;
	
	@Autowired
	public ProductController(@Qualifier("FakeStoreProductService") ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable("id") Long id) {
		return productService.getProductById(id);
	}
	
	@GetMapping
	public String getAllProducts() {
		return "";
	}
	
	@PostMapping
	public ProductDTO createNewProduct(@RequestBody ProductDTO productDTO) {
		return productService.createNewProduct(productDTO);
	}
	
	@PutMapping("/{id}")
	public String updateProductById(Long id) {
		return "";
	}
	
	@DeleteMapping("/{id}")
	public String deleteProductById(Long id) {
		return "";
	}
}
