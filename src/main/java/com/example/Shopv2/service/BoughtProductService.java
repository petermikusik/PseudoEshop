package com.example.Shopv2.service;

import com.example.Shopv2.model.BoughtProduct;
import com.example.Shopv2.model.Customer;
import com.example.Shopv2.repository.BoughtProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoughtProductService {
    private final BoughtProductRepository boughtProductRepository;

    public BoughtProductService(BoughtProductRepository boughtProductRepository) {
        this.boughtProductRepository = boughtProductRepository;
    }

    public void addBoughtProduct(BoughtProduct boughtProduct){
        boughtProductRepository.save(boughtProduct);
    }

    public List<BoughtProduct> getAllByCustomerId(Long customerId){
        List<BoughtProduct> boughtProducts = boughtProductRepository.findBoughtProductByCustomerId(customerId.intValue());
        if (boughtProducts.size() > 0 ){
            return boughtProducts;
        } else {
            throw new IllegalStateException("No boughtproducts were found");
        }
    }
}
