package com.ChinaMarket.ChinaMarket.Convertor;

import com.ChinaMarket.ChinaMarket.Model.Seller;
import com.ChinaMarket.ChinaMarket.RequestDTO.SellerRequestDto;

public class SellerConverter {

    public static Seller SellerRequestDtoToSeller(SellerRequestDto sellerRequestDto) {
        return Seller.builder()
                .name(sellerRequestDto.getName())
                .email(sellerRequestDto.getEmail())
                .mobNo(sellerRequestDto.getMobNo())
                .panNo(sellerRequestDto.getPanNo())
                .build();
    }
}
