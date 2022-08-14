package com.example.springrestfulpractice.model;

import com.example.springrestfulpractice.model.orderEntity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query(value = "SELECT meal_List FROM ORDERS",nativeQuery = true)
    String findmeals();

    Order findById(int id);

    Order deleteById(int id);
}
