package com.routinecart.service;

import static java.util.Collections.emptyList;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.routinecart.model.Item;
import com.routinecart.model.Category;

public class BaseDataService {

	private final ItemService itemService;
	private final CategoryService categoryService;

	private final ObjectMapper objectMapper;

	public BaseDataService(ItemService itemService, ObjectMapper objectMapper,CategoryService categoryService) {
		this.itemService = itemService;
		this.objectMapper = objectMapper;
		this.categoryService = categoryService;
	}

	public void createBaseData() {
		createItemBaseData();
		createCategoriesJsonData();
	}

	private void createItemBaseData() {
		File file;
		List<Item> items;
		try {
			file = ResourceUtils.getFile("classpath:base-data/items.json");
			String itemsJson = new String(Files.readAllBytes(file.toPath()));
			items = objectMapper.readValue(itemsJson, new TypeReference<List<Item>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
			items = emptyList();
		}
		itemService.saveAll(items);
	}
	private void createCategoriesJsonData() {
		File file;
		List<Category> categorys;
		
		try {
			file = ResourceUtils.getFile("classpath:base-data/categories.json");
			String categoriesJson = new String(Files.readAllBytes(file.toPath()));
			System.out.println("categoriesJson"+categoriesJson);
			categorys = objectMapper.readValue(categoriesJson, new TypeReference<List<Category>>() {
			});
		

		} catch (IOException e) {
			e.printStackTrace();
			categorys = emptyList();
		}
		 categoryService.saveAll(categorys); 
		
	}
}
