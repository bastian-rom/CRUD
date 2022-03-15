package com.seb.parrolabs.services;

import com.seb.parrolabs.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    boolean create(Product product);
    public List<Product> read();
    Product delete(Product product);

    Optional<Product> searchByID(Integer id);

    Product searchByPrice(Double price);

    boolean update(Product newProduct, Product oldProduct);
}
