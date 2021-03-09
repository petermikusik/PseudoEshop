package com.example.Shopv2.controller;

import com.example.Shopv2.dto.ProductDTO;
import com.example.Shopv2.dtoconverter.ProductToDTOConverter;
import com.example.Shopv2.model.Product;
import com.example.Shopv2.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final ProductToDTOConverter productToDTOConverter;

    public ProductController(ProductService productService, ProductToDTOConverter productToDTOConverter) {
        this.productService = productService;
        this.productToDTOConverter = productToDTOConverter;
    }

    @GetMapping
    public List<ProductDTO> getAllProducts(){
        return productToDTOConverter.entityListToDtoList(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable("id") Long id){
        return productToDTOConverter.entityToDto(productService.getProductById(id));
    }

    @PostMapping
    public void addProduct(@RequestBody ProductDTO productDTO){
        productService.addProduct(productToDTOConverter.dtoToEntity(productDTO));
    }
}
