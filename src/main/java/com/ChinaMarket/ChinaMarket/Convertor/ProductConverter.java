package com.ChinaMarket.ChinaMarket.Convertor;

import com.ChinaMarket.ChinaMarket.Enum.ProductStatus;
import com.ChinaMarket.ChinaMarket.Model.Product;
import com.ChinaMarket.ChinaMarket.RequestDTO.ProductRequestDto;
import com.ChinaMarket.ChinaMarket.ResponseDTO.ProductResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProductConverter {

    public static Product productRequestDtoToProduct(ProductRequestDto productRequestDto) {
        return Product.builder()
                .name(productRequestDto.getProductName())
                .price(productRequestDto.getPrice())
                .quantity(productRequestDto.getQuantity())
                .productCategory(productRequestDto.getProductCategory())
                .productStatus(ProductStatus.AVAILABLE)
                .build();
    }

    public static ProductResponseDto productToProductResponseDto(Product product) {
        return ProductResponseDto.builder()
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .productStatus(product.getProductStatus())
                .productCategoy(product.getProductCategory())
                .build();

    }
}
