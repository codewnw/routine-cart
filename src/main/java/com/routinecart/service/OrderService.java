package com.routinecart.service;

import java.util.List;

import com.routinecart.model.Order;

public interface OrderService {
	Order findById(Long id);

	List<Order> findAll();

	void save(Order order);

	void update(Order order);

	void deleteById(Long id);
}
