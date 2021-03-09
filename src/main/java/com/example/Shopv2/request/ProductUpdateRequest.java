package com.example.Shopv2.request;

import java.util.Objects;

public class ProductUpdateRequest {
    private String name;
    private String description;
    private Double price;
    private Integer available;

    public ProductUpdateRequest(String name, String description, Double price, Integer available) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductUpdateRequest that = (ProductUpdateRequest) o;
        return Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(price, that.price) && Objects.equals(available, that.available);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, price, available);
    }
}
