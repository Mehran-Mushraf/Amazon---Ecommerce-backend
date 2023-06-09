package com.ChinaMarket.ChinaMarket.Service;

import com.ChinaMarket.ChinaMarket.Convertor.ProductConverter;
import com.ChinaMarket.ChinaMarket.Enum.ProductCategory;
import com.ChinaMarket.ChinaMarket.Exception.SellerNotFoundException;
import com.ChinaMarket.ChinaMarket.Model.Product;
import com.ChinaMarket.ChinaMarket.Model.Seller;
import com.ChinaMarket.ChinaMarket.Repository.ProductRepository;
import com.ChinaMarket.ChinaMarket.Repository.SellerRepository;
import com.ChinaMarket.ChinaMarket.RequestDTO.ProductRequestDto;
import com.ChinaMarket.ChinaMarket.ResponseDTO.ProductResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    ProductRepository productRepository;
    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) throws SellerNotFoundException {
        Seller seller;

        try{
            seller = sellerRepository.findById(productRequestDto.getSellerId()).get();
        }
        catch (Exception e) {
            throw new SellerNotFoundException("Invalid Seller Id");
        }

        Product product = ProductConverter.productRequestDtoToProduct(productRequestDto);
        product.setSeller(seller);

        seller.getProducts().add(product);

//      saved the seller and product  - parent and child
        sellerRepository.save(seller);

//      prepare response
        ProductResponseDto productResponseDto = ProductConverter.productToProductResponseDto(product);
        return productResponseDto;


    }

    public List<ProductResponseDto> getProductsByCategory(ProductCategory productCategory) {
        List<Product> products = productRepository.findAllByProductCategory(productCategory);

//        preparing a list of response dtos
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();

        for(Product product : products) {
            ProductResponseDto productResponseDto = ProductConverter.productToProductResponseDto(product);
            productResponseDtos.add(productResponseDto);
        }

        return productResponseDtos;
    }
}
