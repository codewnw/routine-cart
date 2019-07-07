package com.routinecart.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.routinecart.model.Item;
import com.routinecart.repository.ItemRepository;
@Service
@Transactional

public class ItemServiceImpl implements ItemService {

	private final ItemRepository itemRepository;

	public ItemServiceImpl(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@Override
	public Item findById(Long id) {
		return itemRepository.findById(id).get();
	}

	@Override
	public List<Item> findAll() {
		return itemRepository.findAll();
	}

	@Override
	public void save(Item item) {
		itemRepository.save(item);
	}

	@Override
	public void update(Item item) {
		itemRepository.save(item);
	}

	@Override
	public void deleteById(Long id) {
		itemRepository.deleteById(id);
	}

	@Override
	public void saveAll(List<Item> items) {
		itemRepository.saveAll(items);
	}
	
	
}
