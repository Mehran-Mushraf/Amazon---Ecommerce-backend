package com.ChinaMarket.ChinaMarket.Convertor;

import com.ChinaMarket.ChinaMarket.Model.Seller;
import com.ChinaMarket.ChinaMarket.RequestDTO.SellerRequestDto;
import com.ChinaMarket.ChinaMarket.ResponseDTO.SellerResponseDto;

public class SellerConverter {

    public static Seller sellerRequestDtoToSeller(SellerRequestDto sellerRequestDto) {
        return Seller.builder()
                .name(sellerRequestDto.getName())
                .email(sellerRequestDto.getEmail())
                .mobNo(sellerRequestDto.getMobNo())
                .panNo(sellerRequestDto.getPanNo())
                .age(sellerRequestDto.getAge())
                .build();
    }

    public static SellerResponseDto sellerToSellerResponseDto(Seller seller) {
        SellerResponseDto sellerResponseDto = SellerResponseDto.builder()
                .name(seller.getName())
                .id(seller.getId())
                .build();
        return sellerResponseDto;
    }
}
