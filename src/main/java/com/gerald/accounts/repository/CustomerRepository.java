package com.gerald.accounts.repository;

import com.gerald.accounts.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customers, Long> {
}
