package com.routinecart;

import org.springframework.data.jpa.repository.JpaRepository;

import com.routinecart.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
