package com.gerald.accounts.repository;

import com.gerald.accounts.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customers, Long> {

    Optional<Customers> findByMobileNumber(String mobileNumber);
    Optional<Customers> findByEmail(String email);
}
