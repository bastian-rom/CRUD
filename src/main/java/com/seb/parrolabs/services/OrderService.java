package com.seb.parrolabs.services;

import com.seb.parrolabs.models.Orders;

import java.util.Optional;

public interface OrderService {
    public Orders delete(Orders orders);
    Optional<Orders> search(Integer orderNumber);
    Orders newOrder(Orders orders);
}
