package com.routinecart.service;

import java.util.List;

import com.routinecart.model.Item;

public interface ItemService {
	Item findById(Long id);

	List<Item> findAll();

	void save(Item item);

	void update(Item item);

	void deleteById(Long id);
}
