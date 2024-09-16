package com.example.springsecurityjwt.repository;

import com.example.springsecurityjwt.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
