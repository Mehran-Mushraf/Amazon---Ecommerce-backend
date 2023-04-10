package com.ChinaMarket.ChinaMarket.Controller;

import com.ChinaMarket.ChinaMarket.RequestDTO.SellerRequestDto;
import com.ChinaMarket.ChinaMarket.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller")
public class SellerController {
    @Autowired
    SellerService sellerService;
    @PostMapping("/add")
    public String addSeller(@RequestBody SellerRequestDto sellerRequestDto) {
        return sellerService.addSeller(sellerRequestDto);
    }
}
