package com.seb.parrolabs.controllers;

import com.seb.parrolabs.models.Orders;
import com.seb.parrolabs.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/order")
public class OrdersController {

    private final OrderService service;

    @Autowired
    public OrdersController(OrderService service) {
        System.out.println("Order Repo Created");
        this.service = service;
    }
    @GetMapping("{id}")
    public Optional<Orders> getOrdersByID(@PathVariable("id") Integer id, ModelMap model){
        return this.service.search(id);
    }
    @GetMapping("")
    public String index(ModelMap map){
        return "Instructions here: (Building)";
    }

    @PostMapping("/add")
    public Orders addOrder(Orders order, ModelMap model){
        return this.service.newOrder(order);
    }
    @GetMapping("/delete/{id}")
    public Orders deleteOrder(@PathVariable("id") Integer id, ModelMap model){
        return this.service.delete(service.search(id).get());
    }
    @GetMapping("/search/{id}")
    public Optional<Orders> searchOrder(@PathVariable("id") Integer id, ModelMap model){
        return this.service.search(id);
    }
}
