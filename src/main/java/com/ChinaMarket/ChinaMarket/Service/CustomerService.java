package com.ChinaMarket.ChinaMarket.Service;

import com.ChinaMarket.ChinaMarket.Convertor.CustomerConverter;
import com.ChinaMarket.ChinaMarket.Exception.CustomerNotFoundException;
import com.ChinaMarket.ChinaMarket.Model.Cart;
import com.ChinaMarket.ChinaMarket.Model.Customer;
import com.ChinaMarket.ChinaMarket.Repository.CustomerRepository;
import com.ChinaMarket.ChinaMarket.RequestDTO.CustomerRequestDto;
import com.ChinaMarket.ChinaMarket.RequestDTO.CustomerUpdateRequestDto;
import com.ChinaMarket.ChinaMarket.ResponseDTO.CustomerResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    public String addCustomer(CustomerRequestDto customerRequestDto) {
        Customer customer = CustomerConverter.CustomerRequestDtoCustomer(customerRequestDto);
        Cart cart = new Cart();
        cart.setCartTotal(0);
        cart.setCustomer(customer);

//        set cart in customer
        customer.setCart(cart);

        customerRepository.save(customer);
        return "Congrats! Welcome to China Market.";

    }

    public CustomerResponseDto getCustomer(int id) throws CustomerNotFoundException {
        Customer customer;

        try{
            customer = customerRepository.findById(id).get();
        }
        catch (Exception e) {
            throw new CustomerNotFoundException("Customer not found");
        }

        return CustomerConverter.customerToCustomerResponseDto(customer);
    }

    public CustomerResponseDto getCustomerByEmail(String email) throws CustomerNotFoundException {
        Customer customer;

        try{
            customer = customerRepository.getCustomerByEmail(email);
        }
        catch (Exception e) {
            throw new CustomerNotFoundException("Customer not found");
        }

        return CustomerConverter.customerToCustomerResponseDto(customer);
    }

    public String updateCustomer(CustomerUpdateRequestDto customerUpdateRequestDto) throws CustomerNotFoundException {
        Customer customer = CustomerConverter.CustomerUpdateRequestDtoCustomer(customerUpdateRequestDto);
        try {
            customer = customerRepository.save(customer);
        } catch (Exception e) {
            throw new CustomerNotFoundException("customer not found");
        }
        return "Customer updated successfully";
    }
    public List<CustomerResponseDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();

        List<CustomerResponseDto> customerResponseDtoList = new ArrayList<>();
        for(Customer customer : customers) {
            CustomerResponseDto customerResponseDto = CustomerConverter.customerToCustomerResponseDto(customer);
            customerResponseDtoList.add(customerResponseDto);
        }

        return customerResponseDtoList;
    }

    public String deleteCustomer(int id) throws CustomerNotFoundException {
        try{
            customerRepository.deleteById(id);
        } catch (Exception e) {
            throw new CustomerNotFoundException("Customer not found!");
        }

        return "Customer deleted successfully";
    }


}
