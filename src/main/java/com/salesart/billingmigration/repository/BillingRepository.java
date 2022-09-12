package com.salesart.billingmigration.repository;

import io.salesart.core.entities.Billing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface BillingRepository extends JpaRepository<Billing, Long> {
    List<Billing> findAllByDateLessThan(Date date);
}
