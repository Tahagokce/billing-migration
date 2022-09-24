package com.salesart.billingmigration.service;

import com.salesart.billingmigration.entity.CustomerRiskInfo;

import java.util.List;

public interface CustomerRiskInfoService {
    List<CustomerRiskInfo> saveAll(List<CustomerRiskInfo> customerRiskInfoList);
}
