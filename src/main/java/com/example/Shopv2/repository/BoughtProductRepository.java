package com.example.Shopv2.repository;

import com.example.Shopv2.model.BoughtProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoughtProductRepository extends JpaRepository<BoughtProduct, Long> {
}
