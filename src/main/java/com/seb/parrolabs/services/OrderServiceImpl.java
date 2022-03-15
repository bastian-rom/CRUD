package com.seb.parrolabs.services;

import com.seb.parrolabs.DAO.OrderRepo;
import com.seb.parrolabs.models.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepo orderRepo;

    @Override
    public Orders delete(Orders order) {
        if(order.getProducts().getId()==null)
            orderRepo.delete(order);
        return order;
    }

    @Override
    public Optional<Orders> search(Integer orderNumber) {
        return orderRepo.findById(orderNumber);
    }

    @Override
    public Orders newOrder(Orders orders) {
        return orderRepo.save(orders);
    }
}
