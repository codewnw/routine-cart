package com.routinecart.rest;

import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.routinecart.model.Product;
import com.routinecart.repository.ProductRepository;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private final ProductRepository productRepository;

	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

    @GetMapping(value = { "", "/" })
    public @NotNull Iterable<Product> getProducts() {
        return productRepository.findAll();
    }
    
	@PostMapping("/")
	public void save(@RequestBody Product product) {
		productRepository.save(product);
	}
}
