package com.ChinaMarket.ChinaMarket.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private int requiredQuantity;

    @ManyToOne
    @JoinColumn
    Cart cart;
    @OneToOne
    @JoinColumn
    Product product;

    @ManyToOne
    @JoinColumn
    Ordered order;
}
