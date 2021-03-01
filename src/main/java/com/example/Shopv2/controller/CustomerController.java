package com.example.Shopv2.controller;

import com.example.Shopv2.model.Customer;
import com.example.Shopv2.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable("id") Long id){
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public void addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
    }
}
