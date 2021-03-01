package com.example.Shopv2.service;

import com.example.Shopv2.model.Merchant;
import com.example.Shopv2.repository.MerchantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantService {
    private final MerchantRepository merchantRepository;

    public MerchantService(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }

    public List<Merchant> getAllMerchants() {
        return merchantRepository.findAll();
    }
}
