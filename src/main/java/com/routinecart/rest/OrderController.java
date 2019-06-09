package com.routinecart.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.routinecart.OrderRepository;
import com.routinecart.model.Order;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;

	@GetMapping("/")
	@ResponseStatus(HttpStatus.OK)
	public List<Order> list() {
		return orderRepository.findAll();
	}

	@PostMapping("/")
	public void save(@RequestBody Order order) {
		orderRepository.save(order);
	}

	@GetMapping("/{id}")
	public Order get(@PathVariable Long id) {
		return orderRepository.findById(id).get();
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		orderRepository.deleteById(id);
	}

	@PutMapping
	public void update(@RequestBody Order order) {
		orderRepository.save(order);
	}

}
