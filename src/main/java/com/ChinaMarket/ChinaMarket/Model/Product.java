package com.ChinaMarket.ChinaMarket.Model;

import com.ChinaMarket.ChinaMarket.Enum.ProductCategory;
import com.ChinaMarket.ChinaMarket.Enum.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private String name;
    private int price;
    private int quantity;
    @Enumerated(EnumType.STRING)
    ProductCategory productCategory;
    @Enumerated(EnumType.STRING)
    ProductStatus productStatus;

    @ManyToOne
    @JoinColumn
    Seller seller;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    Item item;



}
