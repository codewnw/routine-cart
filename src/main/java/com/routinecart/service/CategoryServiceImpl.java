package com.routinecart.service;

import java.util.List;

import com.routinecart.model.Category;
import com.routinecart.model.Item;
import com.routinecart.repository.CategoryRepository;
import com.routinecart.repository.ItemRepository;


public class CategoryServiceImpl implements CategoryService {

	   private final CategoryRepository categoryRepository;

		

		public CategoryServiceImpl(CategoryRepository categoryRepository) {
			this.categoryRepository = categoryRepository;
		}

		@Override
		public Category findById(Long id) {
			return categoryRepository.findById(id).get();
		}

		@Override
		public List<Category> findAll() {
			return categoryRepository.findAll();
		}

		@Override
		public void save(Category category) {
			categoryRepository.save(category);
		}

		@Override
		public void update(Category category) {
			categoryRepository.save(category);
		}

		@Override
		public void deleteById(Long id) {
			categoryRepository.deleteById(id);
		}

		@Override
		public void saveAll(List<Category> categorys) {
			categoryRepository.saveAll(categorys);
		}

}
