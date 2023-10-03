package me.manikantan.productservice.services;

import me.manikantan.productservice.dtos.ProductDTO;
import me.manikantan.productservice.models.Product;

public interface ProductService {
	
	Product getProductById(Long Id);

	ProductDTO createNewProduct(ProductDTO productDTO);
}
