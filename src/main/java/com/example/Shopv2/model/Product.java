package com.example.Shopv2.model;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private Long id;
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "merchant"))
    private Merchant merchant;
    private String name;
    private String description;
    private Double price;
    @Nullable
    private Timestamp createdAt;
    private int available;

    public Product() {
    }

    public Product(Merchant merchant, String name, String description, Double price, @Nullable Timestamp createdAt, int available) {
        this.merchant = merchant;
        this.name = name;
        this.description = description;
        this.price = price;
        this.createdAt = createdAt;
        this.available = available;
    }

    public Product(@Nullable Long id, Merchant merchant, String name, String description, Double price, @Nullable Timestamp createdAt, int available) {
        this.id = id;
        this.merchant = merchant;
        this.name = name;
        this.description = description;
        this.price = price;
        this.createdAt = createdAt;
        this.available = available;
    }

    @Nullable
    public Long getId() {
        return id;
    }

    public void setId(@Nullable Long id) {
        this.id = id;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
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

    @Nullable
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(@Nullable Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", merchant=" + merchant +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", createdAt=" + createdAt +
                ", available=" + available +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return available == product.available && Objects.equals(id, product.id) && Objects.equals(merchant, product.merchant) && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(price, product.price) && Objects.equals(createdAt, product.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, merchant, name, description, price, createdAt, available);
    }
}
