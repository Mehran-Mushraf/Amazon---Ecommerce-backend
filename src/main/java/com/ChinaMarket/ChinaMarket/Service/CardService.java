package com.ChinaMarket.ChinaMarket.Service;

import com.ChinaMarket.ChinaMarket.Exception.CustomerNotFoundException;
import com.ChinaMarket.ChinaMarket.Model.Card;
import com.ChinaMarket.ChinaMarket.Model.Customer;
import com.ChinaMarket.ChinaMarket.Repository.CustomerRepository;
import com.ChinaMarket.ChinaMarket.RequestDTO.CardRequestDto;
import com.ChinaMarket.ChinaMarket.ResponseDTO.CardDto;
import com.ChinaMarket.ChinaMarket.ResponseDTO.CardResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {
    @Autowired
    CustomerRepository customerRepository;
    public CardResponseDto addCard(CardRequestDto cardRequestDto) throws CustomerNotFoundException {
        Customer customer;

        try {
            customer = customerRepository.findById(cardRequestDto.getCustomerId()).get();
        }catch (Exception e) {
            throw new CustomerNotFoundException("Invalid customer id");
        }

//        Make a card object
        Card card = Card.builder()
                .cardNo(cardRequestDto.getCardNo())
                .cvv(cardRequestDto.getCvv())
                .cardType(cardRequestDto.getCardType())
                .customer(customer)
                .build();

//        add the card to current card list of customer
        customer.getCards().add(card);

//        this will save both customer and card
        customerRepository.save(customer);

//        prepare response Dto
        CardResponseDto cardResponseDto = CardResponseDto.builder()
                .name(customer.getName())
                .build();

//        convert ervery card to cardDto
        List<CardDto> cardDtoList = new ArrayList<>();
        for (Card card1: customer.getCards()) {
            CardDto cardDto = new CardDto();
            cardDto.setCardNo(card1.getCardNo());
            cardDto.setCardType(card1.getCardType());

            cardDtoList.add(cardDto);
        }

        cardResponseDto.setCardDtos(cardDtoList);
        return cardResponseDto;
    }

}
