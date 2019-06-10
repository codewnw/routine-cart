package com.routinecart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.routinecart.repository.ItemRepository;
import com.routinecart.repository.OrderRepository;
import com.routinecart.service.ItemService;
import com.routinecart.service.ItemServiceImpl;
import com.routinecart.service.OrderService;
import com.routinecart.service.OrderServiceImpl;

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
}
