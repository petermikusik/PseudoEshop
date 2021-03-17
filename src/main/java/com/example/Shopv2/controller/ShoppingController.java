package com.example.Shopv2.controller;

import com.example.Shopv2.request.BuyProductRequest;
import com.example.Shopv2.service.ShoppingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("shop")
public class ShoppingController {
    private final ShoppingService shoppingService;

    public ShoppingController(ShoppingService shoppingService) {
        this.shoppingService = shoppingService;
    }

    @PostMapping("/buy")
    public void buy(@RequestBody BuyProductRequest buyProductRequest){
        shoppingService.buyProduct(buyProductRequest);
    }

}
