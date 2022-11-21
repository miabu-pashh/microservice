package com.nagarro.userservice.repository;


import com.nagarro.userservice.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {

    Item findByItemId(Long itemId);
}
