package com.routinecart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.routinecart.listener.RoutineCartContextListener;
import com.routinecart.repository.ItemRepository;
import com.routinecart.repository.OrderRepository;
import com.routinecart.service.BaseDataService;
import com.routinecart.service.ItemService;
import com.routinecart.service.ItemServiceImpl;
import com.routinecart.service.OrderService;
import com.routinecart.service.OrderServiceImpl;
import com.routinecart.repository.CategoryRepository;
import com.routinecart.service.CategoryService;
import com.routinecart.service.CategoryServiceImpl;

@Configuration
public class DomainConfig {

	@Bean
	public ItemService itemService(ItemRepository itemRepository) {
		return new ItemServiceImpl(itemRepository);
	}

	@Bean
	public OrderService orderService(OrderRepository orderRepository) {
		return new OrderServiceImpl(orderRepository);
	}
	@Bean
	public CategoryService categoryService(CategoryRepository categoryRepository) {
		return new CategoryServiceImpl(categoryRepository);
	}
	@Bean
	public BaseDataService baseDataService(ItemService itemService, ObjectMapper objectMapper, CategoryService categoryService) {
		return new BaseDataService(itemService, objectMapper, categoryService);
	}

	@Bean
	public RoutineCartContextListener routineCartContextListener(BaseDataService baseDataService) {
		return new RoutineCartContextListener(baseDataService);
	}
}
