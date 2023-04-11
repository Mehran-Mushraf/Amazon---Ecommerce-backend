package com.ChinaMarket.ChinaMarket.Service;

import com.ChinaMarket.ChinaMarket.Controller.SellerController;
import com.ChinaMarket.ChinaMarket.Convertor.SellerConverter;
import com.ChinaMarket.ChinaMarket.Exception.SellerNotFoundException;
import com.ChinaMarket.ChinaMarket.Model.Seller;
import com.ChinaMarket.ChinaMarket.Repository.SellerRepository;
import com.ChinaMarket.ChinaMarket.RequestDTO.SellerRequestDto;
import com.ChinaMarket.ChinaMarket.ResponseDTO.SellerResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class SellerService {
    @Autowired
    SellerRepository sellerRepository;
    public String addSeller(SellerRequestDto sellerRequestDto) {

       Seller seller = SellerConverter.sellerRequestDtoToSeller(sellerRequestDto);
        sellerRepository.save(seller);

        return "Congrats' Now you can sell on China Market !!!!";
    }

    public List<SellerResponseDto> getAllSellers() {
        List<Seller> sellers = sellerRepository.findAll();

        List<SellerResponseDto> sellerResponseDtos = new ArrayList<>();

        for(Seller seller: sellers) {
            SellerResponseDto sellerResponseDto = SellerConverter.sellerToSellerResponseDto(seller);
            sellerResponseDtos.add(sellerResponseDto);
        }
        return sellerResponseDtos;
    }

    public SellerResponseDto findByPanNo(String panNo) throws SellerNotFoundException {
        Seller seller;
        try {
            seller = sellerRepository.findByPanNo(panNo);
        }catch (Exception e) {
            throw new SellerNotFoundException("Invalid PanCard");
        }
        SellerResponseDto sellerResponseDto = SellerConverter.sellerToSellerResponseDto(seller);
        return sellerResponseDto;

    }

    public List<SellerResponseDto> findByAge(@PathVariable("age") int age) throws SellerNotFoundException {
        List<Seller> sellers;
        try {
            sellers = sellerRepository.findByAge(age);
        }catch (Exception e) {
            throw new SellerNotFoundException("No seller found for this age!");
        }
        List<SellerResponseDto> sellerResponseDtos = new ArrayList<>();
        for(Seller seller : sellers) {
            SellerResponseDto sellerResponseDto = SellerConverter.sellerToSellerResponseDto(seller);
            sellerResponseDtos.add(sellerResponseDto);
        }

        return sellerResponseDtos;
    }
}
