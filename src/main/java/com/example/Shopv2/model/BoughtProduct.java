package com.example.Shopv2.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;

@Entity
public class BoughtProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "customer_id_bought"))
    private Product product;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "product_id"))
    private Customer customer;
    private int quantity;
    private Timestamp boughtAt;

    public BoughtProduct() {
    }

    public BoughtProduct(Product product, Customer customer, int quantity) {
        this.product = product;
        this.customer = customer;
        this.quantity = quantity;
        this.boughtAt = Timestamp.from(Instant.now());
    }

    public BoughtProduct(Long id, Product product, Customer customer, int quantity, Timestamp boughtAt) {
        this.id = id;
        this.product = product;
        this.customer = customer;
        this.quantity = quantity;
        this.boughtAt = boughtAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Timestamp getBoughtAt() {
        return boughtAt;
    }

    public void setBoughtAt(Timestamp boughtAt) {
        this.boughtAt = boughtAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoughtProduct that = (BoughtProduct) o;
        return quantity == that.quantity && Objects.equals(id, that.id) && Objects.equals(product, that.product) && Objects.equals(customer, that.customer) && Objects.equals(boughtAt, that.boughtAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, customer, quantity, boughtAt);
    }

    @Override
    public String toString() {
        return "BoughtProduct{" +
                "id=" + id +
                ", product=" + product +
                ", customer=" + customer +
                ", quantity=" + quantity +
                ", boughtAt=" + boughtAt +
                '}';
    }
}
