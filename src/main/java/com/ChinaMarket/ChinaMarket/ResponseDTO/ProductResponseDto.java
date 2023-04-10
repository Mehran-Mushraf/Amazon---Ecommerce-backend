package com.ChinaMarket.ChinaMarket.ResponseDTO;

import com.ChinaMarket.ChinaMarket.Enum.ProductCategory;
import com.ChinaMarket.ChinaMarket.Enum.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponseDto {
    private String name;
    private int price;
    private int quantity;
    private ProductStatus productStatus;
    private ProductCategory productCategoy;
}
