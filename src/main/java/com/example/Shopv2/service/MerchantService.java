package com.example.Shopv2.service;

import com.example.Shopv2.model.Merchant;
import com.example.Shopv2.repository.MerchantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MerchantService {
    private final MerchantRepository merchantRepository;

    public MerchantService(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }

    public List<Merchant> getAllMerchants() {
        return merchantRepository.findAll();
    }

    public Merchant getMerchantById(Long id) {
        Optional<Merchant> merchantOptional = merchantRepository.findById(id);
        if (merchantOptional.isPresent()){
            return merchantOptional.get();
        } else {
            throw new IllegalStateException("Merchant with id " + id +" does not exists");
        }
    }

    public void addMerchant(Merchant merchant) {
        Optional<Merchant> merchantOptional = merchantRepository.findMerchantByName(merchant.getName());
        if (merchantOptional.isPresent()){
            throw new IllegalStateException("Merchant with name: " + merchant.getName() + " already exists");
        }
        merchantRepository.save(merchant);
    }
}
