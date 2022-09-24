package com.salesart.billingmigration.repository;

import com.salesart.billingmigration.entity.CustomerRiskInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRiskInfoRepository extends JpaRepository<CustomerRiskInfo, Long> {
}
