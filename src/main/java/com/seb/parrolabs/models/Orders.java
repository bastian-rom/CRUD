package com.seb.parrolabs.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="orders")
public class Orders {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    Integer number;
    Date date;
    @OneToOne
    @JoinColumn(name = "customer_id")
    Customer customer;
    //cash, credit card, check, other
    @OneToOne
    @JoinColumn(name = "payment_type_id")
    Payment paymentType;
    @ManyToOne
    Product products;
    Double total;
}
