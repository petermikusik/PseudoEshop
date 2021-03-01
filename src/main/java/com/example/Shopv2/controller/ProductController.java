package com.example.Shopv2.controller;

import com.example.Shopv2.dto.ProductDTO;
import com.example.Shopv2.model.Product;
import com.example.Shopv2.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }

    @PostMapping
    public void addProduct(@RequestBody ProductDTO productDTO){
        productService.addProduct(productDTO);
    }
}
