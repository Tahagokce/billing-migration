package com.salesart.billingmigration.repository;

import com.salesart.billingmigration.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer,Long> {
    List<Customer> findAllByCreateDateLessThanAndCustomerRiskInfoIsNull(Date createData);
}
