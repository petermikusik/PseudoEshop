package com.example.Shopv2.request;

import java.util.Objects;

public class BuyProductRequest {
    private Long pruductId;
    private Long customerId;
    private int quantity;

    public BuyProductRequest(Long pruductId, Long customerId, int quantity) {
        this.pruductId = pruductId;
        this.customerId = customerId;
        this.quantity = quantity;
    }

    public Long getPruductId() {
        return pruductId;
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
        return quantity == that.quantity && Objects.equals(pruductId, that.pruductId) && Objects.equals(customerId, that.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pruductId, customerId, quantity);
    }
}
