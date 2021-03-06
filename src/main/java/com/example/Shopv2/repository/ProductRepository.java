package com.example.Shopv2.repository;

import com.example.Shopv2.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Modifying
    @Transactional
    @Query(value = "update product set available = ?2 where id = ?1", nativeQuery = true)
    void updateAvailableInternal(int id, int newAvailable);
}
