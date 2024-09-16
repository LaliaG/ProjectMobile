package com.example.springsecurityjwt.service;

import com.example.springsecurityjwt.model.Order;
import com.example.springsecurityjwt.model.Product;

import java.util.List;
import java.util.Optional;

public interface IOrderService {

    public Order createOrder(Order order);

    public List<Order> getAllUserOrders();

    public Optional<Order> getOrderById(Long id);

    public Order updateOrder(Order order);

    public void cancelOrder(Long id);
}
