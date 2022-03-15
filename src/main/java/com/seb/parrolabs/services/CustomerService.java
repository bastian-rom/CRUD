package com.seb.parrolabs.services;

import com.seb.parrolabs.models.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    boolean create(Customer newCustomer);
    List<Customer> read();
    boolean update(Customer newCustomer,Customer oldCustomer);
    Customer delete(Customer customer);
    boolean add(Customer customer);

    boolean valid(String email);

    Customer searchByEmail(String email);

    Customer searchByPhone(Integer phone);

    Optional<Customer> searchByID(Integer id);
}
