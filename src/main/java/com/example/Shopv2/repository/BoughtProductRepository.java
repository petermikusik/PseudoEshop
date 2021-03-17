package com.example.Shopv2.repository;

import com.example.Shopv2.model.BoughtProduct;
import com.example.Shopv2.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface BoughtProductRepository extends JpaRepository<BoughtProduct, Long> {

    @Query(value = "select * from bought_product where customer_id = ?1", nativeQuery = true)
    List<BoughtProduct> findBoughtProductByCustomerId(int customerId);
}
