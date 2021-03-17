package com.example.Shopv2.service;

import com.example.Shopv2.model.BoughtProduct;
import com.example.Shopv2.model.Customer;
import com.example.Shopv2.repository.BoughtProductRepository;

import java.util.ArrayList;
import java.util.List;

public class BoughtProductService {
    private BoughtProductRepository boughtProductRepository;

    public BoughtProductService(BoughtProductRepository boughtProductRepository) {
        this.boughtProductRepository = boughtProductRepository;
    }

    public void addBoughtProduct(BoughtProduct boughtProduct){
        boughtProductRepository.save(boughtProduct);
    }

    public ArrayList<BoughtProduct> getAllByCustomer(Customer customer){
        ArrayList<BoughtProduct> boughtProducts = boughtProductRepository.findBoughtProductByCustomerId(customer.getId());
        if (boughtProducts.size() > 0 ){
            return boughtProducts;
        } else {
            throw new IllegalStateException("No boughtproducts were found");
        }
    }
}
