package com.ChinaMarket.ChinaMarket.Service;

import com.ChinaMarket.ChinaMarket.Controller.SellerController;
import com.ChinaMarket.ChinaMarket.Convertor.SellerConverter;
import com.ChinaMarket.ChinaMarket.Model.Seller;
import com.ChinaMarket.ChinaMarket.Repository.SellerRepository;
import com.ChinaMarket.ChinaMarket.RequestDTO.SellerRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {
    @Autowired
    SellerRepository sellerRepository;
    public String addSeller(SellerRequestDto sellerRequestDto) {

       Seller seller = SellerConverter.SellerRequestDtoToSeller(sellerRequestDto);
        sellerRepository.save(seller);

        return "Congrats' Now you can sell on China Market !!!!";
    }
}
