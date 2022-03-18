package com.seb.parrolabs.services;

import com.seb.parrolabs.DAO.ProductRepo;
import com.seb.parrolabs.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService{


    @Autowired
    private ProductRepo productRepo;

    @Override
    public boolean save(Product product) {
        try{
            productRepo.save(product);
        }catch (Exception e){
            return false;
        }
        System.out.println("Product with ID = "+product.getId()+" created");
        return true;
    }

    @Override
    public List<Product> read() {
        return productRepo.findAll();
    }

    @Override
    public void delete(Integer id) {
        productRepo.deleteById(id);
    }

    @Override
    public Optional<Product> searchByID(Integer id) {
        return Optional.empty();
    }

    @Override
    public Product searchByPrice(Double price) {
        return null;
    }

    @Override
    public boolean update(Product newProduct, Product oldProduct) {
        try {
            productRepo.findById(oldProduct.getId()).get().setDescription(newProduct.getDescription());
            productRepo.findById(oldProduct.getId()).get().setPrice(newProduct.getPrice());
            productRepo.findById(oldProduct.getId()).get().setWeight(newProduct.getWeight());

            return true;
        }catch (Exception e){
            System.out.println("Could not update Product: "+e);
            return false;
        }
    }

    @Override
    public Product updateDescription(Integer id, String description) {
        return productRepo.getById(id).setDescription(description);
    }

}
