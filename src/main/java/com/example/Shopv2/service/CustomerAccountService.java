package com.example.Shopv2.service;

import com.example.Shopv2.model.CustomerAccount;
import com.example.Shopv2.repository.CustomerAccountRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerAccountService {
    private final CustomerAccountRepository customerAccountRepository;

    public CustomerAccountService(CustomerAccountRepository customerAccountRepository) {
        this.customerAccountRepository = customerAccountRepository;
    }

    public void addCustomerAccount(CustomerAccount customerAccount){
        customerAccountRepository.save(customerAccount);
    }

    public double getMoney(Long customerId){
        return customerAccountRepository.getMoneyByCustomerId(customerId.intValue());
    }

    public void addMoney(Long customerId, double money){
        customerAccountRepository.addMoneyByCustomerId(customerId.intValue(), money);
    }
}
