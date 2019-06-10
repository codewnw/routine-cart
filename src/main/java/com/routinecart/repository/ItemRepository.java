package com.routinecart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.routinecart.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
