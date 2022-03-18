package com.seb.parrolabs.services;

import com.seb.parrolabs.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    boolean save(Product product);
    public List<Product> read();

    void delete(Integer id);

    Optional<Product> searchByID(Integer id);

    Product searchByPrice(Double price);

    boolean update(Product newProduct, Product oldProduct);

    Product updateDescription(Integer id, String description);
}
