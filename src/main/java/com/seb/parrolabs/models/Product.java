package com.seb.parrolabs.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    Integer id;
    String name;
    String description;
    Double price;
    Double weight;
    Product(String name, Double price, Double weight){
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }
}
