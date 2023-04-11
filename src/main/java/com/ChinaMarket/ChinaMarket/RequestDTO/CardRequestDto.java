package com.ChinaMarket.ChinaMarket.RequestDTO;

import com.ChinaMarket.ChinaMarket.Enum.CardType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CardRequestDto {
    private int customerId;
    private String cardNo;
    private int cvv;
    private CardType cardType;
}
