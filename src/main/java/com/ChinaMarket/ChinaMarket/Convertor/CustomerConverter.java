package com.ChinaMarket.ChinaMarket.Convertor;

import com.ChinaMarket.ChinaMarket.Model.Customer;
import com.ChinaMarket.ChinaMarket.RequestDTO.CustomerRequestDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CustomerConverter {

    public Customer CustomerRequestDtoCustomer(CustomerRequestDto customerRequestDto) {
        return Customer.builder()
                .name(customerRequestDto.getName())
                .age(customerRequestDto.getAge())
                .mobNo(customerRequestDto.getMobNo())
                .email(customerRequestDto.getEmail())
                .build();
    }
}
