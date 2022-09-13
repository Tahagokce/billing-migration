package com.salesart.billingmigration.service.impl;

import com.salesart.billingmigration.entity.Billing;
import com.salesart.billingmigration.repository.BillingRepository;
import com.salesart.billingmigration.service.BillingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BillingServiceImpl implements BillingService {
    private final BillingRepository billingRepository;

    @Override
    public List<Billing> findAllByDateLessThen(Date date) {
        log.info("[BillingServiceImpl] -> [findAllByDateLessThen] : Calling invoices with less than date {}", date);
        return this.billingRepository.findAllByDateLessThan(date);
    }
}
