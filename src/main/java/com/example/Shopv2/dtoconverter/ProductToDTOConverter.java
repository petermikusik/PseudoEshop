package com.example.Shopv2.dtoconverter;

import com.example.Shopv2.dto.ProductDTO;
import com.example.Shopv2.model.Merchant;
import com.example.Shopv2.model.Product;
import com.example.Shopv2.service.MerchantService;
import org.springframework.stereotype.Component;

@Component
public class ProductToDTOConverter {
    private final MerchantService merchantService;

    public ProductToDTOConverter(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    public Product dtoToEntity(ProductDTO dto){
        Merchant merchant = merchantService.getMerchantById(dto.getMerchantId());
        if (merchant != null){
            Product product = new Product(merchant, dto.getName(), dto.getDescription(), dto.getPrice(), dto.getAvailable());
            return product;
        } else {
            throw new IllegalStateException("Merchant with id " + dto.getMerchantId() + " does not exists");
        }
    }

    public ProductDTO entityToDto(Product product){
        ProductDTO dto = new ProductDTO();
        dto.setAvailable(product.getAvailable());
        dto.setMerchantId(product.getMerchant().getId());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setCreatedAt(product.getCreatedAt());
        dto.setName(product.getName());
        dto.setId(product.getId());
        return dto;
    }
}
