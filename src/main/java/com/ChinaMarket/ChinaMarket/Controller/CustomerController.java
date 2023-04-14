package com.ChinaMarket.ChinaMarket.Controller;

import com.ChinaMarket.ChinaMarket.Exception.CustomerNotFoundException;
import com.ChinaMarket.ChinaMarket.Model.Customer;
import com.ChinaMarket.ChinaMarket.RequestDTO.CustomerRequestDto;
import com.ChinaMarket.ChinaMarket.RequestDTO.CustomerUpdateRequestDto;
import com.ChinaMarket.ChinaMarket.ResponseDTO.CustomerResponseDto;
import com.ChinaMarket.ChinaMarket.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @PostMapping("/add")
    public String addCustomer(@RequestBody CustomerRequestDto customerRequestDto) {
        return customerService.addCustomer(customerRequestDto);
    }

    @GetMapping("/get_by_id/{id}")
    public CustomerResponseDto getCustomer(@PathVariable("id") int id) throws CustomerNotFoundException {
        return customerService.getCustomer(id);
    }

    @GetMapping("/get_by_email/{email}")
    public CustomerResponseDto getCustomerByEmail(@PathVariable("email") String email) throws CustomerNotFoundException {
        return customerService.getCustomerByEmail(email);
    }

    @PutMapping("/update/")
    public String updateCustomer(@RequestBody CustomerUpdateRequestDto customerUpdateRequestDto) throws CustomerNotFoundException {
        return customerService.updateCustomer(customerUpdateRequestDto);
    }

    @GetMapping("/view_all_customers")
    public List<CustomerResponseDto> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @DeleteMapping("/delete_by_id/{id}")
    public String deleteCustomer(@PathVariable("id") int id) throws CustomerNotFoundException {
        return customerService.deleteCustomer(id);
    }

}
