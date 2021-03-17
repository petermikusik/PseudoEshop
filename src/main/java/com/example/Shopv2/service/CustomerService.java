package com.example.Shopv2.service;

import com.example.Shopv2.model.Customer;
import com.example.Shopv2.model.CustomerAccount;
import com.example.Shopv2.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerAccountService customerAccountService;

    public CustomerService(CustomerRepository customerRepository, CustomerAccountService customerAccountService) {
        this.customerRepository = customerRepository;
        this.customerAccountService = customerAccountService;
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
        CustomerAccount customerAccount = new CustomerAccount();
        customerAccount.setCustomer(customer);
        customerAccount.setMoney(0);
        customerAccountService.addCustomerAccount(customerAccount);
    }
}
