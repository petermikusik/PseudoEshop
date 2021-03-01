package com.example.Shopv2.service;

import com.example.Shopv2.dto.ProductDTO;
import com.example.Shopv2.dtoconverter.ProductToDTOConverter;
import com.example.Shopv2.model.Merchant;
import com.example.Shopv2.model.Product;
import com.example.Shopv2.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final MerchantService merchantService;
    private final ProductToDTOConverter productToDTOConverter;

    public ProductService(ProductRepository productRepository, MerchantService merchantService, ProductToDTOConverter productToDTOConverter) {
        this.productRepository = productRepository;
        this.merchantService = merchantService;
        this.productToDTOConverter = productToDTOConverter;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()){
            return productOptional.get();
        } else {
            throw new IllegalStateException("Product with id " + id + " does not exists");
        }
    }


    public void addProduct(ProductDTO productDTO) {
        Product product = productToDTOConverter.dtoToEntity(productDTO);
        productRepository.save(product);
    }
}
