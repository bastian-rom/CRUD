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
    String description;
    Double price;
    Double weight;
    Product(String description, Double price, Double weight){
        this.description = description;
        this.price = price;
        this.weight = weight;
    }
}
