package com.ChinaMarket.ChinaMarket.Repository;

import com.ChinaMarket.ChinaMarket.Model.Card;
import com.ChinaMarket.ChinaMarket.Model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer> {

    Seller findByPanNo(String panNo);
    List<Seller> findByAge(int age);

}
