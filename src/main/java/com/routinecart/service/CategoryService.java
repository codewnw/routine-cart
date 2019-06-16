package com.routinecart.service;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.routinecart.model.Category;
import com.routinecart.model.Item;

public interface CategoryService {
	Category findById(Long id);

	List<Category> findAll();

	void save(Category item);

	void update(Category item);

	void deleteById(Long id);
	
	void saveAll(List<Category> items);
}
