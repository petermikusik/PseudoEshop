package com.example.Shopv2.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class CustomerAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "customer_id"))
    private Customer customer;
    private double money;

    public CustomerAccount() {
    }

    public CustomerAccount(Customer customer, double money) {
        this.customer = customer;
        this.money = money;
    }

    public CustomerAccount(Long id, Customer customer, double money) {
        this.id = id;
        this.customer = customer;
        this.money = money;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerAccount that = (CustomerAccount) o;
        return Double.compare(that.money, money) == 0 && Objects.equals(id, that.id) && Objects.equals(customer, that.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, money);
    }

    @Override
    public String toString() {
        return "CustomerAccount{" +
                "id=" + id +
                ", customer=" + customer +
                ", money=" + money +
                '}';
    }
}
