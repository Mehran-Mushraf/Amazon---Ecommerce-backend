package com.ChinaMarket.ChinaMarket.Controller;

import com.ChinaMarket.ChinaMarket.Exception.SellerNotFoundException;
import com.ChinaMarket.ChinaMarket.Model.Seller;
import com.ChinaMarket.ChinaMarket.RequestDTO.SellerRequestDto;
import com.ChinaMarket.ChinaMarket.ResponseDTO.SellerResponseDto;
import com.ChinaMarket.ChinaMarket.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller")
public class SellerController {
    @Autowired
    SellerService sellerService;
    @PostMapping("/add")
    public String addSeller(@RequestBody SellerRequestDto sellerRequestDto) {
        return sellerService.addSeller(sellerRequestDto);
    }

    @GetMapping("/get_all_sellers")
    public List<SellerResponseDto> getAllSellers() {
        return sellerService.getAllSellers();
    }

    @GetMapping("/get_by_panNo/{panNo}")
    public SellerResponseDto findByPanNo(@PathVariable("panNo") String pancard) throws SellerNotFoundException {
        return sellerService.findByPanNo(pancard);
    }

    @GetMapping("/get_by_age/{age}")
    public List<SellerResponseDto> findByAge(@PathVariable("age") int age) throws SellerNotFoundException {
        return sellerService.findByAge(age);
    }
}
