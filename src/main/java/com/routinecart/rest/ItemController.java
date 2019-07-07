package com.routinecart.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.routinecart.model.Item;
import com.routinecart.repository.ItemRepository;

@RestController
@RequestMapping("/api/items")
public class ItemController {

	private final ItemRepository itemRepository;

	public ItemController(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Item> list() {
		return itemRepository.findAll();
	}

	@PostMapping
	public void save(@RequestBody Item item) {
		itemRepository.save(item);
	}

//	@GetMapping("/{id}")
//	public Item get(@PathVariable Long id) {
//		return itemRepository.findById(id).get();
//	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		itemRepository.deleteById(id);
	}

	@PutMapping
	public void update(@RequestBody Item item) {
		itemRepository.save(item);
	}
	
	@GetMapping(params = {"category"})
	public List<Item> listOfSubcategory(@RequestParam("category") String category) {
		
//		 List<Item> result = new ArrayList<Item>();
//	        for (Item line : itemRepository.findAll()) {
//	            if (line.getSubCategory() == subCategory) { // we dont like mkyong
//	                result.add(line);
//	            }
//	        }
//	        
//	        System.out.println(result);
//	        return result;
		System.out.println("Here.");
		return null;
					
	}
	
	@GetMapping(params = {"category", "subCategory"})
	public List<Item> listOfSubcategory(@RequestParam("category") String category, @RequestParam("subCategory") String subCategory) {
		
//		 List<Item> result = new ArrayList<Item>();
//	        for (Item line : itemRepository.findAll()) {
//	            if (line.getSubCategory() == subCategory) { // we dont like mkyong
//	                result.add(line);
//	            }
//	        }
//	        
//	        System.out.println(result);
//	        return result;
		System.out.println("Here..");
		return null;
					
	}

}
