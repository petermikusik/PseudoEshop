package com.example.Shopv2.request;

import java.util.Objects;

public class BuyProductRequest {
    private Long productId;
    private Long customerId;
    private int quantity;

    public BuyProductRequest(Long productId, Long customerId, int quantity) {
        this.productId = productId;
        this.customerId = customerId;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuyProductRequest that = (BuyProductRequest) o;
        return quantity == that.quantity && Objects.equals(productId, that.productId) && Objects.equals(customerId, that.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, customerId, quantity);
    }
}
