package com.ChinaMarket.ChinaMarket.Convertor;

import com.ChinaMarket.ChinaMarket.Model.Customer;
import com.ChinaMarket.ChinaMarket.RequestDTO.CustomerRequestDto;
import com.ChinaMarket.ChinaMarket.RequestDTO.CustomerUpdateRequestDto;
import com.ChinaMarket.ChinaMarket.ResponseDTO.CustomerResponseDto;
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

    public CustomerResponseDto customerToCustomerResponseDto(Customer customer) {
        return CustomerResponseDto.builder()
                .name(customer.getName())
                .id(customer.getId())
                .mobNo(customer.getMobNo())
                .email(customer.getEmail())
                .build();
    }

    public Customer CustomerUpdateRequestDtoCustomer(CustomerUpdateRequestDto customerUpdateRequestDto) {
        return Customer.builder()
                .id(customerUpdateRequestDto.getId())
                .name(customerUpdateRequestDto.getName())
                .age(customerUpdateRequestDto.getAge())
                .mobNo(customerUpdateRequestDto.getMobNo())
                .email(customerUpdateRequestDto.getEmail())
                .build();
    }
}
