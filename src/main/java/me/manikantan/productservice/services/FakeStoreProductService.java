package me.manikantan.productservice.services;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import me.manikantan.productservice.dtos.ProductDTO;
import me.manikantan.productservice.models.Product;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService {
	
	private RestTemplateBuilder restTemplateBuilder;
	private String getRequestByURL = "https://fakestoreapi.com/products/{id}";
	private String createRequestByURL = "https://fakestoreapi.com/products";
	
	public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplateBuilder = restTemplateBuilder;
	}
	
	@Override
	public Product getProductById(Long id) {
		RestTemplate restTemplate = restTemplateBuilder.build();
		ResponseEntity<ProductDTO> response = restTemplate.getForEntity(getRequestByURL, ProductDTO.class, id);
		ProductDTO productDTO = response.getBody();
		Product product = new Product();
		product.setDescription(productDTO.getDescription());
		product.setImage(productDTO.getImage());
		product.setPrice(productDTO.getPrice());
		product.setTitle(productDTO.getTitle());
		
		return product;
		//return new Product();
	}

	@Override
	public ProductDTO createNewProduct(ProductDTO productDTO) {
		// TODO Auto-generated method stub
		RestTemplate restTeamplate = restTemplateBuilder.build();
		ResponseEntity<ProductDTO> response = restTeamplate.postForEntity(createRequestByURL, productDTO, ProductDTO.class);
		return response.getBody();
	}
}
