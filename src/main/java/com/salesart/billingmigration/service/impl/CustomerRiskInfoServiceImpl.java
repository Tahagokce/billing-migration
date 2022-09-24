package com.salesart.billingmigration.service.impl;

import com.salesart.billingmigration.entity.CustomerRiskInfo;
import com.salesart.billingmigration.repository.CustomerRiskInfoRepository;
import com.salesart.billingmigration.service.CustomerRiskInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerRiskInfoServiceImpl implements CustomerRiskInfoService {
    private final CustomerRiskInfoRepository customerRiskInfoRepository;

    @Override
    public List<CustomerRiskInfo> saveAll(List<CustomerRiskInfo> customerRiskInfoList) {
        log.info("[CustomerRiskInfoServiceImpl] -> [saveAll] : Number of users to register " +customerRiskInfoList.size());
        return customerRiskInfoRepository.saveAll(customerRiskInfoList);
    }
}
