package com.trax.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trax.entities.Bill;

public interface BillingRepository extends JpaRepository<Bill, Long> {

}
