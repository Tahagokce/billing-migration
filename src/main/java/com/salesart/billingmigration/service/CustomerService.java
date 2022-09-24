package com.salesart.billingmigration.service;

import com.salesart.billingmigration.entity.Customer;

import java.util.Date;
import java.util.List;

public interface CustomerService {
    List<Customer> findAllByCreateDateLessThanAndCustomerRiskInfoIsNull(Date createDate);

    List<Customer> saveAll(List<Customer> customers);

    List<Customer> createCustomerRiskInfo();
}
