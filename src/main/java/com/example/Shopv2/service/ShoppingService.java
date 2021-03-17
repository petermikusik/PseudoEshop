package com.example.Shopv2.service;

import com.example.Shopv2.model.BoughtProduct;
import com.example.Shopv2.model.Customer;
import com.example.Shopv2.model.Product;
import com.example.Shopv2.request.BuyProductRequest;
import org.springframework.stereotype.Service;

@Service
public class ShoppingService {

    private final ProductService productService;
    private final CustomerService customerService;
    private final CustomerAccountService customerAccountService;
    private final BoughtProductService boughtProductService;

    public ShoppingService(ProductService productService, CustomerService customerService, CustomerAccountService customerAccountService, BoughtProductService boughtProductService) {
        this.productService = productService;
        this.customerService = customerService;
        this.customerAccountService = customerAccountService;
        this.boughtProductService = boughtProductService;
    }

    public void buyProduct(BuyProductRequest buyProductRequest) {
        Long productId = buyProductRequest.getProductId();
        Long customerId = buyProductRequest.getCustomerId();
        int quantity = buyProductRequest.getQuantity();

        Product product = productService.getProductById(productId);
        if (product == null){
            throw new IllegalStateException("Product with id " + productId + " does not exists");
        }

        if (product.getAvailable() < quantity){
            throw new IllegalStateException("Not enough products in stock");
        }

        Customer customer = customerService.getCustomerById(customerId);
        if (customer == null){
            throw new IllegalStateException("Customer with id " + customerId + " does not exists");
        }

        double customerMoney = customerAccountService.getMoney(customerId);
        double totalPrice = quantity*product.getPrice();
        if (customerMoney >= totalPrice){

            productService.updateAvailableInternal(productId, product.getAvailable() - quantity);
            customerAccountService.subtractMoney(customerId, totalPrice);
            boughtProductService.addBoughtProduct(new BoughtProduct(product, customer, quantity));
        } else {
            throw new IllegalStateException("Customer does not have enough money");
        }
    }
}
