package com.example.Shopv2.service;

import com.example.Shopv2.model.Customer;
import com.example.Shopv2.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }


    public Customer getCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()){
            return customer.get();
        } else {
            throw new IllegalStateException("Customer with id " + id + " does not exists");
        }
    }

    public void addCustomer(Customer customer) {
        Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(customer.getEmail());
        if (customerOptional.isPresent()){
            throw new IllegalStateException("Customer with email " + customer.getEmail() + " already exists");
        }
        customerRepository.save(customer);
    }
}
