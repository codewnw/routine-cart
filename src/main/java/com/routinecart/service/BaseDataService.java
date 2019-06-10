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

public class BaseDataService {

	private final ItemService itemService;

	private final ObjectMapper objectMapper;

	public BaseDataService(ItemService itemService, ObjectMapper objectMapper) {
		this.itemService = itemService;
		this.objectMapper = objectMapper;
	}

	public void createBaseData() {
		createItemBaseData();
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

}
