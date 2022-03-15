package com.seb.parrolabs.models;//package com.seb.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    Integer id;
    @Column(unique = true)
    String email;
    @Column(unique = true)
    Integer phone;
    @OneToOne
    @JoinColumn(name = "shipping_address_id")
    ShippingAddress shippingAddress;

    String name;
}
