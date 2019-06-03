package com.routinecart.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.routinecart.model.Order;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Order> list() {
		Order order1 = new Order(1L, "SUCCESS");
		Order order2 = new Order(2L, "PENDING");
		List<Order> orders = new ArrayList<>();
		orders.add(order1);
		orders.add(order2);
		System.out.println("I'm here...");
		return orders;
	}

}
