package com.example.Shopv2.repository;

import com.example.Shopv2.model.BoughtProduct;
import com.example.Shopv2.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface BoughtProductRepository extends JpaRepository<BoughtProduct, Long> {

    @Query("select b from bought_product b where b.customer_id = ?1")
    ArrayList<BoughtProduct> findBoughtProductByCustomerId(Long customerId);
}
