package com.salesart.billingmigration.repository;

import com.salesart.billingmigration.entity.Billing;
import com.salesart.billingmigration.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface BillingRepository extends JpaRepository<Invoice, Long> {
    List<Billing> findAllByDateLessThan(Date date);
}
