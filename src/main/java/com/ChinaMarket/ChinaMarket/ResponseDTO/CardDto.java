package com.ChinaMarket.ChinaMarket.ResponseDTO;

import com.ChinaMarket.ChinaMarket.Enum.CardType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardDto {

    private String cardNo;
    private CardType cardType;
}
