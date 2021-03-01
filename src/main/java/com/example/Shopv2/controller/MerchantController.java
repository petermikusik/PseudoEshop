package com.example.Shopv2.controller;

import com.example.Shopv2.model.Merchant;
import com.example.Shopv2.service.MerchantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/merchant")
public class MerchantController {
    private final MerchantService merchantService;

    public MerchantController(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @GetMapping
    public List<Merchant> getAllMerchants(){
        return merchantService.getAllMerchants();
    }

    @GetMapping("/{id}")
    public Merchant getMerchantById(@PathVariable("id") Long id){
        return merchantService.getMerchantById(id);
    }

    @PostMapping
    public void addMerchant(@RequestBody Merchant merchant){
        merchantService.addMerchant(merchant);
    }
}
