package com.example.Shopv2.repository;

import com.example.Shopv2.model.CustomerAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAccountRepository extends JpaRepository<CustomerAccount, Long> {

    @Query(value = "select money from customer_account where customer_id = ?1", nativeQuery = true)
    double getMoneyByCustomerId(int customerId);

    @Query(value = "update customer_account set money = money + ?2 where customer_id = ?1", nativeQuery = true)
    void addMoneyByCustomerId(int customerId, double value);
}
