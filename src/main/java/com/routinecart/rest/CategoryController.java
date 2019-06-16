package com.routinecart.rest;

import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.routinecart.model.Category;
import com.routinecart.repository.CategoryRepository;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	private final CategoryRepository categoryRepository;

	public CategoryController(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

    @GetMapping(value = { "", "/" })
    public @NotNull Iterable<Category> getCategory() {
        return categoryRepository.findAll();
    }
    
	@PostMapping("/")
	public void save(@RequestBody Category category) {
		categoryRepository.save(category);
	}
}