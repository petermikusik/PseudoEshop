package com.example.Shopv2.controller;

import com.example.Shopv2.model.BoughtProduct;
import com.example.Shopv2.service.BoughtProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bought-product")
public class BoughtProductController {
    private final BoughtProductService boughtProductService;

    public BoughtProductController(BoughtProductService boughtProductService) {
        this.boughtProductService = boughtProductService;
    }

    @GetMapping("{customerId}")
    public List<BoughtProduct> getAllByCustomerId(@PathVariable("customerId") Long customerId){
        return boughtProductService.getAllByCustomerId(customerId);
    }
}
