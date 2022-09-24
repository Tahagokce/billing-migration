package com.salesart.billingmigration.service.impl;

import com.salesart.billingmigration.entity.Customer;
import com.salesart.billingmigration.entity.CustomerRiskInfo;
import com.salesart.billingmigration.enums.OverRiskLimitEnum;
import com.salesart.billingmigration.exception.DateFormatException;
import com.salesart.billingmigration.repository.CustomerRepository;
import com.salesart.billingmigration.service.CustomerRiskInfoService;
import com.salesart.billingmigration.service.CustomerService;
import com.salesart.billingmigration.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;


@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerRiskInfoService customerRiskInfoService;

    @Value("${search.date}")
    private String searchDate;

    @SneakyThrows(DateFormatException.class)
    public List<Customer> createCustomerRiskInfo() {
        List<Customer> customers = findAllByCreateDateLessThanAndCustomerRiskInfoIsNull(DateUtil.convert(searchDate));
        List<CustomerRiskInfo> toBeSavedRiskInfoList = new ArrayList<>();

        customers.forEach(customer -> toBeSavedRiskInfoList.add(prepareRiskInfoForSave(customer.getRiskLimit(), customer.getOverRiskLimit())));

        Iterator<CustomerRiskInfo> customerRiskInfoIterator = customerRiskInfoService.saveAll(toBeSavedRiskInfoList).iterator();
        Iterator<Customer> customerIterator = customers.iterator();
        customers = new ArrayList<>();


        while (customerRiskInfoIterator.hasNext() && customerIterator.hasNext()) {
            CustomerRiskInfo customerRiskInfo = customerRiskInfoIterator.next();
            Customer customer = customerIterator.next();
            customer.setCustomerRiskInfo(customerRiskInfo);
            customers.add(customer);
        }

        return saveAll(customers);
    }

    public CustomerRiskInfo prepareRiskInfoForSave(BigDecimal riskLimit, OverRiskLimitEnum overRiskLimitEnum) {
        CustomerRiskInfo customerRiskInfo = new CustomerRiskInfo();
        customerRiskInfo.setIsDeleted(false);
        customerRiskInfo.setEnabled(true);
        customerRiskInfo.setRiskLimit(Objects.nonNull(riskLimit) ? riskLimit : BigDecimal.ZERO);
        customerRiskInfo.setOverRiskLimit(Objects.nonNull(overRiskLimitEnum) ? overRiskLimitEnum : OverRiskLimitEnum.ALERT);
        customerRiskInfo.setActualRiskLimit(BigDecimal.ZERO);
        return customerRiskInfo;
    }

    public List<Customer> findAllByCreateDateLessThanAndCustomerRiskInfoIsNull(Date createDate) {
        return customerRepository.findAllByCreateDateLessThanAndCustomerRiskInfoIsNull(createDate);
    }

    @Override
    public List<Customer> saveAll(List<Customer> customers) {
        return customerRepository.saveAll(customers);
    }
}
