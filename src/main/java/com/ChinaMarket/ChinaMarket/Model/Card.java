package com.ChinaMarket.ChinaMarket.Model;

import com.ChinaMarket.ChinaMarket.Enum.CardType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(unique = true)
    private String cardNo;
    private int cvv;
    @Enumerated(EnumType.STRING)
    private CardType cardType;
    @ManyToOne
    @JoinColumn
    Customer customer;

}
