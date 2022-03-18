package com.seb.parrolabs.controllers;

import com.seb.parrolabs.models.Product;
import com.seb.parrolabs.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping({"/","/products"})
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        System.out.println("Product Repo Created");
        this.service = service;
    }

    @GetMapping({"","all"})
    public List<Product> getProducts(ModelMap mod){
        return this.service.read();
    }

    @GetMapping("/id/{id}")
    public Optional<Product> getProductsByID(@PathVariable("id") Integer id, ModelMap model){

        return this.service.searchByID(id);
    }
    @GetMapping("/price/{price}")
    public Product getProductsByPhone(@PathVariable("phone") Double price, ModelMap model){
        return this.service.searchByPrice(price);
    }

    @PostMapping("/update_by_id/{id}")
    public boolean updateProductByID(@PathVariable("id")Integer id,@RequestBody Product newProduct, ModelMap model){
        return this.service.update(newProduct,service.searchByID(id).get());
    }

    @PostMapping("/save")
    public boolean saveProduct(@RequestBody Product newProduct, ModelMap model){
        return this.service.save(newProduct);
    }

    @GetMapping("/description/{id}")
    public Product updateDescription(@PathVariable("id")Integer id,String description, ModelMap model){
        return this.service.updateDescription(id,description);
    }
    @GetMapping("/delete/{id}")
    public boolean updateDescription(@PathVariable("id")Integer id, ModelMap model){
        this.service.delete(id);
        return !this.service.searchByID(id).isPresent();
    }

}
