package com.example.Shopv2.service;

import com.example.Shopv2.dtoconverter.ProductToDTOConverter;
import com.example.Shopv2.model.Product;
import com.example.Shopv2.repository.ProductRepository;
import com.example.Shopv2.request.ProductUpdateRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Transactional
    public void updateProduct(Long id, ProductUpdateRequest productUpdateRequest) {
        Product product = getProductById(id);
        if (product != null){
            if (productUpdateRequest.getName() != null && productUpdateRequest.getName().length() > 0){
                product.setName(productUpdateRequest.getName());
            }
            if (productUpdateRequest.getDescription() != null && productUpdateRequest.getDescription().length() > 0){
                product.setDescription(productUpdateRequest.getDescription());
            }
            if (productUpdateRequest.getPrice() != null && productUpdateRequest.getPrice() >= 0){
                product.setPrice(productUpdateRequest.getPrice());
            }
            if (productUpdateRequest.getAvailable() != null && productUpdateRequest.getAvailable() >= 0){
                product.setAvailable(productUpdateRequest.getAvailable());
            }
        }
    }

    public void deleteProductById(Long id) {
        if (!productRepository.existsById(id)){
            throw new IllegalStateException("Product with id " + id + " does not exists");
        }
        productRepository.deleteById(id);
    }

    public void updateAvailableInternal(Long productId, int newAvailable){
        productRepository.updateAvailableInternal(productId.intValue(), newAvailable);
    }
}
