package com.ChinaMarket.ChinaMarket.Controller;

import com.ChinaMarket.ChinaMarket.RequestDTO.CardRequestDto;
import com.ChinaMarket.ChinaMarket.ResponseDTO.CardResponseDto;
import com.ChinaMarket.ChinaMarket.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Card")
public class CardController {

    @Autowired
    CardService cardService;

    @PostMapping("/add")
    public ResponseEntity addCard(@RequestBody CardRequestDto cardRequestDto) {
        CardResponseDto cardResponseDto;
        try {
            cardService.addCard(cardRequestDto);
        }
        catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(cardRequestDto,HttpStatus.ACCEPTED);
    }
}
