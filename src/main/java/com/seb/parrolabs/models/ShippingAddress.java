package com.seb.parrolabs.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Table(name = "shipping_address")
public class ShippingAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    Integer id;

    String streetName;
    Integer streetNumber;
    String country;
    String city;
    String state;
    Long zipCode;

}