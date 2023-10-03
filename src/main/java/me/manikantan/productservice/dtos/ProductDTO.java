package me.manikantan.productservice.dtos;

import lombok.Getter;
import lombok.Setter;
import me.manikantan.productservice.models.Category;

@Getter
@Setter
public class ProductDTO {
	private Long id;
	private String title;
	private String description;
	private String category;
	private double price;
	private String image;
}
